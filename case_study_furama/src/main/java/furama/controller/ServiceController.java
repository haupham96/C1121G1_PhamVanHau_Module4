package furama.controller;

import furama.dto.service_dto.ServiceDTO;
import furama.model.service.RentType;
import furama.model.service.Service;
import furama.model.service.ServiceType;
import furama.service.IFuramaService;
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
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    IFuramaService iFuramaService;

    @GetMapping("")
    public String listService(Model model, @PageableDefault(value = 5) Pageable pageable, Principal principal) {
        Page<Service> services = this.iFuramaService.findAll(pageable);
        model.addAttribute("services", services);

        if(principal != null){
            User userLogin = (User) ((Authentication)principal).getPrincipal();
            String userInfor = WebUtils.toString(userLogin);
            model.addAttribute("userInfor",userInfor);
        }

        return "/service/list";
    }

    @GetMapping("/create/{typeId}")
    public String showCreateForm(@PathVariable Integer typeId, Model model) {

        ServiceDTO serviceDTO = new ServiceDTO();
        ServiceType serviceType = this.iFuramaService.findServiceTypeById(typeId);
        serviceDTO.setServiceType(serviceType);

        List<ServiceType> serviceTypes = this.iFuramaService.findAllServiceTypes();
        List<RentType> rentTypes = this.iFuramaService.findAllRentTypes();
        model.addAttribute("serviceDTO", serviceDTO);
        model.addAttribute("serviceTypes", serviceTypes);
        model.addAttribute("rentTypes", rentTypes);

        return "/service/create";
    }

    @PostMapping("/create/{typeId}")
    public String createService(@PathVariable Integer typeId, @Validated @ModelAttribute ServiceDTO serviceDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        serviceDTO.validate(serviceDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<ServiceType> serviceTypes = this.iFuramaService.findAllServiceTypes();
            List<RentType> rentTypes = this.iFuramaService.findAllRentTypes();
            model.addAttribute("serviceTypes", serviceTypes);
            model.addAttribute("rentTypes", rentTypes);
            return "/service/create";
        }
        Service service = new Service();

        BeanUtils.copyProperties(serviceDTO, service);
        this.iFuramaService.save(service);

        redirectAttributes.addFlashAttribute("message", "Add new service success !");
        return "redirect:/service";
    }

}
