package validate.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserDTO implements Validator {
    private Integer id;

    @NotBlank
    @Size(min = 5 ,  max = 45)
    private String firstName;

    @NotBlank
    @Size(min = 5 ,  max = 45)
    private String lastName;

    @Pattern(regexp = "^[0-9]{10,11}$",message = "invalid phone (10 or 11 number)")
    private String phoneNumber;

    @NotBlank
    private String dateOfBirth;

    @NotBlank(message = "required")
    @Email
    private String email;

    public UserDTO() {
    }

    public UserDTO(Integer id, String firstName, String lastName, String phoneNumber, String dateOfBirth, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, String dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
       final String DATE_YYYY_MM_DD = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";

        UserDTO userDTO = (UserDTO) target;

        if(!userDTO.getDateOfBirth().matches(DATE_YYYY_MM_DD)){
            errors.rejectValue("dateOfBirth","dateOfBirth.not.match","invalid input (example : 2000-12-31)");
        } else {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(userDTO.getDateOfBirth(),fmt);
            LocalDate now = LocalDate.now();
            if(now.getYear() - date.getYear() < 18){
                errors.rejectValue("dateOfBirth","dateOfBirth.small.18","must >= 18 years old");
            }
        }


    }
}
