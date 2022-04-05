package picture_of_day.service;

import picture_of_day.model.FeedBack;

import java.util.List;

public interface IPictureService {

    List<FeedBack> getAllFeedback();

    FeedBack findFeedbackById(Integer id);

    void save(FeedBack feedBack);
}
