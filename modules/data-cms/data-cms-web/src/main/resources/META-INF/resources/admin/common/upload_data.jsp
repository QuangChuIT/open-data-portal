<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="vn.vnpt.data.cms.contansts.DataCmsPortletKeys" %>
<%@ page import="vn.vnpt.data.cms.model.Catalog" %>
<%@ include file="/admin/common/init.jsp" %>
<%
    Catalog catalog = (Catalog) request.getAttribute(DataCmsPortletKeys.CATALOG);

    long catalogId = BeanParamUtil.getLong(catalog, request, "catalogId");
%>
<div class="progress" id="upload-data-process" style="height: 0.2rem;">
    <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
         style="width: 0;">
    </div>
</div>
<div class="drag-area" id="drop-area">
    <div class="icon text-center"><i class="icon-cloud-upload" aria-hidden="true"></i></div>
    <header id="headerUpload" class="mb-2"><%=LanguageUtil.get(request, "click-to-upload")%>
    </header>
    <button class="btn btn-primary mb-3" id="uploadDataCat"><%=LanguageUtil.get(request, "upload")%>
    </button>
    <input type="hidden" name="catalogId" id="catalogId" value="<%=catalogId%>">
    <input type="file" name="uploadInput" hidden id="uploadInput">
    <a href="javascript:void(0)" id="downloadUpload"
       onclick="catalog.downloadTmp()"><%=LanguageUtil.get(request, "template-catalog")%>
    </a>
</div>
