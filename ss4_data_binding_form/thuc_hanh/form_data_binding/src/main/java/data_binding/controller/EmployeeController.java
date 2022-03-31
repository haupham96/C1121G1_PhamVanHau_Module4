package data_binding.controller;

import data_binding.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }
    @RequestMapping(value="/addEmployee",method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Employee employee,Model model){
        model.addAttribute("employee",employee);
        return "info";
    }

}
