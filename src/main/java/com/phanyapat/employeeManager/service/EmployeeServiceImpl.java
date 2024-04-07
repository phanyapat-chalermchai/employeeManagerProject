package com.phanyapat.employeeManager.service;

import com.phanyapat.employeeManager.dao.EmployeeRepository;
import com.phanyapat.employeeManager.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        Employee employee = null;

        if (employeeOptional.isPresent())
            employee = employeeOptional.get();
        else
            throw new RuntimeException("Employee id not found : " + id);

        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isEmpty())
            throw new RuntimeException("Employee id not found : " + id);

        employeeRepository.delete(employeeOptional.get());
    }

    @Override
    @Transactional
    public int deleteAll() {
        employeeRepository.deleteAll();
        return 1;
    }
}
