package top.jbzm.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author jbzm
 * @date Create on 2018/3/12 14:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    /**
     * id
     */
    public Long id;

    /**
     * 创建时间
     */
    public Timestamp gmtCreate;

    /**
     * 修改时间
     */
    public Timestamp gmtModify;

    /**
     * 业务状态
     */
    public Integer bizStatus;

    /**
     * 逻辑状态
     */
    public Integer status;

    /**
     * 创建者
     */
    public Long creatorId;

    /**
     * 修改者
     */
    public Long modifierId;

}
