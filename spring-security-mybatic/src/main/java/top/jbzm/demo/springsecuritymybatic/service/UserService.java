package top.jbzm.demo.springsecuritymybatic.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author jbzm
 * @date Create on 2018/3/12 11:05
 */
public interface UserService extends UserDetailsService {
    UserDetails loadByUsernameAndPassword(String username, String password) throws UsernameNotFoundException;

}
