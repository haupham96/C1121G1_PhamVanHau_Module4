package dictionary.controller;

import dictionary.model.Dictionary;
import dictionary.service.IDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {
    @Autowired
    IDictionary dictionary ;
    @GetMapping("/dictionary")
    public String searchForm(){
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String search(@RequestParam String english, Model model){
        String vietnameseWorld = dictionary.findVietnameseWord(english);
        model.addAttribute("vietnameseWorld",vietnameseWorld);
        model.addAttribute("english",english);
        return "dictionary";
    }
}
