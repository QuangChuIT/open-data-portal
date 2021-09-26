package vn.vnpt.portlet.article.publisher.cache;

import java.io.Serializable;
import java.util.Date;

public class AssetEntryCache implements Serializable {
    public long getEntryId() {

        return entryId;
    }

    public void setEntryId(long entryId) {

        this.entryId = entryId;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public long getClassNameId() {

        return classNameId;
    }

    public void setClassNameId(long classNameId) {

        this.classNameId = classNameId;
    }

    public long getClassPK() {

        return classPK;
    }

    public void setClassPK(long classPK) {

        this.classPK = classPK;
    }

    public Date getPublishDate() {

        return publishDate;
    }

    public void setPublishDate(Date publishDate) {

        this.publishDate = publishDate;
    }

    public String getSummary() {

        return summary;
    }

    public void setSummary(String summary) {

        this.summary = summary;
    }

    public String getSmallImagePath() {

        return smallImagePath;
    }

    public void setSmallImagePath(String smallImagePath) {

        this.smallImagePath = smallImagePath;
    }

    public String getViewContentURL() {

        return viewContentURL;
    }

    public void setViewContentURL(String viewContentURL) {

        this.viewContentURL = viewContentURL;
    }

    private long entryId;
    private long classNameId;
    private long classPK;
    private String title;
    private String summary;
    private String smallImagePath;
    private String viewContentURL;
    private Date publishDate;
}
