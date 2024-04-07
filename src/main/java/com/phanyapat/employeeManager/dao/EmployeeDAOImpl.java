package com.phanyapat.employeeManager.dao;

import com.phanyapat.employeeManager.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        //return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee WHERE lastName=:theData", Employee.class);

        //set query parameters
        theQuery.setParameter("theData", lastName);

        //return query result
        return theQuery.getResultList();
    }


    @Override
    public Employee save(Employee employee) {
//        entityManager.persist(employee);
        return entityManager.merge(employee);
    }

    @Override
    public void delete(Integer id) {
//        Employee Employee = entityManager.find(Employee.class, id);
        Employee Employee = findById(id);

        entityManager.remove(Employee);
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Employee").executeUpdate();
    }
}
