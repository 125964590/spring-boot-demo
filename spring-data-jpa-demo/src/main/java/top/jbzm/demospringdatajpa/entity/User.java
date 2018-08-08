package top.jbzm.demospringdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jbzm
 * @date Create on 2018/3/12 15:22
 */
@Entity
@Builder
@Setter
@Getter
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> userRole= new LinkedList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
