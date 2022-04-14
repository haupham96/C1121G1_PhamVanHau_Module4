package blog.service;

import blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    List<Blog> findByCategoryName(String keyword);

    Blog findById(Integer id);

    void save(Blog blog);

    void deleteBlogById(Integer id);
}
