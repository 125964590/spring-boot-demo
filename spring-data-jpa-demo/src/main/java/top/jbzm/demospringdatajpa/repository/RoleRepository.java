package top.jbzm.demospringdatajpa.repository;/**
 * @author jbzm
 * @date 2018上午9:02
 **/

import org.springframework.data.jpa.repository.JpaRepository;
import top.jbzm.demospringdatajpa.entity.Role;

import java.util.List;

/**
 * @author jbzm
 * @date 2018上午9:02
 **/
public interface RoleRepository extends JpaRepository<Role,Long> {
    <T> List<T> findByRoleName(String roleName,Class<T> t);
}
