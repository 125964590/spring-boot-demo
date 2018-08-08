package top.jbzm.demo.mongondb.entity;

import org.springframework.data.annotation.Id;

/**
 * @author jbzm
 * @date 2018下午2:58
 **/

public class User {

    @Id
    private Long id;

    private String username;
    private Integer age;

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    // 省略getter和setter

}
