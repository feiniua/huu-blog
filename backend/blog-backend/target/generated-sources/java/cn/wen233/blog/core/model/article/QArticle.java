package cn.wen233.blog.core.model.article;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArticle extends EntityPathBase<Article> {

    private static final long serialVersionUID = -428076163L;

    public static final QArticle article = new QArticle("article");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final StringPath id = createString("id");

    public final StringPath imageAddress = createString("imageAddress");

    public final SetPath<cn.wen233.blog.core.model.tag.Tag, cn.wen233.blog.core.model.tag.QTag> tags = this.<cn.wen233.blog.core.model.tag.Tag, cn.wen233.blog.core.model.tag.QTag>createSet("tags", cn.wen233.blog.core.model.tag.Tag.class, cn.wen233.blog.core.model.tag.QTag.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QArticle(String variable) {
        super(Article.class, forVariable(variable));
    }

    public QArticle(Path<? extends Article> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticle(PathMetadata metadata) {
        super(Article.class, metadata);
    }

}

