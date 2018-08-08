package top.jbzm.demospringdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jbzm
 * @date 2018上午10:14
 **/
@Getter
@Setter
@AllArgsConstructor
public class UserDtoForCheck{
    private String username;
    private String password;
}