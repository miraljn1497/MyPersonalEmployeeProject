package service;

import EmployeeException.EmployeeException;
import entity.EmployeeEntity;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public List<Employee> getEmployeesByIds(List<Long> employeeIds) {
        try {
            List<EmployeeEntity> entityList = employeeRepository.findAllByIdInEmployees(employeeIds);

            if (entityList == null || entityList.isEmpty()) {
                return Collections.emptyList();
            }

            List<Employee> employeeList = entityList.stream()
                    .filter(Objects::nonNull)
                    .map(i -> Employee.builder()
                            .employeeId(i.getEmployeeId())
                            .firstName(i.getFirstName())
                            .lastName(i.getLastName())
                            .department(i.getDepartment())
                            .build())
                    .collect(Collectors.toList());
            return employeeList;
        }
        catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return null;
    }

    }


