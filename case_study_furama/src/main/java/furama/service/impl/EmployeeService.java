package furama.service.impl;

import furama.model.employee.Division;
import furama.model.employee.EducationDegree;
import furama.model.employee.Employee;
import furama.model.employee.Position;
import furama.repository.IDivisionRepository;
import furama.repository.IEducationDegreeRepository;
import furama.repository.IEmployeeRepository;
import furama.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements furama.service.IEmployeeService {

    @Autowired
    IDivisionRepository iDivisionRepository;

    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;

    @Autowired
    IPositionRepository iPositionRepository;

    @Autowired
    IEmployeeRepository iEmployeeRepository;


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.iEmployeeRepository.findAll(pageable);
    }

    @Override
    public List<Division> listDivision() {
        return this.iDivisionRepository.findAll();
    }

    @Override
    public List<Position> listPosition() {
        return this.iPositionRepository.findAll();
    }

    @Override
    public List<EducationDegree> listEducationDegree() {
        return this.iEducationDegreeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return this.iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer idDelete) {
        this.iEmployeeRepository.deleteById(idDelete);
    }

    @Override
    public Page<Employee> searchByEmployeeName(String s, Pageable pageable) {
        return this.iEmployeeRepository.findAllByNameContaining(s, pageable);
    }
}
