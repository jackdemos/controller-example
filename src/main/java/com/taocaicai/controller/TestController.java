package com.taocaicai.controller;

import com.taocaicai.common.Result;
import com.taocaicai.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Oakley
 * @project controller-example
 * @created 2023-05-15 10:20:10:20
 * @package com.taocaicai.controller
 * @since 0.0.1
 */
@RestController
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
    public Map<String,String> getMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("email","zhangsan@sina.com");
        return map;
    }
    @GetMapping(value = "/returnRs", produces = "application/json; charset=UTF-8")
    public Result<String> getRs(){
        return (Result<String>) Result.failed("网络错误");
    }

    @GetMapping(value="/user",produces = "application/json; charset=UTF-8")
    public User getUser(){
       return new User(10001L,"zhangsan","zhangsan@sina.com",22);
    }
}
