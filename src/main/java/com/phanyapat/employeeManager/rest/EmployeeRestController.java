package com.phanyapat.employeeManager.rest;

import com.phanyapat.employeeManager.dao.EmployeeDAO;
import com.phanyapat.employeeManager.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    private final EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("getAll")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @GetMapping("getById/{id}")
    public Employee getById(@PathVariable int id){

        return employeeDAO.findById(id);
    }


}
