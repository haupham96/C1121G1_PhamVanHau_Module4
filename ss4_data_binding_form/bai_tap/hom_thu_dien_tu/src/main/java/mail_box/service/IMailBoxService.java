package mail_box.service;

import mail_box.model.MailBox;

import java.util.ArrayList;
import java.util.List;

public interface IMailBoxService {
    List<String> listLanguage ();
    List<Integer> listPageSize ();
    MailBox getMailBox();

}
