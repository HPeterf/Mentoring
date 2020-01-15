package com.epam.firstaid.repository;

import com.epam.firstaid.entity.Employee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  Employee findByName(String name);

  List<Employee> findAll();

}
