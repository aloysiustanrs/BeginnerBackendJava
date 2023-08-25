package com.aloysius.BeginnerBackendJava.repository;

import com.aloysius.BeginnerBackendJava.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
