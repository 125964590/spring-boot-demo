package top.jbzm.demo;

import lombok.Builder;

/**
 * @author zhengyi
 * @date 2018/9/8 8:25 PM
 **/
@Builder
public class UserInfo extends BaseEntity implements User {

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;


    /**
     * name
     */
    private String name;

    /**
     * phone
     */
    private Long phone;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public Long getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }


    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}