package furama.model.user;

import furama.model.employee.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "USER_UK_USER_NAME", columnNames = {"userName", "employee_id"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;
    private String passWord;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
