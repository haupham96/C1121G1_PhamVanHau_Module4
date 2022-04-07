package validate.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import validate.dto.UserDTO;
import validate.model.User;
import validate.service.IUserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("")
    public String listUser(Model model, @PageableDefault(value = 2) Pageable pageable) {
        Page<User> users = iUserService.findAll(pageable);
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Pageable pageable) {
        userDTO.validate(userDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        iUserService.save(user);

        redirectAttributes.addFlashAttribute("message","success");
        return "redirect:/user";
    }
}
