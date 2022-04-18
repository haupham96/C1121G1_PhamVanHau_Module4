package customer.controller;

import customer.model.Customer;
import customer.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public String listCustomer(Model model){
        List<Customer> customers = this.customerService.findAll();
        model.addAttribute("customers",customers);
        return "list";
    }
}
