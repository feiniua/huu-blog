package cn.wen233.blog.core.model.auth;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * @author: huu
 * @date: 2020/4/7 20:04
 * @description:
 */
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    /**
     * 角色名
     */
    @Column(unique = true)
    private String name;

    /**
     * 权限
     */
    @ManyToMany
    private Set<Permission> permissions;
}
