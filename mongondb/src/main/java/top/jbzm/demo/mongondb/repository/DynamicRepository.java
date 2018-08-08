package top.jbzm.demo.mongondb.repository;/**
 * @author jbzm
 * @date 2018下午7:29
 **/

import org.springframework.data.mongodb.repository.MongoRepository;
import top.jbzm.demo.mongondb.entity.Dynamic;

/**
 * @author jbzm
 * @date 2018下午7:29
 **/
public interface DynamicRepository extends MongoRepository<Dynamic,Long> {
}
