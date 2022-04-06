package blog.demo.service.impl;

import blog.demo.model.Category;
import blog.demo.repository.ICategoryRepository;
import blog.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository repository;

    @Override
    public List<Category> findAllCategory() {
        return repository.findAll();
    }
}
