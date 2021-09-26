package vn.vnpt.cms.api.listener.entities;

public class ColumnData {
    private String dataType;
    private String name;
    private String value;

    public ColumnData() {
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return "ColumnData [dataType=" + this.dataType + ", name=" + this.name + ", value=" + this.value + "]";
    }
}
