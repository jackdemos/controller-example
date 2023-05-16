package com.taocaicai.controller;

import com.taocaicai.common.Result;
import com.taocaicai.entity.Employee;
import com.taocaicai.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Oakley
 * @project controller-example
 * @created 2023-05-15 10:20:10:20
 * @package com.taocaicai.controller
 * @since 0.0.1
 */
@RestController
@Validated
public class TestController {

    @GetMapping(value = "/returnString", produces = "application/json; charset=UTF-8")
    public String returnString() {
        return "success";
    }

    @GetMapping(value = "/returnInt", produces = "application/json; charset=UTF-8")
    public Integer returnInt() {
        return 1;
    }

    @GetMapping(value = "/returnMap", produces = "application/json; charset=UTF-8")
    public Map<String, String> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("email", "zhangsan@sina.com");
        return map;
    }

    @GetMapping(value = "/returnRs", produces = "application/json; charset=UTF-8")
    public Result<String> getRs() {
        return (Result<String>) Result.failed("网络错误");
    }

    @GetMapping(value = "/user", produces = "application/json; charset=UTF-8")
    public User getUser() {
        return new User(10001L, "zhangsan", "zhangsan", "zhangsan@sina.com", 22);
    }

    @GetMapping(value = "/userList", produces = "application/json; charset=UTF-8")
    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        users.add(new User(10001L, "zhangsan", "zhangsang", "zhangsan@sina.com", 27));
        users.add(new User(10002L, "lisi", "lisi12", "lisi@sina.com", 22));
        users.add(new User(10003L, "wangwu", "wangwu1", "wangwu@sina.com", 33));
        return users;
    }

    @GetMapping("/num/{num}")
    public Integer detail(@PathVariable("num") @Min(1) @Max(5) Integer num) {
        return num * num;
    }

    @PostMapping("/test-validation")
    public Employee testValidation(@RequestBody @Valid Employee employee) {
        return employee;
    }
}
