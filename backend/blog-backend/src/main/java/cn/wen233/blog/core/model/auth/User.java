package cn.wen233.blog.core.model.auth;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author: huu
 * @date: 2020/4/7 19:57
 * @description:
 *      一个用户有一个角色
 *      一个角色有多个权限
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36)
    private String id;

    /**
     * 用户名
     */
    @Column(unique = true)
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
}
