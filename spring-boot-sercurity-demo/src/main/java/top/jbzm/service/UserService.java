package top.jbzm.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author jbzm
 * @date Create on 2018/3/12 11:05
 */
public interface UserService extends UserDetailsService {
    UserDetails loadByUsernameAndPassword(String username, String password);

}
