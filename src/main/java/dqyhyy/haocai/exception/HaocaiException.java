package dqyhyy.haocai.exception;

import dqyhyy.haocai.enums.ResultEnum;

/**
 * 自定义异常
 */
public class HaocaiException extends RuntimeException {

    private Integer code;

    public HaocaiException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public HaocaiException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
