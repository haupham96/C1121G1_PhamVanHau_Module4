package mail_box.controller;

import mail_box.model.MailBox;
import mail_box.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MailBoxController {
    @Autowired
    private IMailBoxService mailBoxService ;
    @GetMapping("/setting")
    public String showForm(Model model) {
        List<String> listLanguage = mailBoxService.listLanguage();
        List<Integer> listPageSize = mailBoxService.listPageSize();
        model.addAttribute("mailBox",new MailBox());
        model.addAttribute("listPageSize",listPageSize);
        model.addAttribute("listLanguage",listLanguage);
        return "setting";
    }
    @PostMapping ("/setting")
    public String update(@ModelAttribute MailBox mailBox , Model model) {
        model.addAttribute("mailBox",mailBox);
        List<String> listLanguage = mailBoxService.listLanguage();
        List<Integer> listPageSize = mailBoxService.listPageSize();
        model.addAttribute("listPageSize",listPageSize);
        model.addAttribute("listLanguage",listLanguage);
        return "setting";
    }
}
