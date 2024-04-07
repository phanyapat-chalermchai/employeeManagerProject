package com.phanyapat.employeeManager.dao;

import com.phanyapat.employeeManager.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee findById(Integer id);

    List<Employee> findAll();

    List<Employee> findByLastName(String lastName);

    Employee save(Employee employee);

    void delete(Integer id);

    int deleteAll();

}
