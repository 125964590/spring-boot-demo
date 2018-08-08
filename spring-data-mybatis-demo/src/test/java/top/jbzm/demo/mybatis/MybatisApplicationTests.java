package top.jbzm.demo.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.tomcat.util.descriptor.tagplugin.TagPluginParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jbzm.demo.mybatis.entity.Country;
import top.jbzm.demo.mybatis.entity.Tag;
import top.jbzm.demo.mybatis.mapper.CountryMapper;
import top.jbzm.demo.mybatis.mapper.TagMapper;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private TagMapper tagMapper;

    @Test
    public void contextLoads() {
        System.out.println(countryMapper.selectByCountryName("jbzm").toString());
    }

    @Test
    public void lol01(){
        Country country=new Country();
        country.setId(10011);
        System.out.println(countryMapper.selectOne(country));
    }
    @Test
    public void lol02(){
        Tag tag=new Tag();
        tag.setId(2);
        tag.setName("0.17353134804734155");
        tagMapper.selectAll();
        tagMapper.selectOne(tag);
    }

    @Test
    public void lol03(){
        List<Country> countryList=countryMapper.selectByPageNumSize(1,5);
        countryList.forEach(System.out::println);
    }

    @Test
    public void test01(){
        List<Tag> tags = tagMapper.selectAllTagByPage(1, 1, 1, 10);
        tags.forEach(System.out::println);
    }

    @Test
    public void test04(){
        PageInfo<Tag> pageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(() -> tagMapper.selectAll());
        Page<Tag> page = PageHelper.startPage(1, 10).doSelectPage(() -> tagMapper.selectAllJBZM(1));
        pageInfo.getList().forEach(System.out::println);
        page.getResult().forEach(System.out::println);
        System.out.println(page.toString());
    }

    @Test
    public void test02(){
        Tag tag=new Tag();
        tag.setName("zhengyi");
        tag.setChannel(1);
        tag.setDescription("666");
        int insert = tagMapper.insertSelective(tag);
        System.out.println(insert);
    }
}
