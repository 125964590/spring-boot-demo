package top.jbzm.demo.mybatis.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jbzm
 * @date 2018下午2:06
 **/
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 身份编号
     */
    @Column(name = "card_no")
    private Integer cardNo;

    /**
     * 生日
     */
    @Column(name = "birthday")
    private Date birthday;
}
