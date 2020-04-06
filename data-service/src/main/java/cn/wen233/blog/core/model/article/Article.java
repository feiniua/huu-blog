package cn.wen233.blog.core.model.article;

import cn.wen233.blog.core.model.tag.Tag;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author: huu
 * @date: 2020/3/29 14:20
 * @description:
 */
@Data
@Entity
public class Article {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(length = 36)
    private String id;

    /**
     * 标题
     */
    @NotNull(message = "标题不能为空")
    private String title;

    /**
     * 内容
     */
    @Column(columnDefinition = "text")
    private String content;

    /**
     * 创建时间
     */
    @CreationTimestamp
    private LocalDateTime createAt;

    /**
     * 标签
     */
    @ManyToMany(cascade = {CascadeType.MERGE})
    private Set<Tag> tags;

    /**
     * 封面图片地址
     */
    private String imageAddress;
}
