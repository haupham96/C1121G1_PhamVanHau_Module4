package my_project.service;

import my_project.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPromotionService {
    List<Promotion> findAll();

    Promotion findById(Integer integer);

    void deleteById(Integer integer);

    void save(Promotion promotion);

    Page<Promotion> findAllByEverything(String promotionPrice, String startDay, String endDay, Pageable pageable);
}
