package blog.demo.service.impl;

import blog.demo.model.Blog;
import blog.demo.repository.IBlogRepository;
import blog.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAllByOrderByDate(pageable);
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

    @Override
    public Page<Blog> findBlogByName(String keyword, Pageable pageable) {
        return blogRepository.findAllByBlogNameContainingOrderByDate(keyword, pageable);
    }

    @Override
    public List<Blog> findBlogByCategoryId(Integer categoryId) {
        return blogRepository.findAllByCategory_Id(categoryId);
    }

}
