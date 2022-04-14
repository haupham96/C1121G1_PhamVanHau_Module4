package blog.controller;

import blog.model.Blog;
import blog.service.IBlogService;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> listBlog() {
        List<Blog> blogs = iBlogService.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/findByCategory")
    public ResponseEntity<List<Blog>> findBlogByCategory(@RequestParam(required = false) String keyword) {
        List<Blog> blogs = iBlogService.findByCategoryName(keyword);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<String> viewBlog(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("blog details : "+blog.getDetail(), HttpStatus.OK);
    }

}
