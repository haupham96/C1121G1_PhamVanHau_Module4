package furama.controller;

import furama.model.customer.Customer;
import furama.service.*;
import furama.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerWithAllServicesService iCustomerWithAllServicesService;

    @Autowired
    IFuramaService iFuramaService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IUserService iUserService;

    @GetMapping("/test-aspect")
    public String testAspectMethod() {
        return "abc";
    }

    @GetMapping("/test-throwing")
    public String goEx(String abc) throws Exception {
        throw new Exception("abc");
    }

    @GetMapping("/header")
    public String goHeaderTemplate() {
        return "/templateDemo/tableDemo";
    }

    @GetMapping("/demo")
    public String listCustomer(Model model, @PageableDefault(value = 5) Pageable pageable) {

        Page<Customer> customers = this.iCustomerService.findAll(pageable);
        model.addAttribute("customers", customers);

        return "/templateDemo/tableDemo";
    }

    @GetMapping("/demo/create")
    public String goCreate() {
        return "/templateDemo/createCSS";
    }

    @GetMapping("/deleteMultiple")
    public String deleteMultiple() {
        List<String> iDString = new ArrayList<>();
        iDString.add("9");
        iDString.add("10");
        iCustomerService.deleteMultiple(iDString);
        return "redirect:/home";
    }


}
