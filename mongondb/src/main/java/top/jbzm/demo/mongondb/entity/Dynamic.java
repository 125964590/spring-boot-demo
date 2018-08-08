package top.jbzm.demo.mongondb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author jbzm
 * @date 2018下午7:18
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Dynamic{
    @Id
    private Long id;

    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章发布位置
     */
    private String position;
    /**
     * 文章展示范围
     */
    private int range;
    /**
     * 文章不可见范围
     */
    private List<Long> userIds;

}