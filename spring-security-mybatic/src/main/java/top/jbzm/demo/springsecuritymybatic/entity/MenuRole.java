package top.jbzm.demo.springsecuritymybatic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @author jbzm
 * @date Create on 2018/3/12 14:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuRole extends BaseEntity{
    private Long roleId;
    private Long MenuId;
}
