package currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/currency")
    public String showCurrencyForm(){
        return "currency-form";
    }
    @PostMapping("/currency")
    public String convert(@RequestParam Double usd , Model model){
        Double vnd = usd * 23000 ;
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        return "currency-form";
    }
}
