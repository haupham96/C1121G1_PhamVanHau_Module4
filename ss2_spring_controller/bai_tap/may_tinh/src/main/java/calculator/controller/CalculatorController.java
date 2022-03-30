package calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String Calculate(@RequestParam Double num1, @RequestParam Double num2, @RequestParam String cal, Model model) {
        Double total = 0.0;
        switch (cal) {
            case "sub":
                total = num1 - num2;
                break;
            case "sum":
                total = num1 + num2;
                break;
            case "div":
                total = num1 / num2;
                break;
            case "mul":
                total = num1 * num2;
                break;
        }
        model.addAttribute("total", total);
        return "calculator";
    }
}
