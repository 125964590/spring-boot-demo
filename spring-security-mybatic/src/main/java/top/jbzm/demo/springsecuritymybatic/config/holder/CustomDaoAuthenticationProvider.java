package top.jbzm.demo.springsecuritymybatic.config.holder;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import top.jbzm.demo.springsecuritymybatic.service.UserService;

/**
 * @author jbzm
 * @date Create on 2018/3/9 0:17
 */
@Component
public class CustomDaoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private UserService userService;
    public CustomDaoAuthenticationProvider(UserService userService){
        this.userService = userService;
        this.setHideUserNotFoundExceptions(false);
    }
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //使用自定义的用户加载流程，此处无需继续验证
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        return userService.loadByUsernameAndPassword(username,authentication.getCredentials().toString());
    }
}
