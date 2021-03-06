package com.epam.firstaid.controller;

import com.epam.firstaid.entity.Employee;
import com.epam.firstaid.service.EmployeeService;
import javax.validation.Valid;

import org.owasp.esapi.ESAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

  @Autowired
  private EmployeeService employeeService;

  private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

  @GetMapping("/register")
  public String getRegistration(@ModelAttribute Employee employee, Model model) {
    model.addAttribute("employee", employee);
    return "register";
  }

  @PostMapping("/register")
  public ModelAndView employeeRegistration(@ModelAttribute @Valid Employee employee, final BindingResult result,
      Model model) {

    ModelAndView redirect = new ModelAndView("register", HttpStatus.BAD_REQUEST);

    String errorMessage = "User already exists!";

      if (!result.hasErrors()) {

        if (employeeService.findByName(employee.getName()) != null) {
          redirect = new ModelAndView("register", HttpStatus.BAD_REQUEST);
          redirect.addObject("errorMessage", errorMessage);
          
          
        } else {

          LOGGER.info("Employee id: " + employee.getId());
          LOGGER.info("Employee name: " + employee.getName());
          
          // https://vulncat.fortify.com/en/detail?id=desc.dataflow.java.log_forging
          // only for Log Forging demo
          try {
        	  int locationValue = Integer.parseInt(employee.getLocation().toString());
          } catch (NumberFormatException e) {   	  
        	  LOGGER.info("Failed to parse value: " + employee.getLocation().toString());
          }

          employeeService.saveEmployee(employee);
          

          model.addAttribute(employee.getId());
          model.addAttribute("name", employee.getName());
          model.addAttribute("location", employee.getLocation());

          redirect = new ModelAndView("redirect:/register?success", HttpStatus.CREATED);

        }
      }

    return redirect;
  }
  
  public static String encode(String message) {
		message = message.replace('\n', '_').replace('\r', '_').replace('\t', '_');
//		message = ESAPI.encoder().encodeForHTML(message);
		return message;
	}
}

