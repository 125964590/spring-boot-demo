package top.jbzm.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import top.jbzm.demo.mybatis.entity.Country;

import java.util.List;

/**
 * @author jbzm
 * @date 2018下午2:39
 **/
@Component
public interface CountryMapper extends Mapper<Country> {
    /**
     *
     * @param countryname
     * @return
     */
    Country selectByCountryName(String countryname);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Select(value = "select * from country")
    List<Country> selectByPageNumSize(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

}
