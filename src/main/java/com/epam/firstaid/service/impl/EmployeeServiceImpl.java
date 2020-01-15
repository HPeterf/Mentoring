package com.epam.firstaid.service.impl;

import com.epam.firstaid.entity.Employee;
import com.epam.firstaid.repository.EmployeeRepository;
import com.epam.firstaid.service.EmployeeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;

  }

  @Override
  public Employee saveEmployee(Employee employee) {
    LOGGER.info("Saving employee: " + employee);
    return employeeRepository.save(employee);
  }

  @Override
  public String userNameValidation(String name) {
    return employeeRepository.findByName(name) == null ? "available" : "notAvailable";
  }

  @Override
  public List<Employee> getAllEmployee() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findByName(String name) {
    return employeeRepository.findByName(name);
  }
}
