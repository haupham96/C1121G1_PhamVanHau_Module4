package furama.controller;

import furama.dto.customer_dto.CustomerDTO;
import furama.model.customer.Customer;
import furama.model.customer.CustomerType;
import furama.model.customer_with_all_services.CustomerServicesView;
import furama.model.customer_with_all_services.CustomerWithAllServices;
import furama.model.customer_with_all_services.ICustomerServiceView;
import furama.model.employee.Employee;
import furama.model.service.Service;
import furama.service.*;
import furama.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerWithAllServicesService iCustomerWithAllServicesService;

    @Autowired
    IFuramaService iFuramaService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IUserService iUserService ;

    @GetMapping("")
    public String listCustomer(Principal principal, @RequestParam Optional<String> keyword, Model model, @PageableDefault(value = 5) Pageable pageable) {
        if (!keyword.isPresent() || keyword.get().equals("")) {
            Page<Customer> customers = this.iCustomerService.findAll(pageable);
            model.addAttribute("customers", customers);
        } else {
            Page<Customer> customers = this.iCustomerService.searchByCustomerName(keyword.get(), pageable);
            model.addAttribute("customers", customers);
        }

        if (principal != null) {
            User userLogin = (User) ((Authentication) principal).getPrincipal();
            String userInfor = WebUtils.toString(userLogin);
            model.addAttribute("userInfor", userInfor);

            furama.model.user.User userModel = this.iUserService.findByUserName(userLogin.getUsername());
            model.addAttribute("userModel",userModel);
        }
        return "/customer/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        CustomerDTO customerDTO = new CustomerDTO();
        List<CustomerType> customerTypes = this.iCustomerService.findAllCustomerType();
        model.addAttribute("customerDTO", customerDTO);
        model.addAttribute("customerTypes", customerTypes);
        return "/customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute CustomerDTO customerDTO, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypes = this.iCustomerService.findAllCustomerType();
            model.addAttribute("customerDTO", customerDTO);
            model.addAttribute("customerTypes", customerTypes);
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        this.iCustomerService.save(customer);

        redirectAttributes.addFlashAttribute("message", "Create Success !");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Customer customer = this.iCustomerService.findById(id);
        if (customer == null) {
            return "/err-404";
        }
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);

        List<CustomerType> customerTypes = this.iCustomerService.findAllCustomerType();
        model.addAttribute("customerDTO", customerDTO);
        model.addAttribute("customerTypes", customerTypes);
        return "/customer/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, @Validated @ModelAttribute CustomerDTO customerDTO, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypes = this.iCustomerService.findAllCustomerType();
            model.addAttribute("customerDTO", customerDTO);
            model.addAttribute("customerTypes", customerTypes);
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);

        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit Success !");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer idDelete, RedirectAttributes redirectAttributes) {
        if (this.iCustomerService.findById(idDelete) == null) {
            return "/err-404";
        }
        this.iCustomerService.deleteById(idDelete);
        redirectAttributes.addFlashAttribute("message", "Delete Success !");
        return "redirect:/customer";
    }

    @GetMapping("/use-services")
    public String showCustomerUseServices(Model model, Pageable pageable, Principal principal) {

        List<ICustomerServiceView> views = this.iCustomerWithAllServicesService.findAll();

        if (principal != null) {
            User user = (User) ((Authentication) principal).getPrincipal();
            String userInfor = WebUtils.toString(user);
            model.addAttribute("userInfor", userInfor);
            furama.model.user.User userModel = this.iUserService.findByUserName(user.getUsername());
            model.addAttribute("userModel",userModel);
        }
        model.addAttribute("views", views);
        return "/customer/customer-services-view";
    }

}
