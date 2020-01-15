package com.epam.firstaid.controller;

import com.epam.firstaid.entity.Employee;
import com.epam.firstaid.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/index")
  public String getHomePage(Model model) {
    List<Employee> listOfEmployees = employeeService.getAllEmployee();

    model.addAttribute("listOfEmployees",listOfEmployees);

    return "index";
  }
}
