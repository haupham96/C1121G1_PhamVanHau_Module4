package so_tiet_kiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import so_tiet_kiem.model.SoTietKiem;

import java.util.List;

public interface ISoTietKiemRepository extends JpaRepository<SoTietKiem, Integer> {
    List<SoTietKiem> findAllByKhachHang_TenKhachHangContaining(String key);

    @Query(value = "select * from so_tiet_kiem s where s.thoi_gian_bat_dau_gui between :date1 and :date2 ", nativeQuery = true)
    List<SoTietKiem> testSearchBy2Date(@Param("date1") String date1, @Param("date2") String date2);
}
