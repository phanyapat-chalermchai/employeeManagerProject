package com.phanyapat.employeeManager.rest;

import com.phanyapat.employeeManager.dao.EmployeeDAO;
import com.phanyapat.employeeManager.entity.Employee;
import com.phanyapat.employeeManager.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("getAll")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("getById/{id}")
    public Employee getById(@PathVariable int id){

        return employeeService.findById(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){

        Employee employee = employeeService.findById(id);

        if(employee == null){
            throw new RuntimeException("Employee id not found : " + id);
        }

        employeeService.delete(id);
        return "Deleted emp id : " + id;
    }


}
