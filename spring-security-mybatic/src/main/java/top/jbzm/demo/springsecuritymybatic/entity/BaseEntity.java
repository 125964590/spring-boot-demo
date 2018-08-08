package top.jbzm.demo.springsecuritymybatic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author jbzm
 * @date Create on 2018/3/12 14:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @Id
    protected Long id;

    protected Date gmtCreate;

    protected Integer status;
}
