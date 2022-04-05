package blog.demo.service;

import blog.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAllBlog();

    void save(Blog blogObj);

    Blog findById(Integer id);

    void deleteBlog(Blog blogObj);
}
