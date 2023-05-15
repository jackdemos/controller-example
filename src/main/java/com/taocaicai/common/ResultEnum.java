package com.taocaicai.common;

/**
 * @author Oakley
 * @project controller-example
 * @created 2023-05-15 10:06:10:06
 * @package com.taicaicai.common
 * @since 0.0.1
 */
public enum ResultEnum implements IResult {
    SUCCESS(2001, "接口调用成功"),

    VALIDATE_FAILED(2002, "参数校验失败"),

    COMMON_FAILED(2003, "接口调用失败"),

    FORBIDDEN(2004, "没有权限访问资源");

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
