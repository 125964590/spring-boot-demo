package top.jbzm.demospringdatajpa.nb;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.jbzm.demospringdatajpa.DemoSpringDataJpaApplicationTests;
import top.jbzm.demospringdatajpa.dto.UserDtoForCheck;
import top.jbzm.demospringdatajpa.dto.UserDtoForLogin;
import top.jbzm.demospringdatajpa.entity.User;
import top.jbzm.demospringdatajpa.repository.UserRepository;

import java.util.List;

/**
 * @author jbzm
 * @date 2018上午10:12
 **/
public class JpaDto extends DemoSpringDataJpaApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test01() throws InterruptedException {
        List<User> jbzmLogin = userRepository.findByUsername("jbzm", User.class);
        List<UserDtoForCheck> jbzmCheck = userRepository.findByUsername("jbzm", UserDtoForCheck.class);
        Thread.sleep(5000L);
    }
}