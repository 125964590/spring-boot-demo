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
public class SecurityController {


    private final RedisTemplate redisTemplate;

    @Autowired
    public SecurityController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/login")
    public Object toLogin(HttpServletRequest request, HttpServletResponse response) {
        return "跳转登录页";
    }

    @PostMapping("/login/success")
    public Object successLogin() {
        String token = UUID.randomUUID().toString();

        return "登录成功";
    }

    @GetMapping("/login/fail")
    public Object loginFalse() {
        return "登录失败";
    }

    @GetMapping("/logout/success")
    public Object successLogout() {
        return "登出成功";
    }

    @GetMapping("/denied")
    public Object denied() {
        return "权限不足";
    }
}
