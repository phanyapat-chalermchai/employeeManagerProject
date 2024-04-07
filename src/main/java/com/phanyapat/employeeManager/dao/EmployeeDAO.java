package com.phanyapat.employeeManager.dao;

import com.phanyapat.employeeManager.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void save(Employee theStudent);

    Employee findById(Integer id);

    List<Employee> findAll();

    List<Employee> findByLastName(String lastName);

    void update(Employee student);

    void delete(Integer id);

    int deleteAll();

}
