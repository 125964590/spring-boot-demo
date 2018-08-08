package top.jbzm.demo.rediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jbzm.demo.rediscache.service.TestService;

/**
 * @author zhengyi
 * @date 2018/7/26 5:49 PM
 **/
@RestController
public class CacheTestController {

    private final TestService testService;

    @Autowired
    public CacheTestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("test01")
    public String test01() {
        return testService.getTestData01();
    }

    @GetMapping("test02")
    public String test02() {
        return testService.getTestData02();
    }

    @GetMapping("test03")
    public Object test03() {
        return testService.lol();
    }
}