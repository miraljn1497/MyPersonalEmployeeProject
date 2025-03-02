package repository;

import entity.EmployeeEntity;
import model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {


    Employee findByEmployeeIdAndIsActive(Long employeeId);

    List<EmployeeEntity> findAllByIdInEmployees(List<Long> employeeIds);

}




