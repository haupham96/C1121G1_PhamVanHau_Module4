package blog_security.service.impl;

import blog_security.model.Blog;
import blog_security.repository.IBlogRepository;
import blog_security.repository.IRoleRepository;
import blog_security.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository ;

    @Autowired
    IRoleRepository iRoleRepository ;

    @Override
    public List<Blog> findAllBlogs() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }
}
