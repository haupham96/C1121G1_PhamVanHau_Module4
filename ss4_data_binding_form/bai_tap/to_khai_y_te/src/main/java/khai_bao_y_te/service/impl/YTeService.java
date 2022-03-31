package khai_bao_y_te.service.impl;

import khai_bao_y_te.model.ToKhaiYTe;
import khai_bao_y_te.repository.IYTeRepository;
import khai_bao_y_te.service.IYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YTeService implements IYTeService {
    @Autowired
    IYTeRepository repository;

    @Override
    public List<String> getAllQuocTich() {
        return repository.getAllQuocTich();
    }

    @Override
    public List<String> getAllGioiTinh() {
        return repository.getAllGioiTinh();
    }

    @Override
    public List<String> getAllTinhThanh() {
        return repository.getAllTinhThanh();
    }

    @Override
    public List<String> getAllQuanHuyen() {
        return repository.getAllQuanHuyen();
    }

    @Override
    public List<String> getAllPhuongXa() {
        return repository.getAllPhuongXa();
    }

    @Override
    public List<Integer> getAllCoKhong() {
        return repository.getAllCoKhong();
    }

    @Override
    public List<String> getAllPhuongTien() {
        return repository.getAllPhuongTien();
    }

    @Override
    public void save(ToKhaiYTe toKhaiYTe) {
        repository.save(toKhaiYTe);
    }
}
