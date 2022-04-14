package blog.service.impl;

import blog.model.Blog;
import blog.repository.IBlogRepository;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public List<Blog> findByCategoryName(String keyword) {
        return iBlogRepository.findAllByCategory_NameContaining(keyword);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(Integer id) {
        iBlogRepository.deleteById(id);
    }
}
