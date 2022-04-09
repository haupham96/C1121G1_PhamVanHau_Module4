package so_tiet_kiem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import so_tiet_kiem.model.KhachHang;
import so_tiet_kiem.repository.IKhachHangRepository;
import so_tiet_kiem.service.IKhachHangService;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService {

    @Autowired
    IKhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public void save(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }
}
