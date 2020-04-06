package cn.wen233.blog.common.dtos;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

/**
 * @author ankelen
 * @date 2019-08-29 9:23
 * @description 分页响应data
 */
@Data
@SuppressWarnings("unused")
public class PageInfo<T> {

    /**
     * 内容
     */
    private List<T> content;

    /**
     * 元素总数
     */
    private Long totalElements;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 当前页码
     */
    private Integer pageNumber;

    // region constructors

    private PageInfo(Page<T> page) {
        this.content = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.pageSize = page.getSize();
        this.pageNumber = page.getNumber();
    }

    private PageInfo(List<T> elements, Page page) {
        this.content = elements;
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.pageSize = page.getSize();
        this.pageNumber = page.getNumber();
    }

    private PageInfo(T element) {
        this.content = Collections.singletonList(element);
        this.totalElements = 1L;
        this.totalPages = 1;
        this.pageSize = 1;
        this.pageNumber = 0;
    }

    // endregion

    //region static methods

    public static <T> PageInfo<T> of(Page<T> page) {
        return new PageInfo<>(page);
    }

    public static <T> PageInfo<T> of(List<T> elements, Page page) {
        return new PageInfo<>(elements, page);
    }

    public static <T> PageInfo<T> single(T element) {
        return new PageInfo<>(element);
    }

    //endregion

}
