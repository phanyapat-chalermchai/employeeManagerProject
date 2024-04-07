package com.phanyapat.employeeManager.service;

import com.phanyapat.employeeManager.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void delete(Integer id);

    int deleteAll();
}
