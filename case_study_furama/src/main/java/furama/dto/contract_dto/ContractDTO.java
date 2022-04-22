package furama.dto.contract_dto;

import furama.model.customer.Customer;
import furama.model.employee.Employee;
import furama.model.service.Service;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ContractDTO implements Validator {

    private Integer id ;

    @Pattern(regexp = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$",
            message = "invalid date")
    private String startDate;

    private String endDate;

    @Pattern(regexp = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$", message = "must be > 0")
    private String deposit ;

//    @Pattern(regexp = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$", message = "must be > 0")
    private String totalMoney ;

    private Customer customer;

    private Employee employee;

    private Service service ;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
       final String REGEX_DATE = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        ContractDTO contractDTO = (ContractDTO) target;
        if (!contractDTO.getEndDate().matches(REGEX_DATE)){
            errors.rejectValue("endDate","err.start.day","invalid date");
        } else {
            if(contractDTO.getStartDate().matches(REGEX_DATE)){
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dayStart = LocalDate.parse(contractDTO.getStartDate(),fmt);
                LocalDate dayEnd = LocalDate.parse(contractDTO.getEndDate(),fmt);
                if(dayEnd.isBefore(dayStart)){
                    errors.rejectValue("endDate","err.day.before","End Day must be after Start Day");
                }
            }
        }
    }
}
