package picture_of_day.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import picture_of_day.model.FeedBack;
import picture_of_day.repository.IPictureRepository;
import picture_of_day.service.IPictureService;

import java.util.List;

@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository repository;

    @Override
    public List<FeedBack> getAllFeedback() {
        return repository.findAll();
    }

    @Override
    public FeedBack findFeedbackById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(FeedBack feedBack) {
        repository.save(feedBack);
    }

}
