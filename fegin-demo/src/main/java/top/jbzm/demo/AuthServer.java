package top.jbzm.demo;

import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhengyi
 * @date 2018/9/8 9:32 PM
 **/
public interface AuthServer {

    @RequestLine("POST /auth/login")
    @Headers("Content-Type: application/json")
    public ResponseData login(@RequestBody LoginRequest loginRequest);
}