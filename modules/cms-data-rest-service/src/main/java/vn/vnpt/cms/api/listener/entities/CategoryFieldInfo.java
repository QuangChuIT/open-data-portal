package vn.vnpt.cms.api.listener.entities;

public class CategoryFieldInfo {
    private long entryId;
    private String name;
    private String code;
    private String dataType;
    private String format;
    private String defaultValue;
    private boolean notNull;

    public CategoryFieldInfo() {
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public String toString() {
        return "CategoryFieldInfo{entryId=" + this.entryId + ", code='" + this.code + '\'' + ", name='" + this.name + '\'' + ", dataType='" + this.dataType + '\'' + ", format='" + this.format + '\'' + ", defaultValue='" + this.defaultValue + '\'' + ", notNull=" + this.notNull + '}';
    }
}
