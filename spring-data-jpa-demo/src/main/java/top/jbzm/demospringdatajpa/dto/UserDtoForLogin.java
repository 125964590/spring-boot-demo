package top.jbzm.demospringdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jbzm
 * @date 2018上午8:13
 **/
@Getter
@Setter
@AllArgsConstructor
public class UserDtoForLogin {
    String username,password;
}
