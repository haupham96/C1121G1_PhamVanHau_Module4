package picture_of_day.service;

import picture_of_day.model.FeedBack;
import picture_of_day.model.Picture;

import java.util.List;

public interface IPictureService {

    void createFeedback(FeedBack feedBack);

    List<FeedBack> getAllFeedback();

    FeedBack findFeedbackById(Integer id);

    void save(FeedBack feedBack);
}
