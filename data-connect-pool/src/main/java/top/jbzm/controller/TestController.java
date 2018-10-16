package top.jbzm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengyi
 * @date 2018/10/15 4:42 PM
 **/
@RestController("controll")
public class TestController {

    @GetMapping("test01")
    public String test01() {
        return "I'm test01.";
    }
}