package blog.demo.controller;

import blog.demo.model.Blog;
import blog.demo.model.Category;
import blog.demo.service.IBlogService;
import blog.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService categoryService ;

    @GetMapping("")
    public String showIndex(@RequestParam Optional<String> keyword, Model model, @PageableDefault(value = 2)Pageable pageable){
        Page<Blog> blogList ;
        if(keyword.isPresent()){
           blogList = iBlogService.findBlogByName(keyword.get(),pageable);
        } else {
            blogList =  iBlogService.findAllBlog(pageable);
        }
        model.addAttribute("blogList",blogList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("blogObj",new Blog());
        model.addAttribute("categories",categories);
        return "create";
    }

    @PostMapping ("/create")
    public String createBlog(@ModelAttribute Blog blogObj, RedirectAttributes redirectAttributes){
        iBlogService.save(blogObj);
        redirectAttributes.addFlashAttribute("message","create success");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable Integer id, Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blogObj",blog);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String showEditform(@PathVariable Integer id, Model model){
        Blog blog = iBlogService.findById(id);
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("categories",categories);
        model.addAttribute("blogObj",blog);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editBlog(@ModelAttribute Blog blogObj, RedirectAttributes redirectAttributes){
        iBlogService.save(blogObj);
        redirectAttributes.addFlashAttribute("message","edit success");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteform(@PathVariable Integer id, Model model){
        Blog blog = iBlogService.findById(id);
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("categories",categories);
        model.addAttribute("blogObj",blog);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@ModelAttribute Blog blogObj, RedirectAttributes redirectAttributes){
        iBlogService.deleteBlog(blogObj);
        redirectAttributes.addFlashAttribute("message","delete success");
        return "redirect:/blog";
    }

    @GetMapping("/category/{categoryId}")
    public String listBlogByCategory(@PathVariable Integer categoryId, Model model){
        List<Blog> blogList = iBlogService.findBlogByCategoryId(categoryId);
        model.addAttribute("blogList",blogList);
        return "blog-category";
    }
}
