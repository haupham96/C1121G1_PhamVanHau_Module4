package mail_box.model;


import javafx.scene.control.TextArea;

public class MailBox {
    private String languge;
    private Integer pageSize;
    private Integer spamFilter ;
    private String signature ;

    public MailBox() {
    }

    public MailBox(String languge, Integer pageSize, Integer spamFilter, String signature) {
        this.languge = languge;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguge() {
        return languge;
    }

    public void setLanguge(String languge) {
        this.languge = languge;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(Integer spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
