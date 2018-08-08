package top.jbzm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.UUID;
import java.util.function.Function;

/**
 * @author jbzm
 * @date Create on 2018/3/7 17:49
 */
@RestController
@RequestMapping("/security")
public class SecurityController {


    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/toLogin")
    public Object toLogin(HttpServletRequest request, HttpServletResponse response) {
        return "跳转登录页";
    }

    @PostMapping("/success/login")
    public Object successLogin() {
        String token = UUID.randomUUID().toString();

        return "登录成功";
    }

    @GetMapping("/false")
    public Object loginFalse() {
        return "登录失败";
    }

    @GetMapping("/success/logout")
    public Object successLogout() {
        return "登出成功";
    }

    @GetMapping("/denied")
    public Object denied() {
        return "权限不足";
    }
}
