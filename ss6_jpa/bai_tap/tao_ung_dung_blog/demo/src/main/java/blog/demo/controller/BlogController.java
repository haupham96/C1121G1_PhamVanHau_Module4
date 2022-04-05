package blog.demo.controller;

import blog.demo.model.Blog;
import blog.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @GetMapping("")
    public String showIndex(Model model){
        List<Blog> blogList =  iBlogService.findAllBlog();
        model.addAttribute("blogList",blogList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blogObj",new Blog());
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
        model.addAttribute("blogObj",blog);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@ModelAttribute Blog blogObj, RedirectAttributes redirectAttributes){
        iBlogService.deleteBlog(blogObj);
        redirectAttributes.addFlashAttribute("message","delete success");
        return "redirect:/blog";
    }
}
