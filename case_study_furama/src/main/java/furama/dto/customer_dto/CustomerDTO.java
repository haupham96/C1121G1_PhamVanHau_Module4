package furama.dto.customer_dto;


import furama.model.customer.CustomerType;

import lombok.Getter;
import lombok.Setter;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
public class CustomerDTO implements Validator {

    final String DATE_YYYY_MM_DD = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
    private Integer id;

    @Pattern(regexp = "^(KH-)[0-9]{4}$", message = "invalid code")
    private String customerCode;

    @NotBlank(message = "not empty please")
    private String name;

    @Pattern(regexp = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$", message = "invalid date")
    private String birthday;

    private Integer gender;

    @Pattern(regexp = "^\\d{9}|\\d{11}$", message = "9 - 10 number please")
    private String idCard;

    @Pattern(regexp = "^((090)|(091)|(\\+8490)|(\\+8491))\\d{7}$", message = "invalid phone number ex:0901234567")
    private String phone;

    @Email
    private String email;

    @NotBlank
    private String address;

    private CustomerType customerType;

    public CustomerDTO() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        ICustomerService iCustomerService = new CustomerService();
//        CustomerDTO customerDTO = (CustomerDTO) target;
//        String codeCheck = customerDTO.getCustomerCode();
//        for (Customer ls : customers) {
//            if (ls.getCustomerCode().equals(codeCheck)) {
//                errors.rejectValue("customerCode", "err.customer.code", "code already exist");
//                break;
//            }
//        }
    }
}
