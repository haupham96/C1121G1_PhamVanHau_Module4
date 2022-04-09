package so_tiet_kiem.service;

import so_tiet_kiem.model.SoTietKiem;

import java.util.List;

public interface ISoTietKiemService {
    List<SoTietKiem> findAll();

    void save(SoTietKiem soTietKiem);

    SoTietKiem findById(Integer id);

    void deleteById(Integer id);

    List<SoTietKiem> searchByAll(String day1, String day2, String key);

    List<SoTietKiem> searchByDayStartAndDayEnd(String s, String s1);

    List<SoTietKiem> searchByDate(String day1);

    List<SoTietKiem> searchByName(String key);

    List<SoTietKiem> searchByDateAndName(String date, String name);

    List<SoTietKiem> searchBetween2Date(String date1, String date2);
}
