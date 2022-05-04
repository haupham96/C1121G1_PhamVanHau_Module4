package my_project.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class PromotionDTO implements Validator {

    private Integer id;

    @NotBlank(message = "must not empty")
    private String title;

    @NotBlank(message = "must not empty")
    @Pattern(regexp = "^$|(^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$)"
            , message = "invalid format")
    private String startTime;

    @NotBlank(message = "must not empty")
    private String endTime;

    @NotBlank(message = "must not empty")
    private String promotionPrice;

    @NotBlank(message = "must not empty")
    private String detai;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        final String NUMBER = "^[0-9]+$";
        final String DATE_YYYY_MM_DD =
                "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        PromotionDTO promotionDTO = (PromotionDTO) target;

        if (!promotionDTO.getPromotionPrice().matches(NUMBER)) {
            errors.rejectValue("promotionPrice", "", "must be number");
        } else {
            Integer price = Integer.valueOf(promotionDTO.getPromotionPrice());
            if (price <= 10000) {
                errors.rejectValue("promotionPrice", "", "must > 10 000");
            }
        }

        if (promotionDTO.getStartTime().matches(DATE_YYYY_MM_DD)) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateStart = LocalDate.parse(promotionDTO.getStartTime(), fmt);
            LocalDate now = LocalDate.now();

            if (dateStart.compareTo(now) < 1) {
                errors.rejectValue("startTime", "", "must be after today");
            }

            if (!promotionDTO.getEndTime().matches(DATE_YYYY_MM_DD)) {
                errors.rejectValue("endTime", "", "invalid input");
            } else {
                LocalDate dateEnd = LocalDate.parse(promotionDTO.getEndTime(), fmt);
                if (dateEnd.compareTo(dateStart) < 1) {
                    errors.rejectValue("endTime", "", "must be after Start Time");
                }
            }
        }
    }
}
