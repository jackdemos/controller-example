package com.taocaicai.exception;

/**
 * @project controller-example
 * @author Oakley
 * @created 2023-05-16 14:25:14:25
 * @package com.taocaicai.exception
 * @since 0.0.1
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
