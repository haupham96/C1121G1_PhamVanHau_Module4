package blog.demo.service;

import blog.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAllBlog(Pageable pageable);

    void save(Blog blogObj);

    Blog findById(Integer id);

    void deleteBlog(Blog blogObj);

    Page<Blog> findBlogByName(String keyword, Pageable pageable);

    List<Blog> findBlogByCategoryId(Integer categoryId);
}
