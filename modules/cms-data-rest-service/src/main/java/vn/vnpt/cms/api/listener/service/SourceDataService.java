package vn.vnpt.cms.api.listener.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import vn.vnpt.cms.api.config.CoreConfig;
import vn.vnpt.cms.api.controller.channels.CmsCatalogExportTmp;
import vn.vnpt.cms.api.controller.channels.SourceDataExportCmd;
import vn.vnpt.cms.api.controller.channels.SourceDataImportCmd;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author QuangChu
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/source_data",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Source.RestService",
                "auth.verifier.guest.allowed=true",
                "liferay.access.control.disable=true"
        },
        service = Application.class
)
public class SourceDataService extends BaseService {
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @GET
    @Path("greeting")
    public Response greeting() {
        _log.info("Hello source data service !!!!");
        return Response.ok("This is source data service !!!!").build();
    }

    @POST
    @Path("/import")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadDataCatalog(@QueryParam("channel") String channel, @QueryParam("transId") String transId, @QueryParam("catalogId") Integer catalogId) {
        _log.info("CatalogId: " + catalogId);
        InputStream inputStream = null;
        Response.ResponseBuilder builder;
        try {
            if (ServletFileUpload.isMultipartContent(this.httpServletRequest)) {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(this.httpServletRequest);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        inputStream = item.getInputStream();
                    }
                }
            }
            SourceDataImportCmd cmd = new SourceDataImportCmd(this.httpServletRequest, channel, transId, inputStream, catalogId);
            cmd.execute();
            return cmd.getResponse();
        } catch (Exception e) {
            _log.error(e);
            builder = Response.status(Response.Status.SERVICE_UNAVAILABLE.getStatusCode());
            builder.entity(e.toString());
        }
        return builder.build();
    }

    @GET
    @Path("/export/template")
    public Response downloadTmpExcel(@QueryParam("catalogId") Integer catalogId, @QueryParam("transId") String transId, @QueryParam("channel") String channel) {
        long catalogIdL = catalogId.longValue();
        _log.info("Start export excel template for catalogId: " + catalogIdL);
        CmsCatalogExportTmp cmsCatalogExportTmp = new CmsCatalogExportTmp(this.httpServletRequest, channel, transId, catalogIdL);
        cmsCatalogExportTmp.execute();
        final String fileTemp = cmsCatalogExportTmp.getFileTemp();
        String mediaType;

        MimetypesFileTypeMap mimeType = new MimetypesFileTypeMap();
        mimeType.addMimeTypes("application/pdf pdf");
        mimeType.addMimeTypes("image/png png PNG");
        mimeType.addMimeTypes("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String fileName = fileTemp.replace(CoreConfig.TEMP_DIR, "");

        mediaType = mimeType.getContentType(fileTemp);
        StreamingOutput fileStream = output -> {
            try {
                java.nio.file.Path path = Paths.get(fileTemp);
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception var7) {
                throw new WebApplicationException(404);
            } finally {
                output.close();
            }
        };
        File file = new File(fileTemp);
        if (file.exists()) {
            boolean isDeleted = file.delete();
        }
        return Response.ok(fileStream, mediaType)
                .header("Content-Disposition", "attachment; filename = " + fileName)
                .header("charset", "utf-8").build();
    }

    @GET
    @Path("export")
    public Response exportFile(@QueryParam("channel") String channel, @QueryParam("transId") String transId,
                               @QueryParam("catalogId") Integer catalogId, @QueryParam("type") int type) {
        SourceDataExportCmd cmd = new SourceDataExportCmd(this.httpServletRequest, channel, transId, catalogId, type);
        cmd.execute();
        final String fileTemp = cmd.getFileTemp();
        String mediaType;

        MimetypesFileTypeMap mimeType = new MimetypesFileTypeMap();
        mimeType.addMimeTypes("application/pdf pdf");
        mimeType.addMimeTypes("image/png png PNG");
        mimeType.addMimeTypes("text/csv");
        String fileName = fileTemp.replace(CoreConfig.TEMP_DIR, "");

        mediaType = mimeType.getContentType(fileTemp);

        StreamingOutput fileStream = output -> {
            try {
                java.nio.file.Path path = Paths.get(fileTemp);
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception ex) {
                throw new WebApplicationException(404);
            }

        };

        return Response.ok(fileStream, mediaType)
                .header("Content-Disposition", "attachment; filename = " + fileName)
                .header("charset", "utf-8").build();
    }

    private final static Log _log = LogFactoryUtil.getLog(SourceDataService.class);
}
