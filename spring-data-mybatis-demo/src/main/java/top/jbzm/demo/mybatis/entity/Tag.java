package top.jbzm.demo.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhouwei
 * @Description: TODO
 * @create 2018-04-25 下午1:28
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_tag")
public class Tag {
    @Id
    private Integer id;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 标签描述
     */
    private String description;
    /**
     * 标签渠道  1教师2学员
     */
    private Integer channel;
    /**
     *  业务状态
     */
    private Integer bizStatus;
    /**
     *  逻辑状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModify;
    /**
     * 修改者
     */
    private String modifierId;
    /**
     * 创建者
     */
    private String creatorId;
}
