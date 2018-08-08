package top.jbzm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author jbzm
 * @date Create on 2018/3/12 14:24
 */
@Data
@MappedSuperclass
@DynamicInsert
@DynamicUpdate(true)
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    @CreationTimestamp
    @Column(updatable = false)
    protected Date createTime;

    @Column(columnDefinition = "smallint default 1")
    protected Integer status;
}
