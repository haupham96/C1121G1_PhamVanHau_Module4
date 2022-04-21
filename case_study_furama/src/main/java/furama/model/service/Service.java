package furama.model.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serviceCode ;

    private String name;

    @Column(columnDefinition = "int")
    private String area;

    @Column(columnDefinition = "double")
    private String price;

    @Column(columnDefinition = "int")
    private String maxPeople;

    private String standardRoom;

    private String otherConvenience;

    @Column(columnDefinition = "double")
    private String poolArea;

    @Column(columnDefinition = "int")
    private String floor;

    @OneToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @OneToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    public Service() {
    }

    public Service(String name, String area, String price, String maxPeople, String standardRoom, String otherConvenience, String poolArea, String floor) {
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
