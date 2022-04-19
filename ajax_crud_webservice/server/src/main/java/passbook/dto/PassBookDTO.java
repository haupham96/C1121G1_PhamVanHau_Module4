package passbook.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import passbook.model.Customer;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PassBookDTO implements Validator {
    private Integer id ;

    private String timeStart ;

    @NotBlank
    private String period ;

    @NotBlank
    @Pattern(regexp = "(^$|^[0-9]+$)",message = "number please")
    private String money ;

    @Valid
    private Customer customer ;

    public PassBookDTO() {
    }

    public PassBookDTO(String timeStart, String period, String money) {
        this.timeStart = timeStart;
        this.period = period;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Customer getCustomerDTO() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        final String DATE_YYYY_MM_DD = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        PassBookDTO passBookDTO = (PassBookDTO) target;
        if(passBookDTO.getTimeStart().matches(DATE_YYYY_MM_DD)){
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate now = LocalDate.now();
            LocalDate regexDate = LocalDate.parse(passBookDTO.getTimeStart(),fmt);
            if(regexDate.isBefore(now)){
                errors.rejectValue("timeStart","time.pass","valid time");
            }
        } else {
            errors.rejectValue("timeStart","time.not.match","valid time");
        }
    }
}
