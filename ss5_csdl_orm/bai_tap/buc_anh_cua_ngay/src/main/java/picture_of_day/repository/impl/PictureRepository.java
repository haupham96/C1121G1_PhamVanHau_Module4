package picture_of_day.repository.impl;

import org.springframework.stereotype.Repository;
import picture_of_day.model.FeedBack;
import picture_of_day.model.Picture;
import picture_of_day.repository.BaseRepository;
import picture_of_day.repository.IPictureRepository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class PictureRepository implements IPictureRepository {

    @Override
    public void createFeedback(FeedBack feedBack) {
        feedBack.setLikes(0);
        String now = LocalDate.now().toString();
        feedBack.setDatePicture(now);
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(feedBack);
        transaction.commit();
    }

    @Override
    public List<FeedBack> getAllFeedback() {
        String sql = "select f from FeedBack as f ";
        TypedQuery<FeedBack> query = BaseRepository.entityManager.createQuery(sql, FeedBack.class);
        return query.getResultList();
    }

    @Override
    public FeedBack findFeedbackById(Integer id) {
        return BaseRepository.entityManager.find(FeedBack.class, id);
    }

    @Override
    public void save(FeedBack feedBack) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(feedBack);
        transaction.commit();
    }


}
