package top.jbzm.controller;

import com.ht.base.common.ErrorResult;
import com.ht.base.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
