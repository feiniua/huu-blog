package cn.wen233.blog.core.model.tag;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author: huu
 * @date: 2020/3/29 14:37
 * @description:
 */
@Data
@Entity
public class Tag {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36)
    private String id;

    /**
     * 标签名
     */
    @Column(unique = true)
    private String name;
}
