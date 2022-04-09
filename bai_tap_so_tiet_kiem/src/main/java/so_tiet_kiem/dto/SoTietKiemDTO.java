package so_tiet_kiem.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import so_tiet_kiem.model.KhachHang;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SoTietKiemDTO implements Validator {

    static final String DATE_YYYY_MM_DD = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";

    private Integer id;

    @NotBlank(message = "no để trống !")
    private String thoiGianBatDauGui;

    @NotBlank
    private String kyHan;

    @NotBlank
    private String soTienGui;

    @Valid
    private KhachHangDTO khachHangDTO;

    public SoTietKiemDTO() {
    }

    public SoTietKiemDTO(String thoiGianBatDauGui, String kyHan, String soTienGui, KhachHangDTO khachHangDTO) {
        this.thoiGianBatDauGui = thoiGianBatDauGui;
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
        this.khachHangDTO = khachHangDTO;
    }

    public SoTietKiemDTO(Integer id, String thoiGianBatDauGui, String kyHan, String soTienGui, KhachHangDTO khachHangDTO) {
        this.id = id;
        this.thoiGianBatDauGui = thoiGianBatDauGui;
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
        this.khachHangDTO = khachHangDTO;
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

    public KhachHangDTO getKhachHangDTO() {
        return khachHangDTO;
    }

    public void setKhachHangDTO(KhachHangDTO khachHangDTO) {
        this.khachHangDTO = khachHangDTO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SoTietKiemDTO soTietKiemDTO = (SoTietKiemDTO) target;

        String soTien = soTietKiemDTO.getSoTienGui();
        if (!soTien.matches("^[0-9]+$")) {
            errors.rejectValue("soTienGui", "soTienGui.not.match", "vui lòng nhập số");
        } else {
            Integer soTienGui = Integer.valueOf(soTien);
            if (soTienGui < 30000000) {
                errors.rejectValue("soTienGui", "soTienGui.small", "phải lớn hơn 30 triệu");
            }
        }

        if (soTietKiemDTO.getThoiGianBatDauGui().matches(DATE_YYYY_MM_DD)) {

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate now = LocalDate.now();
            LocalDate date = LocalDate.parse(soTietKiemDTO.getThoiGianBatDauGui(), fmt);

            if (date.isBefore(now)) {
                errors.rejectValue("thoiGianBatDauGui", "time.before", "ngày quá khứ");
            }
        }
    }
}
