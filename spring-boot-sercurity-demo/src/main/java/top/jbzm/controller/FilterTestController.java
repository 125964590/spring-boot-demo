package top.jbzm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengyi
 * @date 2018/8/30 5:28 PM
 **/
@RestController
@RequestMapping("/user")
public class FilterTestController {

    @GetMapping("/ok")
    public String test01() {
        return "ok";
    }
}