package com.thanhphu.restfullapi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "employee")
@Data
public class Employee implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    private Integer empId;
//    private String empNo;
//    private  String empName;
//
//    public Employee() {
//
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "empId", unique = true, nullable = false)
//    public Integer getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(Integer empId) {
//        this.empId = empId;
//    }
//
//    @Column(name = "empNo", unique = true, nullable = false, length = 10)
//    public String getEmpNo() {
//        return empNo;
//    }
//
//    public void setEmpNo(String empNo) {
//        this.empNo = empNo;
//    }
//
//    @Column(name = "empName", length = 50)
//    public String getEmpName() {
//        return empName;
//    }
//
//    public void setEmpName(String empName) {
//        this.empName = empName;
//    }
//
//    public Employee(Integer empId, String empNo, String empName) {
//        this.empId = empId;
//        this.empNo = empNo;
//        this.empName = empName;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId", unique = true, nullable = false)
    private Integer empId;

    @Column(name = "empNo", unique = true, nullable = false, length = 10)
    private String empNo;

    @Column(name = "empName", length = 50)
    private  String empName;
}
