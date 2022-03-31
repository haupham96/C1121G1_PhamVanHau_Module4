package khai_bao_y_te.service;

import khai_bao_y_te.model.ToKhaiYTe;

import java.util.List;

public interface IYTeService {
    List<String> getAllQuocTich();
    List<String> getAllGioiTinh();
    List<String> getAllTinhThanh();
    List<String> getAllQuanHuyen();
    List<String> getAllPhuongXa();
    List<Integer> getAllCoKhong();
    List<String> getAllPhuongTien();

    void save(ToKhaiYTe toKhaiYTe);
}
