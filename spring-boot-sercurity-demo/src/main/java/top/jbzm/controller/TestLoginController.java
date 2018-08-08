package top.jbzm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jbzm.common.ErrorResult;
import top.jbzm.exception.MyException;

/**
 * @author jbzm
 * @date Create on 2018/3/7 15:41
 */
@RestController
public class TestLoginController {
    @GetMapping("lol")
    public Object testLol() {
        throw new MyException(ErrorResult.create(66666, "lol"));
    }

    @GetMapping("resources/lol")
    public Object testResources() {
        return "成功/resources";
    }

    @GetMapping("admin/lol")
    public Object testAdmin() {
        return "成功/admin";
    }

    @GetMapping("db/lol")
    public Object testDba() {
        return "成功/db";
    }
}
