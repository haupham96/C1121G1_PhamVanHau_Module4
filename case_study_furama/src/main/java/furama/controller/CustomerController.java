package furama.controller;

import furama.dto.customer_dto.CustomerDTO;
import furama.model.customer.Customer;
import furama.model.customer.CustomerType;
import furama.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String listCustomer(Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = this.iCustomerService.findAll(pageable);
        model.addAttribute("customers", customers);
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
    public String createCustomer(@Validated @ModelAttribute CustomerDTO customerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        customerDTO.validate(customerDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
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
            return "not-found";
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
            model.addAttribute("customerTypes", customerTypes);
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
//        customer.setId(id);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit Success !");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer idDelete, RedirectAttributes redirectAttributes) {
        if (this.iCustomerService.findById(idDelete) == null) {
            return "not-found";
        }
        this.iCustomerService.deleteById(idDelete);
        redirectAttributes.addFlashAttribute("message", "Delete Success !");
        return "redirect:/customer";
    }

}