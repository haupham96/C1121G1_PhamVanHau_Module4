package picture_of_day.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import picture_of_day.model.FeedBack;
import picture_of_day.model.Picture;
import picture_of_day.repository.BaseRepository;
import picture_of_day.repository.IPictureRepository;
import picture_of_day.service.IPictureService;

import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository repository ;

    @Override
    public void createFeedback(FeedBack feedBack) {
        repository.createFeedback(feedBack);
    }

    @Override
    public List<FeedBack> getAllFeedback() {
        return repository.getAllFeedback();
    }

    @Override
    public FeedBack findFeedbackById(Integer id) {
        return repository.findFeedbackById(id);
    }

    @Override
    public void save(FeedBack feedBack) {
        repository.save(feedBack);
    }

}
