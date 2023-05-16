package com.taocaicai.entity;

import com.taocaicai.validate.Mobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Oakley
 * @project controller-example
 * @created 2023-05-16 13:03:13:03
 * @package com.taocaicai.entity
 * @since 0.0.1
 */
@Data
public class Employee {

    //Integer和Long一类的数值类型使用NotNull判断
    @NotNull(message = "empId不允许为空")
    private long empId;

    @NotBlank
    @Length(min = 4, max = 16)
    private String password;

    private String email;


    @Mobile(require = false)
    private String mobile;

    @NotNull
    @Min(value = 0,message = "年龄不能低于0岁")
    @Max(value = 150,message = "最大值不能超过150岁")
    private int age;
}
