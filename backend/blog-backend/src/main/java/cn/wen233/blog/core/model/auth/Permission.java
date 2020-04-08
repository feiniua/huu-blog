package cn.wen233.blog.core.model.auth;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author: huu
 * @date: 2020/4/8 11:29
 * @description:
 */
@Data
@Entity
public class Permission {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    /**
     * 权限名
     */
    @Column(unique = true)
    private String name;
}
