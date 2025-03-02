package service;

import entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {


    public model.Employee getEmployeeById(Long employeeId);



    public List<EmployeeEntity> getEmployeesByIds(List<Long> employeeIds);

























}

