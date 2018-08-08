package top.jbzm.demospringdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jbzm.demospringdatajpa.entity.User;

import java.util.List;

/**
 * @author jbzm
 * @date 2018上午9:01
 **/
public interface UserRepository extends JpaRepository<User,Long> {
    <T> List<T> findByUsername(String username, Class<T> t);
}