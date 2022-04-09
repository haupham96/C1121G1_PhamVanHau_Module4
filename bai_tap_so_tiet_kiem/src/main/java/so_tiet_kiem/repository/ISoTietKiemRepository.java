package so_tiet_kiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import so_tiet_kiem.model.SoTietKiem;

import java.util.List;

public interface ISoTietKiemRepository extends JpaRepository<SoTietKiem, Integer> {
    //    @Query(value = "select s from SoTietKiem s where s.khachHang.tenKhachHang like :keyWord and ( s.thoiGianBatDauGui between :day1 and :day2 ) ")
//    List<SoTietKiem> searchAll( @Param("day1") String day1, @Param("day2") String day2 , @Param("keyWord") String keyWord );
    List<SoTietKiem> findAllByKhachHang_TenKhachHangContaining(String key);
}
