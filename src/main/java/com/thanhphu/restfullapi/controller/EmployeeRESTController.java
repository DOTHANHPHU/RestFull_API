package com.thanhphu.restfullapi.controller;

import com.thanhphu.restfullapi.dao.EmployeeDAO;
import com.thanhphu.restfullapi.entities.Employee;
import com.thanhphu.restfullapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class EmployeeRESTController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * List all of employee
     * @return
     */
    @RequestMapping(value = "/employees",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                        MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        return list;
    }

    /**
     * get detail of employee
     * @param empId
     * @return
     */
    @RequestMapping(value = "/employees/{empId}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee getEmployees(@PathVariable("empId") Long empId) {
        return employeeService.getEmployee(empId);
    }

    /**
     * ADD of employee
     * @return
     * RequestBody: ở client sẽ submit lên chuỗi text dưới dạng JSON/ XML
     * => Khi khai báo RequestBody nó sẽ parse chuỗi text đó tạo ra 1 object Employee có tên empForm
     */
    @RequestMapping(value = "/employees",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee empForm) {
        System.out.println("(Service Side) Creating employee with empNo: " + empForm.getEmpNo());
        return employeeService.addEmployee(empForm);
    }

    /**
     * Update of employee
     * @return
     */
    @RequestMapping(value = "/employees",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee empForm) {
        System.out.println("(Service Side) Editing employee with Id: " + empForm.getEmpId());
        return employeeService.updateEmployee(empForm);
    }

    /**
     * Delete of employee
     * @param empId
     * @return
     */
    @RequestMapping(value = "/employees/{empId}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public String deleteEmployee(@PathVariable("empId") Long empId) {
        System.out.println("(Service Side) Deleting employee with Id: " + empId);
        employeeService.deleteEmployee(empId);
        return "Delete Successful";
    }
}
