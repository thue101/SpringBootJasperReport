package com.example.springbootjasperreport;

import com.example.springbootjasperreport.entity.Employee;
import com.example.springbootjasperreport.repository.EmployeeRepository;
import com.example.springbootjasperreport.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootJasperReportApplication {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    ReportService service;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return service.exportReport(format);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJasperReportApplication.class, args);
    }


}
