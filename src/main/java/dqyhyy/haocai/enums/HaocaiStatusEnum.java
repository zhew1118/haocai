package dqyhyy.haocai.enums;

public enum HaocaiStatusEnum implements CodeEnum{
    UP(1, "在架"),
    DOWN(0, "下架")
    ;

    private Integer code;

    private String message;

    HaocaiStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
