package vn.vnpt.cms.api.constants;

public enum ExportType {
    PDF(1),
    CSV(0);

    private final int value;

    ExportType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
