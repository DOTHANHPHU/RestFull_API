package com.thanhphu.restfullapi.service;

import com.thanhphu.restfullapi.dao.EmployeeDAO;
import com.thanhphu.restfullapi.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee getEmployee(Long empId) {
        return employeeDAO.getEmployee(empId);
    }

    public Employee addEmployee(Employee empForm) {
        return employeeDAO.addEmployee(empForm);
    }

    public Employee updateEmployee(Employee empForm) {

        return employeeDAO.updateEmployee(empForm);
    }

    public void deleteEmployee(Long empId) {

        employeeDAO.deleteEmployee(empId);
    }

    public List<Employee> getAllEmployees() {

        return employeeDAO.getAllEmployees();
    }
}
