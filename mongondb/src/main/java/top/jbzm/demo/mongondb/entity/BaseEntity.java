package top.jbzm.demo.mongondb.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * @author jbzm
 * @date 2018下午7:19
 **/
public class BaseEntity {
    @Id
    protected Long id;

    @CreatedDate
    protected Date createTime;

    @LastModifiedDate
    protected Date lastModified;

}