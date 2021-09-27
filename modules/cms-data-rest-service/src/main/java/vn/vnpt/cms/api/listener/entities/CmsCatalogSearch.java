package vn.vnpt.cms.api.listener.entities;

public class CmsCatalogSearch {
    private String name;
    private String value;
    private String dataType;
    private long catalogId;

    public CmsCatalogSearch() {
    }

    public CmsCatalogSearch(String name, String value, String dataType, long catalogId) {
        this.name = name;
        this.value = value;
        this.dataType = dataType;
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(long catalogId) {
        this.catalogId = catalogId;
    }
}
