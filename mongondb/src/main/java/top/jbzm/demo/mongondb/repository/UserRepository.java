package top.jbzm.demo.mongondb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.jbzm.demo.mongondb.entity.User;

/**
 * @author jbzm
 * @date 2018下午2:59
 **/
public interface UserRepository extends MongoRepository<User,Long> {

}
