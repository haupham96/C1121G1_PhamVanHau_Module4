package my_project.controller;

import my_project.Utils.Regex;
import my_project.dto.PromotionDTO;
import my_project.model.Promotion;
import my_project.service.IPromotionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    IPromotionService iPromotionService;

    @GetMapping("")
    public String goList(Model model, @RequestParam(defaultValue = "0", required = false) String promotionPrice,
                         @RequestParam(defaultValue = "-", required = false) String startDay,
                         @RequestParam(defaultValue = "-", required = false) String endDay,
                         Pageable pageable) {

        Page<Promotion> promotions = this.iPromotionService.findAllByEverything(promotionPrice, startDay, endDay, pageable);

        if (startDay.matches(Regex.DATE)) {
            model.addAttribute("startDay", startDay);
        }

        if (endDay.matches(Regex.DATE)) {
            model.addAttribute("endDay", endDay);
        }

        model.addAttribute("promotionPrice", promotionPrice);
        model.addAttribute("promotions", promotions);

        return "/main/list";

    }

    @PostMapping("/delete")
    public String deletePromotion(@RequestParam Optional<Integer> idDelete, RedirectAttributes redirectAttributes) {

        if (this.iPromotionService.findById(idDelete.get()) == null || !(idDelete.isPresent())) {
            return "/err-404";
        }

        this.iPromotionService.deleteById(idDelete.get());
        redirectAttributes.addFlashAttribute("message", "delete Success !");
        return "redirect:/promotion";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model) {
        PromotionDTO promotionDTO = new PromotionDTO();
        model.addAttribute("promotionDTO", promotionDTO);
        return "/main/create";
    }

    @PostMapping("/create")
    public String createPromotion(@Validated @ModelAttribute PromotionDTO promotionDTO, BindingResult bindingResult,
                                  Model model, RedirectAttributes redirectAttributes) {
        promotionDTO.validate(promotionDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("promotionDTO", promotionDTO);
            return "/main/create";
        }
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDTO, promotion);
        this.iPromotionService.save(promotion);
        redirectAttributes.addFlashAttribute("message", "create success !");
        return "redirect:/promotion";
    }

    @GetMapping("/edit/{id}")
    public String goEdit(@PathVariable Optional<Integer> id, Model model) {
        Promotion promotion = this.iPromotionService.findById(id.get());
        if (promotion == null || !id.isPresent()) {
            return "/err-404";
        }
        PromotionDTO promotionDTO = new PromotionDTO();
        BeanUtils.copyProperties(promotion, promotionDTO);
        model.addAttribute("promotionDTO", promotionDTO);
        return "/main/edit";
    }

    @PostMapping("/edit/{id}")
    public String editPromotion(@Validated @ModelAttribute PromotionDTO promotionDTO, BindingResult bindingResult,
                                Model model, RedirectAttributes redirectAttributes) {
        promotionDTO.validate(promotionDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("promotionDTO", promotionDTO);
            return "/main/edit";
        }
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDTO, promotion);
        this.iPromotionService.save(promotion);

        redirectAttributes.addFlashAttribute("message", "edit Success !");
        return "redirect:/promotion";

    }


}
