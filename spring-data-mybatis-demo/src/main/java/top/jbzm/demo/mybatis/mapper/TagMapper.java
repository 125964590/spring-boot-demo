package top.jbzm.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import top.jbzm.demo.mybatis.entity.Tag;

import java.util.List;

/**
 * @author jbzm
 * @date 2018下午5:37
 **/
@Component
public interface TagMapper extends Mapper<Tag> {
    @Select(value = "select * from t_tag where status=#{status} and channel=#{channel}")
    List<Tag> selectAllTagByPage(@Param("status") Integer status, @Param("channel") Integer channel, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    @Select(value = "select * from t_tag")
    List<Tag> selectAllJBZM(@Param("lol") int lol);
}
