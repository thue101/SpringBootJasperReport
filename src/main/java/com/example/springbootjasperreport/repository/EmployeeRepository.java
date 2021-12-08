package com.example.springbootjasperreport.repository;

import com.example.springbootjasperreport.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
