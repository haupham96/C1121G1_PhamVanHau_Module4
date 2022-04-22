package furama.dto.employee_dto;


import furama.model.employee.Division;
import furama.model.employee.EducationDegree;
import furama.model.employee.Position;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
public class EmployeeDTO {

    private Integer id;

    @NotBlank(message = "must not be blank")
    private String name ;

    @Pattern(regexp = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$", message = "invalid date")
    private String birthday;

    @Pattern(regexp = "^\\d{9}|\\d{11}$", message = "9 - 10 number please")
    private String idCard;

    @Pattern(regexp = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$", message = "must be > 0")
    private String salary;

    @Pattern(regexp = "^((090)|(091)|(\\+8490)|(\\+8491))\\d{7}$", message = "invalid phone number ex:0901234567")
    private String phone;

    @Email(message = "invalid email")
    @NotBlank(message = "not blank")
    private String email;

    @NotBlank
    private String address;

    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String birthday, String idCard, String salary, String phone, String email, String address) {
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

}
