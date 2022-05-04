package my_project.repository;


import my_project.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {
    Page<Promotion> findAllByPromotionPriceContainingAndStartTimeContainingAndEndTimeContaining(String price, String startDate, String endDate, Pageable pageable);
}
