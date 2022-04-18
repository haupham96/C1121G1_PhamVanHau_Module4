package blog.controller;

import blog.model.Blog;
import blog.service.IBlogService;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> listBlog(@PageableDefault(value = 3) Pageable pageable, Optional<String> keyword) {
        if (!keyword.isPresent() || keyword.get().equals("")) {
            Page<Blog> blogs = iBlogService.findAll(pageable);
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }

        Page<Blog> blogs = iBlogService.searchByAuthor(keyword.get(), pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);

    }

//    @GetMapping("/search")
//    public ResponseEntity<Page<Blog>> searchByAuthor(@PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> searchName) {
//        if (searchName.isPresent()) {
//            Page<Blog> blogs = this.iBlogService.searchByAuthor(searchName.get(), pageable);
//            return new ResponseEntity<>(blogs, HttpStatus.OK);
//        }
//        Page<Blog> blogs = iBlogService.findAll(pageable);
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }

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
        return new ResponseEntity<String>("blog details : " + blog.getDetail(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewBlog(@RequestBody Blog blog) {
        this.iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Void> editBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
        if (iBlogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.iBlogService.deleteBlogById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
