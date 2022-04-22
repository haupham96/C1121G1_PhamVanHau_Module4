package furama.service;

import furama.model.employee.Division;
import furama.model.employee.EducationDegree;
import furama.model.employee.Employee;
import furama.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    List<Division> listDivision();

    List<Position> listPosition();

    List<EducationDegree> listEducationDegree();

    void save(Employee employee);

    Employee findById(Integer id);

    void deleteById(Integer idDelete);

    Page<Employee> searchByEmployeeName(String s, Pageable pageable);
}
