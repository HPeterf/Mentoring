package com.epam.firstaid.controller;

import com.epam.firstaid.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserNameValidationController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/availability-of-name")
  public @ResponseBody
  ResponseEntity<String> getAvabilityOfUserName(@RequestParam final String name) {
    return name == null || name.trim().isEmpty() ? ResponseEntity.badRequest().body("Invalid input!")
        : ResponseEntity.ok().body(employeeService.userNameValidation(name));
  }
}
