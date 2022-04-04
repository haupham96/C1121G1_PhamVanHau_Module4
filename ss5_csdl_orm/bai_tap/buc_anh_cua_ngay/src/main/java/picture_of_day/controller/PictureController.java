package picture_of_day.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import picture_of_day.model.FeedBack;
import picture_of_day.model.Picture;
import picture_of_day.service.IPictureService;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private IPictureService service;

    @GetMapping("")
    public String showPicture(Model model) {
        List<FeedBack> feedBackList = service.getAllFeedback();
        model.addAttribute("feedBackList", feedBackList);
        FeedBack feedBack = new FeedBack();
        model.addAttribute("feedBack", feedBack);
        return "index";
    }

    @PostMapping("/newComment")
    public String createComment(@ModelAttribute FeedBack feedBack, Model model) {
        service.createFeedback(feedBack);
        List<FeedBack> feedBackList = service.getAllFeedback();
        model.addAttribute("feedBackList", feedBackList);
        model.addAttribute("feedBack", new FeedBack());
        return "index";
    }

    @GetMapping("/like/{id}")
    public String likePicture(@PathVariable Integer id,Model model){
        FeedBack feedBack = service.findFeedbackById(id);
        feedBack.setLikes(feedBack.getLikes()+1);
        service.save(feedBack);
        return "redirect:/picture";
    }
}
