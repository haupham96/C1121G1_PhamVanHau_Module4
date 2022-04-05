package blog.demo.service.impl;

import blog.demo.model.Blog;
import blog.demo.repository.IBlogRepository;
import blog.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blogObj) {
        blogRepository.save(blogObj);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBlog(Blog blogObj) {
        blogRepository.delete(blogObj);
    }
}
