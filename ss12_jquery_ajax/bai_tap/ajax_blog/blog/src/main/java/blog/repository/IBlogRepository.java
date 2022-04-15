package blog.repository;

import blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByCategory_NameContaining(String categoryName);

    Page<Blog> findAllByAuthorContaining(String author, Pageable pageable);
}
