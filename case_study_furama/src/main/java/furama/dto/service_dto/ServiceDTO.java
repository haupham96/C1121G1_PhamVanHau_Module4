package furama.dto.service_dto;

import furama.dto.customer_dto.CustomerDTO;
import furama.model.service.RentType;
import furama.model.service.ServiceType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ServiceDTO implements Validator {

    private Integer id;

    @Pattern(regexp = "^(DV-)[0-9]{4}$", message = "invalid code Ex: DV-0000")
    private String serviceCode;

    @NotBlank(message = "must no be blank")
    private String name;

    @Pattern(regexp = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$", message = "must be > 0")
    private String area;

    @Pattern(regexp = "^[0]*[1-9]+[0-9]*([\\.]([0-9]+))?$", message = "must be > 0")
    private String price;

    @Pattern(regexp = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$", message = "must be > 0")
    private String maxPeople;

    private String standardRoom;
    private String otherConvenience;

    private String poolArea;

    @Pattern(regexp = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$", message = "must be > 0")
    private String floor;

    private RentType rentType;
    private ServiceType serviceType;

    public ServiceDTO() {
    }

    public ServiceDTO(String serviceCode, String name, String area, String price, String maxPeople, String standardRoom, String otherConvenience, String poolArea, String floor) {
        this.serviceCode = serviceCode;
        this.name = name;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
       final String regexPoolArea = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$";
        ServiceDTO serviceDTO = (ServiceDTO) target;
        if(serviceDTO.getServiceType().getId()==1){
            if(!serviceDTO.getPoolArea().matches(regexPoolArea)){
                errors.rejectValue("poolArea","error.pool.area","must be > 0 ");
            }
        }
    }
}
