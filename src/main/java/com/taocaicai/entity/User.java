package com.taocaicai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Oakley
 * @project controller-example
 * @created 2023-05-15 12:47:12:47
 * @package com.taocaicai.entity
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long userId;
    private String userName;
    private String password;
    private String email;
    private Integer age;
}
