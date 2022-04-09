package so_tiet_kiem.model;

import javax.persistence.*;

@Entity
public class SoTietKiem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(columnDefinition = "date")
    private String thoiGianBatDauGui ;

    private String kyHan ;

    private String soTienGui ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "khach_hang_id",referencedColumnName = "id")
    private KhachHang khachHang ;

    public SoTietKiem() {
    }

    public SoTietKiem(String thoiGianBatDauGui, String kyHan, String soTienGui) {
        this.thoiGianBatDauGui = thoiGianBatDauGui;
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
    }

    public SoTietKiem(Integer id, String thoiGianBatDauGui, String kyHan, String soTienGui) {
        this.id = id;
        this.thoiGianBatDauGui = thoiGianBatDauGui;
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThoiGianBatDauGui() {
        return thoiGianBatDauGui;
    }

    public void setThoiGianBatDauGui(String thoiGianBatDauGui) {
        this.thoiGianBatDauGui = thoiGianBatDauGui;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(String soTienGui) {
        this.soTienGui = soTienGui;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
