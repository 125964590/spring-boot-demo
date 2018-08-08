package top.jbzm.rabbitmq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jbzm
 * @date Create on 2018/3/19 14:42
 */
@RestController
@RequestMapping("aop")
public class AopTest {
    @GetMapping("test01")
    public String test01(String lol) {
        return "ok"+lol;
    }
}
