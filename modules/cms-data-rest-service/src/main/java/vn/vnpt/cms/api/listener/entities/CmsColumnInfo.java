package vn.vnpt.cms.api.listener.entities;

public class CmsColumnInfo {
    private int columnId;
    private String oldName;
    private String value;
    private String name;
    private String dataType;
    private String length;
    private String defaultValue;
    private boolean notNull;
    private boolean isSearch;
    private boolean hiddenStatus;

    public CmsColumnInfo() {
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
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

    public boolean isSearch() {
        return isSearch;
    }

    public void setSearch(boolean search) {
        isSearch = search;
    }

    public boolean isHiddenStatus() {
        return hiddenStatus;
    }

    public void setHiddenStatus(boolean hiddenStatus) {
        this.hiddenStatus = hiddenStatus;
    }
}
