package dictionary.service.impl;

import dictionary.service.IDictionary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Dictionary implements IDictionary {
    private static List<dictionary.model.Dictionary> list = new ArrayList<>();

    static {
        list.add(new dictionary.model.Dictionary("One","Một"));
        list.add(new dictionary.model.Dictionary("Two","Hai"));
        list.add(new dictionary.model.Dictionary("Three","Ba"));
        list.add(new dictionary.model.Dictionary("Four","Bốn"));
        list.add(new dictionary.model.Dictionary("Five","Năm"));
    }

    @Override
    public List<dictionary.model.Dictionary> getDictionaryData() {
        return list;
    }

    @Override
    public String findVietnameseWord(String english) {
        String vietnameseWord = "not found";
        for (dictionary.model.Dictionary ls : list) {
            if (ls.getEnglish().equals(english)) {
                vietnameseWord = ls.getVietnam();
            }
        }
        return vietnameseWord;
    }
}
