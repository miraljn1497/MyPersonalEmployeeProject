package service;

import entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public model.Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findByEmployeeIdAndIsActive(employeeId);
    }

    @Override
    public List<EmployeeEntity> getEmployeesByIds(List<Long> employeeIds) {
        return employeeRepository.findAllByIdInEmployees(employeeIds);
    }

}
