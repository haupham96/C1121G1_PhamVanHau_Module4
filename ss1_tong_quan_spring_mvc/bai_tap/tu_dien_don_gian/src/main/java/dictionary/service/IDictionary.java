package dictionary.service;


import dictionary.model.Dictionary;

import java.util.List;
import java.util.Map;

public interface IDictionary {
   List<Dictionary> getDictionaryData();
   String findVietnameseWord(String english);
}
