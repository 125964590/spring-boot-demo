package top.jbzm.demo.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jbzm.demo.mybatis.mapper.CountryMapper;

/**
 * @author jbzm
 * @date 2018下午6:02
 **/
@RestController
public class TestController {
    @Autowired
    private CountryMapper countryMapper;

    @GetMapping("test01")
    public String lol(){
        return countryMapper.selectByCountryName("jbzm").toString();
    }
}
