package so_tiet_kiem.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import so_tiet_kiem.dto.KhachHangDTO;
import so_tiet_kiem.model.KhachHang;
import so_tiet_kiem.service.IKhachHangService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {

    @Autowired
    IKhachHangService iKhachHangService;

    @GetMapping("")
    public String listKhachHang(Model model) {
        List<KhachHang> khachHangList = iKhachHangService.findAll();
        model.addAttribute("khachHangList", khachHangList);
        return "/khach_hang/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        model.addAttribute("khachHangDTO", khachHangDTO);
        return "/khach_hang/create";
    }

    @PostMapping("/create")
    public String createKhachHang(@Valid @ModelAttribute KhachHangDTO khachHangDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/khach_hang/create";
        }
        KhachHang khachHang = new KhachHang();
        BeanUtils.copyProperties(khachHangDTO, khachHang);
        iKhachHangService.save(khachHang);
        redirectAttributes.addFlashAttribute("message", "tạo mới thành công");
        return "redirect:/khach-hang";
    }
}
