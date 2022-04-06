package blog.demo.repository;

import blog.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAllByBlogNameContainingOrderByDate(String keyword , Pageable pageable);
    Page<Blog> findAllByOrderByDate(Pageable pageable);
    List<Blog> findAllByCategory_Id(Integer id);
}
