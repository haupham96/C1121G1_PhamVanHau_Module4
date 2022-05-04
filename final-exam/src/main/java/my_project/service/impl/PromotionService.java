package my_project.service.impl;

import my_project.model.Promotion;
import my_project.repository.IPromotionRepository;
import my_project.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService implements IPromotionService {

    @Autowired
    IPromotionRepository iPromotionRepository;

    @Override
    public List<Promotion> findAll() {
        return this.iPromotionRepository.findAll();
    }

    @Override
    public Promotion findById(Integer id) {
        return this.iPromotionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        this.iPromotionRepository.deleteById(id);
    }

    @Override
    public void save(Promotion promotion) {
        this.iPromotionRepository.save(promotion);
    }

    @Override
    public Page<Promotion> findAllByEverything(String promotionPrice, String startDay, String endDay , Pageable pageable) {
        return this.iPromotionRepository.findAllByPromotionPriceContainingAndStartTimeContainingAndEndTimeContaining(promotionPrice, startDay, endDay, pageable);
    }

}
