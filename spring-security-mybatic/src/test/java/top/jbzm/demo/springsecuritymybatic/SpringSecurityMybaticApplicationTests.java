package top.jbzm.demo.springsecuritymybatic;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jbzm.demo.springsecuritymybatic.entity.Tag;
import top.jbzm.demo.springsecuritymybatic.mapper.TagMapper;
import top.jbzm.demo.springsecuritymybatic.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityMybaticApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TagMapper tagMapper;
    @Test
    public void test01() {
        System.out.println(userMapper.findByUserName("jbzm"));
        userMapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void test02() {
        PageInfo<Tag> pageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(() -> tagMapper.selectAll());
        Page<Tag> page = PageHelper.startPage(1, 10).doSelectPage(() -> tagMapper.selectAllJBZM(1));
        pageInfo.getList().forEach(System.out::println);
        page.getResult().forEach(System.out::println);
        System.out.println(page.toString());
    }
}
