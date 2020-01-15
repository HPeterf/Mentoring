package com.epam.firstaid.service;

import com.epam.firstaid.entity.Employee;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

  Employee saveEmployee(Employee employee);

  String userNameValidation(String userName);

  List<Employee> getAllEmployee();

  Employee findByName(String name);
}
