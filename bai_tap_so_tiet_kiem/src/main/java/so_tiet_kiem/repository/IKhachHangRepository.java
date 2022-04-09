package so_tiet_kiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so_tiet_kiem.model.KhachHang;

public interface IKhachHangRepository extends JpaRepository<KhachHang,Integer> {
}
