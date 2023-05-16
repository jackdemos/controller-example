package com.taocaicai.validate;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oakley
 * @project controller-example
 * @created 2023-05-16 13:37:13:37
 * @package com.taocaicai.validate
 * @since 0.0.1
 */
public class MobileValidator implements ConstraintValidator<Mobile, CharSequence> {

    private boolean required = false;

    //验证手机号
    private final Pattern pattern = Pattern.compile("^1[345789][0-9]{9}$");

    /**
     * 验证参数的合法性
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return
     */
    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (this.required) {
            return isMobile(value);
        }
        if (StringUtils.hasText(value)) {
            return isMobile(value);
        }

        return true;
    }

    @Override
    public void initialize(Mobile constraintAnnotation) {
        this.required = constraintAnnotation.require();
    }

    private boolean isMobile(CharSequence str) {
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
}
