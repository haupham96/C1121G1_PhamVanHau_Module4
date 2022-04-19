package blog_security.controller;

import blog_security.model.Account;
import blog_security.model.Blog;
import blog_security.model.RoleAccount;
import blog_security.service.IAccountService;
import blog_security.service.IBlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @Autowired
    IAccountService iAccountService;


    @GetMapping("")
    public String indexBlog(Model model) {
        List<Blog> blogs = iBlogService.findAllBlogs();
        model.addAttribute("blogs", blogs);
        return "/home";
    }

    @GetMapping("/create")
    public String createForm(Model model, Principal principal) {
        User user = (User) ((Authentication) principal).getPrincipal();
        Blog blog = new Blog();
        Account account = this.iAccountService.findByUserName(user.getUsername());
        System.out.println(account.getUserName());
        blog.setAccount(account);
        model.addAttribute("blog", blog);
        return "create-blog";
    }

    @PostMapping("/create")
    public String createBlog(RedirectAttributes redirectAttributes, @ModelAttribute Blog blog) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "add succress");
        return "redirect:/blogUser";
    }

}
