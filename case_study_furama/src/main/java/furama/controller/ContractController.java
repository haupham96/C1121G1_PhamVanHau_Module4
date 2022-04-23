package furama.controller;

import furama.dto.contract_dto.ContractDTO;
import furama.model.contract.Contract;
import furama.model.customer.Customer;
import furama.model.employee.Employee;
import furama.model.service.Service;
import furama.service.IContractService;
import furama.service.ICustomerService;
import furama.service.IEmployeeService;
import furama.service.IFuramaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/create")
    public String createForm(Model model){
        List<Customer> customers = this.iCustomerService.listCustomer();
        List<Employee> employees = this.iEmployeeService.listEmployee();
        List<Service> services = this.iFuramaService.listService();

        model.addAttribute("customers",customers);
        model.addAttribute("employees",employees);
        model.addAttribute("services",services);

        ContractDTO contractDTO = new ContractDTO();
        model.addAttribute("contractDTO",contractDTO);
        return "/contract/create-contract";
    }

    @PostMapping("/create")
    public String createContract(@Validated @ModelAttribute ContractDTO contractDTO , BindingResult bindingResult ,
                                 Model model, RedirectAttributes redirectAttributes){
        contractDTO.validate(contractDTO,bindingResult);
        if(bindingResult.hasFieldErrors()){

            List<Customer> customers = this.iCustomerService.listCustomer();
            List<Employee> employees = this.iEmployeeService.listEmployee();
            List<Service> services = this.iFuramaService.listService();

            model.addAttribute("customers",customers);
            model.addAttribute("employees",employees);
            model.addAttribute("services",services);

            return "/contract/create-contract";
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDTO,contract);
        this.iContractService.save(contract);

        redirectAttributes.addFlashAttribute("message","Create success new contract !");
        return "redirect:/home";

    }

    @GetMapping("/view/{id}")
    public String showContractDetail(@PathVariable Integer id,Model model){

        Contract contract = this.iContractService.findById(id);
        if(contract == null){
            return "/not-found";
        }
        model.addAttribute("contract",contract);
        return "/contract/view-contract";
    }

}
