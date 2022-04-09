package so_tiet_kiem.service;

import org.springframework.beans.factory.annotation.Autowired;
import so_tiet_kiem.model.KhachHang;
import so_tiet_kiem.repository.IKhachHangRepository;

import java.util.List;

public interface IKhachHangService {

    List<KhachHang> findAll();

    void save(KhachHang khachHang);
}
