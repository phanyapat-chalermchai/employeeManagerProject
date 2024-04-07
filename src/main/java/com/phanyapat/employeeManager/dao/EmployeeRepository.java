package com.phanyapat.employeeManager.dao;

import com.phanyapat.employeeManager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
