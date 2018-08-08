package top.jbzm.demo.springsecuritymybatic.entity;

import lombok.*;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jbzm
 * @date Create on 2018/3/9 10:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Table(name = "t_user")
public class User extends BaseEntity{


    private String username;
    private String password;

}