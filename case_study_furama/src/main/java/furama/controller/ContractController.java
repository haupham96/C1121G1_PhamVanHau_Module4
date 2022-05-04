package furama.controller;

import furama.dto.contract_dto.ContractDTO;
import furama.model.contract.Contract;
import furama.model.customer.Customer;
import furama.model.employee.Employee;
import furama.model.service.Service;
import furama.model.user.RoleUser;
import furama.service.*;
import furama.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    IContractService iContractService;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IFuramaService iFuramaService;

    @Autowired
    IUserService iUserService;

    @Autowired
    IRoleUserService iRoleUserService;

    @GetMapping("")
    public String listContract(Model model, Principal principal) {
        List<Contract> contracts = this.iContractService.findAll();
        model.addAttribute("contracts", contracts);

        if (principal != null) {

            User user = (User) ((Authentication) principal).getPrincipal();
            String userInfor = WebUtils.toString(user);
            furama.model.user.User userModel = this.iUserService.findByUserName(user.getUsername());
            model.addAttribute("userInfor", userInfor);
            model.addAttribute("userModel", userModel);
//            List<RoleUser> roleUsers = this.iRoleUserService.findByUserName(user.getUsername());
        }
        return "/contract/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<Customer> customers = this.iCustomerService.listCustomer();
        List<Employee> employees = this.iEmployeeService.listEmployee();
        List<Service> services = this.iFuramaService.listService();

        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        model.addAttribute("services", services);

        ContractDTO contractDTO = new ContractDTO();
        model.addAttribute("contractDTO", contractDTO);
        return "/contract/create-contract";
    }

    @PostMapping("/create")
    public String createContract(@Validated @ModelAttribute ContractDTO contractDTO, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes) {
        contractDTO.validate(contractDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            List<Customer> customers = this.iCustomerService.listCustomer();
            List<Employee> employees = this.iEmployeeService.listEmployee();
            List<Service> services = this.iFuramaService.listService();

            model.addAttribute("customers", customers);
            model.addAttribute("employees", employees);
            model.addAttribute("services", services);

            return "/contract/create-contract";
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDTO, contract);
        this.iContractService.save(contract);

        redirectAttributes.addFlashAttribute("message", "Create success new contract !");
        return "redirect:/home";

    }

    @GetMapping("/view/{id}")
    public String showContractDetail(@PathVariable Integer id, Model model, Principal principal) {

        if (principal != null) {
            User user = (User) ((Authentication) principal).getPrincipal();
            String userInfor = WebUtils.toString(user);
            furama.model.user.User userModel = this.iUserService.findByUserName(user.getUsername());
            model.addAttribute("userInfor", userInfor);
            model.addAttribute("userModel", userModel);
        }
        Contract contract = this.iContractService.findById(id);
        if (contract == null) {
            return "/err-404";
        }
        model.addAttribute("contract", contract);
        return "/contract/view-contract";
    }

    @ExceptionHandler(Exception.class)
    public String goErr() {
        return "err-404";
    }

}
