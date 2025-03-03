package service;

import entity.EmployeeEntity;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {


    public model.Employee getEmployeeById(Long employeeId);



    public List<Employee> getEmployeesByIds(List<Long> employeeIds);

























}

