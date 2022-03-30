package sand_wich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandWichController {
    @GetMapping("/sandwich")
    public String listCondiments() {
        return "sandwich";
    }

    @PostMapping("/sandwich")
    public String choices(@RequestParam(required = false) String condiment1 , @RequestParam(required = false) String condiment2, @RequestParam(required = false) String condiment3, @RequestParam(required = false) String condiment4, Model model) {
        model.addAttribute("condiment1",condiment1);
        model.addAttribute("condiment2",condiment2);
        model.addAttribute("condiment3",condiment3);
        model.addAttribute("condiment4",condiment4);
        return "result";
    }
}
