package top.jbzm.demo.springsecuritymybatic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.jbzm.common.ErrorResult;
import top.jbzm.demo.springsecuritymybatic.dto.UserInfo;
import top.jbzm.demo.springsecuritymybatic.entity.User;
import top.jbzm.demo.springsecuritymybatic.mapper.UserMapper;
import top.jbzm.exception.MyException;

/**
 * @author jbzm
 * @date Create on 2018/3/12 11:58
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadByUsernameAndPassword(String username, String password) throws UsernameNotFoundException {
        //查询时候已判断用户状态，无需再次递交下层判断
        User user = userMapper.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("UsernameNotFound");
//           throw new MyException(ErrorResult.create(23333, "用户名不存在"));
        }

        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }
        return add(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUserName(username);
        Assert.isNull(user, "该用户不存在");

        return null;
    }

    private UserInfo add(User user) {
        return UserInfo.builder().id(user.getId()).username(user.getPassword()).password(user.getPassword()).build();
    }
}
