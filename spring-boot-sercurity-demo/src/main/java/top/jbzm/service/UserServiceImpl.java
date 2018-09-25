package top.jbzm.service;

import com.ht.base.common.ErrorResult;
import com.ht.base.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.jbzm.entity.User;
import top.jbzm.entity.dto.UserInfo;
import top.jbzm.repository.UserRepository;

/**
 * @author jbzm
 * @date Create on 2018/3/12 11:58
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadByUsernameAndPassword(String username, String password) {
        //查询时候已判断用户状态，无需再次递交下层判断
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new MyException(ErrorResult.create(23333, "用户名不存在"));
        }

        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }
        return add(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Assert.isNull(user, "该用户不存在");

        return null;
    }

    private UserInfo add(User user) {
        return UserInfo.builder().id(user.getId()).username(user.getUsername()).password(user.getPassword()).build();
    }
}
