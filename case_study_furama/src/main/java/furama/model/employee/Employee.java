package furama.model.employee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "EMPLOYEE_UK_PK", columnNames = {"position_id", "education_degree_id", "division_id"})})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "DATE")
    private String birthday;

    private String idCard;

    @Column(columnDefinition = "DOUBLE")
    private String salary;

    private String phone;
    private String email;
    private String address;

    @OneToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private Position position;

    @OneToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id", nullable = false)
    private EducationDegree educationDegree;

    @OneToOne
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
