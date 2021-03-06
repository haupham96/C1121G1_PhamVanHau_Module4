package so_tiet_kiem.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import so_tiet_kiem.dto.KhachHangDTO;
import so_tiet_kiem.dto.SoTietKiemDTO;
import so_tiet_kiem.model.KhachHang;
import so_tiet_kiem.model.SoTietKiem;
import so_tiet_kiem.service.IKhachHangService;
import so_tiet_kiem.service.ISoTietKiemService;

import java.util.*;

@Controller
@RequestMapping("/so-tiet-kiem")
public class SoTietKiemController {

    @Autowired
    ISoTietKiemService soTietKiemService;

    @Autowired
    IKhachHangService khachHangService;

    @ModelAttribute("khachHangList")
    public List<KhachHang> khachHangList() {
        return khachHangService.findAll();
    }

    @GetMapping("")
    public String listSo(Model model) {
        List<SoTietKiem> soTietKiemList = soTietKiemService.findAll();
        model.addAttribute("soTietKiemList", soTietKiemList);
        return "/so_tiet_kiem/list";
    }

    @GetMapping("/create")
    public String showCreateSoTietKiem(Model model) {
        SoTietKiemDTO soTietKiemDTO = new SoTietKiemDTO();
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        model.addAttribute("soTietKiemDTO", soTietKiemDTO);
        model.addAttribute("khachHangDTO", khachHangDTO);
        return "/so_tiet_kiem/create";
    }

    @PostMapping("/create")
    public String createSoTietKiem(@Validated @ModelAttribute SoTietKiemDTO soTietKiemDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        soTietKiemDTO.validate(soTietKiemDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/so_tiet_kiem/create";
        }
        SoTietKiem soTietKiem = new SoTietKiem();
        KhachHang khachHang = new KhachHang();

        BeanUtils.copyProperties(soTietKiemDTO, soTietKiem);
        BeanUtils.copyProperties(soTietKiemDTO.getKhachHangDTO(), khachHang);

        Set<SoTietKiem> soTietKiemSet = new HashSet<>();
        soTietKiemSet.add(soTietKiem);

        khachHang.setSoTietKiems(soTietKiemSet);
        soTietKiem.setKhachHang(khachHang);

        soTietKiemService.save(soTietKiem);

        redirectAttributes.addFlashAttribute("message", "t???o m???i th??nh c??ng");
        return "redirect:/so-tiet-kiem";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id, Model model) {
        SoTietKiem soTietKiem = soTietKiemService.findById(id);
        model.addAttribute("soTietKiem", soTietKiem);
        return "/so_tiet_kiem/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteSoTietKiem(@PathVariable Optional<Integer> id, RedirectAttributes redirectAttributes) {
        if (id.isPresent()) {
            soTietKiemService.deleteById(id.get());
        }
        redirectAttributes.addFlashAttribute("message", "xo?? th??nh c??ng");
        return "redirect:/so-tiet-kiem";
    }

    @GetMapping("/search")
    public String search(@RequestParam Optional<String> startDay, @RequestParam Optional<String> endDay
            , @RequestParam Optional<String> searchName, Model model) {
        List<SoTietKiem> soTietKiemList = null;
        if ((!startDay.isPresent() || startDay.get().equals(""))&& (!endDay.isPresent() ||  endDay.get().equals(""))) {
            if (searchName.isPresent() && !(searchName.get().equals(""))) {
                soTietKiemList = soTietKiemService.searchByName(searchName.get());
                model.addAttribute("searchValue",searchName.get());
                model.addAttribute("soTietKiemList", soTietKiemList);
                return "/so_tiet_kiem/list";
            } else {
                return "redirect:/so-tiet-kiem";
            }
        }

        if (startDay.isPresent() && !(startDay.get().equals(""))) {
            if (endDay.isPresent() && !(endDay.get().equals(""))) {
                if (searchName.isPresent()&& !searchName.get().equals("")) {
                    soTietKiemList = soTietKiemService.searchByAll(startDay.get(), endDay.get(), searchName.get());
                    model.addAttribute("start",startDay.get());
                    model.addAttribute("end",endDay.get());
                    model.addAttribute("searchValue",searchName.get());
                    model.addAttribute("soTietKiemList", soTietKiemList);
                    return "/so_tiet_kiem/list";
                } else {
                    soTietKiemList = soTietKiemService.searchByDayStartAndDayEnd(startDay.get(), endDay.get());
                    List<SoTietKiem> test = soTietKiemService.searchBetween2Date(startDay.get(),endDay.get());

                    model.addAttribute("start",startDay.get());
                    model.addAttribute("end",endDay.get());
                    model.addAttribute("soTietKiemList", soTietKiemList);
                    return "/so_tiet_kiem/list";
                }
            } else {
                if (searchName.isPresent()) {
                    soTietKiemList = soTietKiemService.searchByDateAndName(startDay.get(), searchName.get());
                    model.addAttribute("start",startDay.get());
                    model.addAttribute("searchValue",searchName.get());
                    model.addAttribute("soTietKiemList", soTietKiemList);
                    return "/so_tiet_kiem/list";
                } else {
                    soTietKiemList = soTietKiemService.searchByDate(startDay.get());
                    model.addAttribute("start",startDay.get());
                    model.addAttribute("soTietKiemList", soTietKiemList);
                    return "/so_tiet_kiem/list";
                }

            }
        }

        return "redirect:/so-tiet-kiem";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        SoTietKiemDTO soTietKiemDTO = new SoTietKiemDTO();
        SoTietKiem soTietKiem = soTietKiemService.findById(id);
        KhachHangDTO khachHangDTO = new KhachHangDTO();

        BeanUtils.copyProperties(soTietKiem.getKhachHang(), khachHangDTO);
        BeanUtils.copyProperties(soTietKiem, soTietKiemDTO);
        soTietKiemDTO.setKhachHangDTO(khachHangDTO);
        model.addAttribute("soTietKiemDTO", soTietKiemDTO);

        return "/so_tiet_kiem/edit";
    }

    @PostMapping("/edit/{id}")
    public String editSo(@Validated @ModelAttribute SoTietKiemDTO soTietKiemDTO, BindingResult bindingResult, @PathVariable Integer id, @RequestParam Integer idKhachHangDTO, Model model, RedirectAttributes redirectAttributes) {
        SoTietKiem soTietKiem = new SoTietKiem();
        KhachHang khachHang = new KhachHang();
        soTietKiemDTO.validate(soTietKiemDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/so_tiet_kiem/edit";
        }
        BeanUtils.copyProperties(soTietKiemDTO, soTietKiem);
        BeanUtils.copyProperties(soTietKiemDTO.getKhachHangDTO(), khachHang);

        khachHang.setId(idKhachHangDTO);
        soTietKiem.setKhachHang(khachHang);

        soTietKiemService.save(soTietKiem);
        redirectAttributes.addFlashAttribute("message", "th??nh c??ng");
        return "redirect:/so-tiet-kiem";
    }
}
