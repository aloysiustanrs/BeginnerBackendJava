package com.aloysius.BeginnerBackendJava.service;

import com.aloysius.BeginnerBackendJava.model.Employee;
import com.aloysius.BeginnerBackendJava.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee newEmployee){
        employeeRepository.save(newEmployee);
    }

    public boolean deleteEmployee(int id){

        if (id == -1) {
            return false; // User not found
        }

        employeeRepository.deleteById(id);
        return true; // User deleted successfully
    }
}
