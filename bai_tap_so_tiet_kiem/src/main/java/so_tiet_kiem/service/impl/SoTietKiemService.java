package so_tiet_kiem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import so_tiet_kiem.model.SoTietKiem;
import so_tiet_kiem.repository.ISoTietKiemRepository;
import so_tiet_kiem.service.ISoTietKiemService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SoTietKiemService implements ISoTietKiemService {

    @Autowired
    ISoTietKiemRepository soTietKiemRepository;


    @Override
    public List<SoTietKiem> findAll() {
        return soTietKiemRepository.findAll();
    }

    @Override
    public void save(SoTietKiem soTietKiem) {
        soTietKiemRepository.save(soTietKiem);
    }

    @Override
    public SoTietKiem findById(Integer id) {
        return soTietKiemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        soTietKiemRepository.deleteById(id);
    }

    @Override
    public List<SoTietKiem> searchByAll(String day1, String day2, String key) {
        List<SoTietKiem> soTietKiemList = soTietKiemRepository.findAll();
        List<SoTietKiem> result = new ArrayList<>();
        for (SoTietKiem ls : soTietKiemList) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(day1, fmt);
            LocalDate date2 = LocalDate.parse(day2, fmt);
            String day3 = ls.getThoiGianBatDauGui();
            LocalDate date3 = LocalDate.parse(day3, fmt);
            if ((date1.isBefore(date3) || date1.equals(date3)) && (date2.isAfter(date3) || date2.equals(date3))) {
                if (ls.getKhachHang().getTenKhachHang().contains(key)) {
                    result.add(ls);
                }
            }
        }
        return result;

    }

    @Override
    public List<SoTietKiem> searchByDayStartAndDayEnd(String day1, String day2) {
        List<SoTietKiem> soTietKiemList = soTietKiemRepository.findAll();
        List<SoTietKiem> result = new ArrayList<>();
        for (SoTietKiem ls : soTietKiemList) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(day1, fmt);
            LocalDate date2 = LocalDate.parse(day2, fmt);
            String day3 = ls.getThoiGianBatDauGui();
            LocalDate date3 = LocalDate.parse(day3, fmt);
            if ((date1.isBefore(date3) || date1.equals(date3)) && (date2.isAfter(date3) || date2.equals(date3))) {
                result.add(ls);
            }
        }
        return result;
    }

    @Override
    public List<SoTietKiem> searchByDate(String day1) {
        List<SoTietKiem> soTietKiemList = soTietKiemRepository.findAll();
        List<SoTietKiem> result = new ArrayList<>();

        for (SoTietKiem ls : soTietKiemList) {

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(day1, fmt);
            String day2 = ls.getThoiGianBatDauGui();
            LocalDate date2 = LocalDate.parse(day2, fmt);

            if (date1.equals(date2)) {
                result.add(ls);
            }
        }
        return result;
    }

    @Override
    public List<SoTietKiem> searchByName(String key) {
        return soTietKiemRepository.findAllByKhachHang_TenKhachHangContaining(key);
    }

    @Override
    public List<SoTietKiem> searchByDateAndName(String date, String name) {
        List<SoTietKiem> soTietKiemList = soTietKiemRepository.findAll();
        List<SoTietKiem> result = new ArrayList<>();
        for (SoTietKiem ls : soTietKiemList) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(date, fmt);

            String day = ls.getThoiGianBatDauGui();
            LocalDate date2 = LocalDate.parse(day, fmt);

            if (date1.equals(date2)) {
                if (ls.getKhachHang().getTenKhachHang().contains(name)) {
                    result.add(ls);
                }
            }
        }
        return result;
    }
}
