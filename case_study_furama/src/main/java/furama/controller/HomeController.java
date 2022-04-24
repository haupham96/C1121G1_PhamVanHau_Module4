package furama.controller;

import furama.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Principal principal, Model model) {

        if(principal != null) {
            User userLogin = (User) ((Authentication) principal).getPrincipal();

            String userInfor = WebUtils.toString(userLogin);

            model.addAttribute("userInfor", userInfor);
        }



        return "index";
    }

    @GetMapping("/maintenance")
    public String goMaintenance() {
        return "/maintenance";
    }
}
