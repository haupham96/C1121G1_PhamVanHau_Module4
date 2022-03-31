package mail_box.service.impl;

import mail_box.model.MailBox;
import mail_box.service.IMailBoxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailBoxService implements IMailBoxService {
private static List<String> listLanguage = new ArrayList<>();
private static List<Integer> listPageSize = new ArrayList<>();
private static MailBox mailBox = new MailBox();
static {
    listLanguage.add("English");
    listLanguage.add("Vietnamese");
    listLanguage.add("Japanese");
    listLanguage.add("Chinese");

    listPageSize.add(5);
    listPageSize.add(10);
    listPageSize.add(15);
    listPageSize.add(25);
    listPageSize.add(50);
    listPageSize.add(100);
}
    @Override
    public List<String> listLanguage() {
        return listLanguage;
    }

    @Override
    public List<Integer> listPageSize() {
        return listPageSize;
    }

    @Override
    public MailBox getMailBox() {
        return mailBox;
    }
}
