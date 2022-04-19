package blog_security.controller;

import blog_security.model.Blog;
import blog_security.service.IBlogService;
import blog_security.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    IBlogService iBlogService ;

    @GetMapping("/login")
    public String doLogin(Model model) {
        return "loginPage";
    }

    @GetMapping("/err-login")
    public String errPage(){
        return "err-access";
    }

    @GetMapping("/blogUser")
    public String blogLogin(Model model,Principal principal){

        User loginUser = (User)((Authentication)principal).getPrincipal();

        String userInfor = WebUtils.toString(loginUser);
        model.addAttribute("userInfor",userInfor);

        List<Blog> blogs = this.iBlogService.findAllBlogs();
        model.addAttribute("blogs",blogs);
        return "list-blog";
    }
}
