package top.jbzm.demo.mongondb;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jbzm.demo.mongondb.entity.Dynamic;
import top.jbzm.demo.mongondb.entity.User;
import top.jbzm.demo.mongondb.repository.DynamicRepository;
import top.jbzm.demo.mongondb.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongondbApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DynamicRepository dynamicRepository;
//    @Test
//    public void contextLoads() {
//        User user=new User("hah",18,231L);
//        userRepository.save(user);
//    }

    @Test
    public void test02() {
        Dynamic dynamic=Dynamic.builder().content("这是内容").id(2L).position("这是发布位置").range(600).userIds(Lists.newArrayList(1L,22L,3L)).build();
        dynamicRepository.save(dynamic);
    }

}
