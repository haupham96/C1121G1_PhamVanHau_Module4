package furama.model.employee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "DATE")
    private String birthday;

    private String idCard;

    private String salary;

    private String phone;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id", nullable = false)
    private Division division;

    public Employee() {
    }

    public Employee(String birthday, String idCard, String salary, String phone, String email, String address) {
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

}
