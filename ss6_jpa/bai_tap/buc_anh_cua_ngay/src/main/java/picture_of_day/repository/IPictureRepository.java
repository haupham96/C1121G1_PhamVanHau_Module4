package picture_of_day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import picture_of_day.model.FeedBack;


public interface IPictureRepository extends JpaRepository<FeedBack, Integer> {

}
