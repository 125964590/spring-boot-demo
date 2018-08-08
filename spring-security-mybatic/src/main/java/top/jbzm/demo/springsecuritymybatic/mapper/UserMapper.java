package top.jbzm.demo.springsecuritymybatic.mapper;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import top.jbzm.demo.springsecuritymybatic.entity.User;

/**
 * @author jbzm
 * @date 2018下午3:45
 **/
@Component
public interface UserMapper extends Mapper<User> {

    User findByUserName(String userName);
}
