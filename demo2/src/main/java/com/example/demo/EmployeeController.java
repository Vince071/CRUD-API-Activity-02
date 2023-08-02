package com.example.demo;

import com.example.demo.Employee.Employee;
import com.example.demo.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService =  employeeService;
    }

    @GetMapping
    public List<Employee> getEmployee (){
        return employeeService.getEmployee();

    }

    @PostMapping
    public void AddNewEmployee(@RequestBody Employee employee ){
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Integer salary,
            @RequestParam(required = false) Integer companyId)
    {
        employeeService.updateEmployee(employeeId, name, address, salary, companyId);
    }


}
