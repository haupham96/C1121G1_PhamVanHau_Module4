package khai_bao_y_te.repository.impl;

import khai_bao_y_te.model.ToKhaiYTe;
import khai_bao_y_te.repository.IYTeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class YTeRepository implements IYTeRepository {
    private static List<String> quocTich = new ArrayList<>();
    private static List<String> gioiTinh = new ArrayList<>();
    private static List<String> tinhThanh = new ArrayList<>();
    private static List<String> quanHuyen = new ArrayList<>();
    private static List<String> phuongXa = new ArrayList<>();
    private static List<Integer> coKhong = new ArrayList<>();
    private static List<ToKhaiYTe> listToKhaiYTe = new ArrayList<>();
    private static List<String> phuongTien = new ArrayList<>();

     static {
        quocTich.add("Việt Nam");
        quocTich.add("Nô Việt Nam");

        gioiTinh.add("Nam");
        gioiTinh.add("Nữ");

        tinhThanh.add("Đà Nẽn");

        quanHuyen.add("Liên Chiểu");
        quanHuyen.add("Cẩm Lệ");
        quanHuyen.add("Hải Châu");

        phuongXa.add("Hoà Minh");
        phuongXa.add("Hoà Khánh");
        phuongXa.add("Hoà Vang");
        phuongXa.add("Thạch Thang");

        coKhong.add(0);
        coKhong.add(1);

        phuongTien.add("Ô Tô");
        phuongTien.add("Xe Máy");
        phuongTien.add("Xe Khách");
        phuongTien.add("Khác");
    }

    @Override
    public List<String> getAllQuocTich() {
        return quocTich;
    }

    @Override
    public List<String> getAllGioiTinh() {
        return gioiTinh;
    }

    @Override
    public List<String> getAllTinhThanh() {
        return tinhThanh;
    }

    @Override
    public List<String> getAllQuanHuyen() {
        return quanHuyen;
    }

    @Override
    public List<String> getAllPhuongXa() {
        return phuongXa;
    }

    @Override
    public List<Integer> getAllCoKhong() {
        return coKhong;
    }

    @Override
    public List<String> getAllPhuongTien() {
        return phuongTien;
    }

    @Override
    public void save(ToKhaiYTe toKhaiYTe) {
        listToKhaiYTe.add(toKhaiYTe);
    }
}
