package blog.service;

import blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findByCategoryName(String keyword);

    Blog findById(Integer id);

    void save(Blog blog);

    void deleteBlogById(Integer id);

    Page<Blog> searchByAuthor(String s,Pageable pageable);
}
