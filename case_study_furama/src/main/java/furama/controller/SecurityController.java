package furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String goLogin(@RequestParam Optional<String> err , Model model){
        if(err.isPresent() && err.get().equals("true")){
            model.addAttribute("errMessage","Invalid User or Password");
        }
        return "/loginForm";
    }

    @GetMapping("/err-login")
    public String goAuthorityAccessDeny(){
        return "/security/authority-deny-access";
    }


}
