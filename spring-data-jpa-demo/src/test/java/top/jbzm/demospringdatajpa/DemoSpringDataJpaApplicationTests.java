package top.jbzm.demospringdatajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jbzm.demospringdatajpa.entity.Role;
import top.jbzm.demospringdatajpa.entity.User;
import top.jbzm.demospringdatajpa.repository.RoleRepository;
import top.jbzm.demospringdatajpa.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringDataJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void contextLoads() {
        User user = User.builder().username("jbzm").email("123").password("jjj").build();
    }

}
