package top.jbzm.demo.mybatis.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;

/**
 * @author jbzm
 * @date 2018下午2:37
 **/
@Data
@ToString
public class Country {
    @Id
    private Integer id;
    private String  countryname;
    private String  countrycode;

}
