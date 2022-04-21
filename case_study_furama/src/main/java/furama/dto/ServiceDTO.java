package furama.dto;

import furama.model.service.RentType;
import furama.model.service.ServiceType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ServiceDTO {

    private Integer id;

    @Pattern(regexp = "^(DV-)[0-9]{4}$")
    private String serviceCode ;

    private String name;

    @Pattern(regexp = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$",message = "must be > 0")
    private String area;

    @Pattern(regexp = "^[0]*[1-9]+[0-9]*([\\.]([0-9]+))?$")
    private String price;

    @Pattern(regexp = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$",message = "must be > 0")
    private String maxPeople;

    private String standardRoom;
    private String otherConvenience;

    private String poolArea;

    @Pattern(regexp = "^([0]*[1-9][0-9]*)|[1-9][0-9]*$",message = "must be > 0")
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
}
