package vn.vnpt.cms.api.controller.channels;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import org.osgi.service.component.annotations.Component;
import vn.vnpt.cms.api.cmd.DbCmsCatalogCreateCmd;
import vn.vnpt.cms.api.controller.base.AbsApiBaseBodyReqTypeCmd;
import vn.vnpt.cms.api.kernel.util.VNCharacterUtils;
import vn.vnpt.cms.api.listener.entities.CmsColumnInfo;
import vn.vnpt.cms.api.listener.request.CmsCategoryCreateReq;
import vn.vnpt.cms.api.listener.response.BaseResp;
import vn.vnpt.data.cms.model.Catalog;
import vn.vnpt.data.cms.model.CatalogFieldName;
import vn.vnpt.data.cms.service.CatalogFieldNameLocalServiceUtil;
import vn.vnpt.data.cms.service.CatalogLocalServiceUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = {})
public class CmsCatalogInsertCmd extends AbsApiBaseBodyReqTypeCmd {
    private String title;
    private int catType;
    private String tableName;
    private String description;
    private String version;
    private boolean visibility;
    private List<CmsColumnInfo> lstColumns = new ArrayList<>();

    public CmsCatalogInsertCmd() {
        super();
    }

    public CmsCatalogInsertCmd(HttpServletRequest httpServletRequest, String jsonRequest, Class<?> classRequest) {
        super(httpServletRequest, jsonRequest, classRequest);
    }

    protected void executeCmd() throws Exception {
        //Create table
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("CREATE TABLE `");
        strBuilder.append(this.tableName);
        strBuilder.append("`( `id` int(100) NOT NULL AUTO_INCREMENT,");

        for (CmsColumnInfo columnInfo : this.lstColumns) {
            String value = VNCharacterUtils.removeAccent(columnInfo.getName()).trim().replaceAll("\\s+", "_").toLowerCase();
            strBuilder.append("`");
            strBuilder.append(value);
            strBuilder.append("` ");
            if (columnInfo.getDataType().equals("VARCHAR")) {
                strBuilder.append("VARCHAR(");
                strBuilder.append(columnInfo.getLength());
                strBuilder.append(") CHARACTER SET utf8mb4 ");
            } else if (columnInfo.getDataType().equals("BIGINT")) {
                strBuilder.append("BIGINT(");
                strBuilder.append(columnInfo.getLength());
                strBuilder.append(")");
            } else {
                //column type date
                strBuilder.append(" DATETIME ");
            }

            strBuilder.append("DEFAULT ");
            if (columnInfo.getDefaultValue() != null && !columnInfo.getDefaultValue().equals("")) {
                strBuilder.append("'");
                strBuilder.append(columnInfo.getDefaultValue());
                strBuilder.append("'");
            } else {
                strBuilder.append("NULL");
            }

            strBuilder.append(",");
        }
        strBuilder.append("`status` int(5) DEFAULT 1, ");
        strBuilder.append("`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP, ");

        strBuilder.append("`modify_time` DATETIME DEFAULT CURRENT_TIMESTAMP, ");
        /*if (this.catType == 1) {
            strBuilder.append("`level` VARCHAR(5) DEFAULT '0',");
        }

        strBuilder.append("PRIMARY KEY (`id`) USING BTREE, UNIQUE KEY `code` (`code`)");
        if (this.catType == 1) {
            strBuilder.append(", FULLTEXT KEY `level` (`level`) ");
        }*/

        strBuilder.append("PRIMARY KEY (`id`) USING BTREE) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4");
        String sql_query = strBuilder.toString();
        _log.info(sql_query);
        DbCmsCatalogCreateCmd dbCmd = new DbCmsCatalogCreateCmd(this.transId, this.channel,
                sql_query, this.tableName);
        this.executeDbCmd(dbCmd);
        this.objResponse = new BaseResp(dbCmd.getCode(), dbCmd.getMessage());
        if (this.objResponse.getError().getCode() == 200) {
            // Create Catalog
            ServiceContext serviceContext = ServiceContextFactory.getInstance(this.httpServletRequest);
            String tableName = VNCharacterUtils.removeAccent(this.title).trim()
                    .replaceAll("\\s+", "_").toLowerCase();
            Catalog catalog = CatalogLocalServiceUtil.addCatalog(serviceContext.getUserId(), tableName, title, description, version, visibility, serviceContext);

            //Create Catalog Field
            for (CmsColumnInfo cmsColumnInfo : lstColumns) {
                String code = VNCharacterUtils.removeAccent(cmsColumnInfo.getName()).trim().replaceAll("\\s+", "_").toLowerCase();
                CatalogFieldName catalogFieldName = CatalogFieldNameLocalServiceUtil
                        .addCatalogFieldName(serviceContext.getUserId(), catalog.getCatalogId(), code, cmsColumnInfo.getName(),
                                cmsColumnInfo.getDataType(), cmsColumnInfo.getDefaultValue(), cmsColumnInfo.isNotNull(), cmsColumnInfo.getLength(),
                                cmsColumnInfo.isSearch(), cmsColumnInfo.isHiddenStatus(), serviceContext);
            }
            _log.info("Save success catalog and catalog field to database !!!!!");
        } else {
            _log.error("Save fail catalog and catalog field to database cause " + this.objResponse.getError().getMessage());
        }
        /*this.logToDb();*/
    }

    protected boolean validateData() {
        this.title = ((CmsCategoryCreateReq) this.objRequest).getTitle();
        this.catType = ((CmsCategoryCreateReq) this.objRequest).getCatType();
        this.tableName = VNCharacterUtils.removeAccent(this.title).trim()
                .replaceAll("\\s+", "_").toLowerCase();
        this.lstColumns = ((CmsCategoryCreateReq) this.objRequest).getLstColumns();
        this.description = ((CmsCategoryCreateReq) this.objRequest).getDescription();
        this.visibility = ((CmsCategoryCreateReq) this.objRequest).isVisibility();
        this.version = ((CmsCategoryCreateReq) this.objRequest).getVersion();
        return true;
    }

    private final static Log _log = LogFactoryUtil.getLog(CmsCatalogInsertCmd.class);
}
