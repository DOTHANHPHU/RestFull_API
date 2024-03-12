package com.thanhphu.restfullapi.dao;

import com.thanhphu.restfullapi.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Employee getEmployee(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = (Employee) session.get(Employee.class, empId);
        return emp;
    }

    public Employee addEmployee(Employee empForm) {
        Session session = sessionFactory.getCurrentSession();
        session.save(empForm);
        return empForm;
    }

    public Employee updateEmployee(Employee form) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = (Employee) session.get(Employee.class, form.getEmpId());
        emp.setEmpNo(form.getEmpNo());
        emp.setEmpName(form.getEmpName());
        session.update(emp);
        return emp;
    }

    public void deleteEmployee(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = (Employee) session.get(Employee.class, empId);
        session.delete(emp);
    }

    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Employee> listEmployee = (List<Employee>) session.createQuery("FROM " + Employee.class.getName()).list();
        return listEmployee;

    }




//    private static final Map<Long, Employee> empMap = new HashMap<Long, Employee>();
//
//    static {
//        initEmps();
//    }
//
//    private static void initEmps() {
//        Employee emp1 = new Employee(1L, "E01", "Test 1");
//        Employee emp2 = new Employee(2L, "E02", "Test 2");
//        Employee emp3 = new Employee(3L, "E03", "Test 3");
//
//        empMap.put(emp1.getEmpId(), emp1);
//        empMap.put(emp2.getEmpId(), emp2);
//        empMap.put(emp3.getEmpId(), emp3);
//    }
//
//    public Long getMaxEmpId() {
//        Set<Long> keys = empMap.keySet();
//        Long max = 0L;
//        for (Long key : keys) {
//            if (key > max) {
//                max = key;
//            }
//        }
//        return max;
//    }
//
//    public Employee getEmployee(Long empId) {
//        return empMap.get(empId);
//    }
//
//    public Employee addEmployee(Employee empForm) {
//        Long empId = this.getMaxEmpId() + 1;
//        empForm.setEmpId(empId);
//
//        empMap.put(empForm.getEmpId(), empForm);
//        return empForm;
//    }
//
//    public Employee updateEmployee(Employee empForm) {
//        Employee empUpdate = this.getEmployee(empForm.getEmpId());
//        if (empUpdate != null) {
//            empUpdate.setEmpNo(empForm.getEmpNo());
//            empUpdate.setEmpName(empForm.getEmpName());
//        }
//        return empUpdate;
//    }
//
//    public void deleteEmployee(Long empId) {
//        empMap.remove(empId);
//    }
//
//    public List<Employee> getAllEmployees() {
//        Collection<Employee> c = empMap.values();
//        List<Employee> list = new ArrayList<Employee>();
//        list.addAll(c);
//        return list;
//    }
}
