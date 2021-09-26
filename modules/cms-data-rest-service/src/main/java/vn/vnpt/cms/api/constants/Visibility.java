package vn.vnpt.cms.api.constants;

public enum Visibility {
    PUBLIC(1),
    PRIVATE(0);

    private final Integer code;

    Visibility(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
