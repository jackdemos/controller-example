package com.taocaicai.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义手机号验证注解
 *
 * @author Oakley
 * @project controller-example
 * @created 2023-05-16 13:33:13:33
 * @package com.taocaicai.validate
 * @since 0.0.1
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MobileValidator.class)
public @interface Mobile {
    /**
     * 是否允许为空
     *
     * @return
     */
    boolean require() default true;

    String message() default "不是一个有效的手机号格式";

    /**
     * 以下两行必不可少
     * Constraint要求的属性，用于分组校验和扩展，留空就好
     *
     * @return
     */
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
