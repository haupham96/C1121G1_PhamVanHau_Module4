package so_tiet_kiem.dto;

import so_tiet_kiem.model.SoTietKiem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class KhachHangDTO {
    static final String VIETNAMESE_NAME_REGEX = "^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$";
    private Integer id;

    @Pattern(regexp = VIETNAMESE_NAME_REGEX,message = "không chứa kí tự số")
    @NotBlank
    private String tenKhachHang;

    Set<SoTietKiem> soTietKiems;

    public KhachHangDTO() {
    }

    public KhachHangDTO(String tenKhachHang, Set<SoTietKiem> soTietKiems) {
        this.tenKhachHang = tenKhachHang;
        this.soTietKiems = soTietKiems;
    }

    public KhachHangDTO(Integer id, String tenKhachHang, Set<SoTietKiem> soTietKiems) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.soTietKiems = soTietKiems;
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
