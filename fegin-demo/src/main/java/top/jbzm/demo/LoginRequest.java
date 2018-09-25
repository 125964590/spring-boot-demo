package top.jbzm.demo;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhengyi
 * @date 2018/9/6 9:12 PM
 **/
@Data
@Builder
public class LoginRequest {

    private String username;

    private String password;
}