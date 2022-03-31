package khai_bao_y_te.controller;


import khai_bao_y_te.model.ToKhaiYTe;
import khai_bao_y_te.service.IYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller

public class Controller {
    @Autowired
    IYTeService service;

    @GetMapping("/yte")
    public String showForm(Model model) {
        List<String> quocTich = service.getAllQuocTich();
        List<String> gioiTinh = service.getAllGioiTinh();
        List<String> tinhThanh = service.getAllTinhThanh();
        List<String> quanHuyen = service.getAllQuanHuyen();
        List<String> phuongXa = service.getAllPhuongXa();
        List<String> phuongTien = service.getAllPhuongTien();
        List<Integer> coKhong = service.getAllCoKhong();

        model.addAttribute("quocTich", quocTich);
        model.addAttribute("gioiTinh", gioiTinh);
        model.addAttribute("tinhThanh", tinhThanh);
        model.addAttribute("quanHuyen", quanHuyen);
        model.addAttribute("phuongXa", phuongXa);
        model.addAttribute("coKhong", coKhong);
        model.addAttribute("toKhaiYTe", new ToKhaiYTe());
        model.addAttribute("phuongTien", phuongTien);
        return "to-khai-y-te";
    }

    @PostMapping("/yte")
    public String khaiBaoYTe(@ModelAttribute ToKhaiYTe toKhaiYTe, Model model) {
        service.save(toKhaiYTe);
        model.addAttribute("toKhaiYTe", toKhaiYTe);
        model.addAttribute("mess", "thành công");

        List<String> quocTich = service.getAllQuocTich();
        List<String> gioiTinh = service.getAllGioiTinh();
        List<String> tinhThanh = service.getAllTinhThanh();
        List<String> quanHuyen = service.getAllQuanHuyen();
        List<String> phuongXa = service.getAllPhuongXa();
        List<String> phuongTien = service.getAllPhuongTien();
        List<Integer> coKhong = service.getAllCoKhong();

        model.addAttribute("quocTich", quocTich);
        model.addAttribute("gioiTinh", gioiTinh);
        model.addAttribute("tinhThanh", tinhThanh);
        model.addAttribute("quanHuyen", quanHuyen);
        model.addAttribute("phuongXa", phuongXa);
        model.addAttribute("coKhong", coKhong);
        model.addAttribute("phuongTien", phuongTien);

        return "to-khai-y-te";
    }
}
