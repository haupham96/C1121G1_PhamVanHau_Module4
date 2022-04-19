package blog_security.service;

import blog_security.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAllBlogs();

    void save(Blog blog);
}
