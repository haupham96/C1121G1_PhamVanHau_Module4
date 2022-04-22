package furama.controller;

import furama.dto.employee_dto.EmployeeDTO;
import furama.model.employee.Division;
import furama.model.employee.EducationDegree;
import furama.model.employee.Employee;
import furama.model.employee.Position;
import furama.service.IEmployeeService;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping("")
    public String listEmployee(@RequestParam Optional<String> keyword,Model model, @PageableDefault(value = 5) Pageable pageable) {

        if(!keyword.isPresent() || keyword.get().equals("")){
            Page<Employee> employees = this.iEmployeeService.findAll(pageable);
            model.addAttribute("employees", employees);
        } else {
            Page<Employee> employees = this.iEmployeeService.searchByEmployeeName(keyword.get(),pageable) ;
            model.addAttribute("employees", employees);
        }
        return "/employee/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        List<Division> divisions = this.iEmployeeService.listDivision();
        List<Position> positions = this.iEmployeeService.listPosition();
        List<EducationDegree> educationDegrees = this.iEmployeeService.listEducationDegree();
        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("divisions", divisions);
        model.addAttribute("positions", positions);
        model.addAttribute("educationDegrees", educationDegrees);
        return "/employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@Validated @ModelAttribute EmployeeDTO employeeDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            List<Division> divisions = this.iEmployeeService.listDivision();
            List<Position> positions = this.iEmployeeService.listPosition();
            List<EducationDegree> educationDegrees = this.iEmployeeService.listEducationDegree();
            model.addAttribute("divisions", divisions);
            model.addAttribute("positions", positions);
            model.addAttribute("educationDegrees", educationDegrees);
            return "/employee/create";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);

        this.iEmployeeService.save(employee);

        redirectAttributes.addFlashAttribute("message", "Add new Employee Success !");
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Employee employee = this.iEmployeeService.findById(id);
        if (employee == null) {
            return "/not-found";
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);

        model.addAttribute("employeeDTO", employeeDTO);

        List<Division> divisions = this.iEmployeeService.listDivision();
        List<Position> positions = this.iEmployeeService.listPosition();
        List<EducationDegree> educationDegrees = this.iEmployeeService.listEducationDegree();
        model.addAttribute("divisions", divisions);
        model.addAttribute("positions", positions);
        model.addAttribute("educationDegrees", educationDegrees);
        return "/employee/edit";
    }

    @PostMapping("/edit/**")
    public String editEmployee(@Validated @ModelAttribute EmployeeDTO employeeDTO, BindingResult bindingResult
            , Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            List<Division> divisions = this.iEmployeeService.listDivision();
            List<Position> positions = this.iEmployeeService.listPosition();
            List<EducationDegree> educationDegrees = this.iEmployeeService.listEducationDegree();
            model.addAttribute("divisions", divisions);
            model.addAttribute("positions", positions);
            model.addAttribute("educationDegrees", educationDegrees);
            return "/employee/edit";
        }
        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeDTO, employee);
        this.iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Edit Employee Complete !");
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Integer idDelete,RedirectAttributes redirectAttributes) {
        if (this.iEmployeeService.findById(idDelete)==null){
            return "/not-found";
        }

        this.iEmployeeService.deleteById(idDelete);

        redirectAttributes.addFlashAttribute("message","Delete Successful !");
        return "redirect:/employee";
    }
}
