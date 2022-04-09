package so_tiet_kiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import so_tiet_kiem.model.SoTietKiem;

import java.util.List;

public interface ISoTietKiemRepository extends JpaRepository<SoTietKiem, Integer> {
    List<SoTietKiem> findAllByKhachHang_TenKhachHangContaining(String key);
}
