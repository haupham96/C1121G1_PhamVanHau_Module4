package so_tiet_kiem.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tenKhachHang;

    @OneToMany(mappedBy = "khachHang",cascade = CascadeType.PERSIST)
    Set<SoTietKiem> soTietKiems;

    public KhachHang() {
    }

    public KhachHang(Integer id, String tenKhachHang) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
    }

    public KhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Set<SoTietKiem> getSoTietKiems() {
        return soTietKiems;
    }

    public void setSoTietKiems(Set<SoTietKiem> soTietKiems) {
        this.soTietKiems = soTietKiems;
    }
}
