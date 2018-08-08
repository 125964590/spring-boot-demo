package top.jbzm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jbzm.entity.User;

/**
 * @author jbzm
 * @date Create on 2018/3/12 12:01
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
