package com.example.demo.Employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getEmployee (){
        return employeeRepository.findAll();

    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeByCompanyId = employeeRepository.findEmployeeByCompanyId(employee.getCompanyId());

        if (employeeByCompanyId.isPresent()){
            throw new IllegalStateException("Company Taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists){
            throw new IllegalStateException("employee with ID" + employeeId + " does not exists");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional

    public void updateEmployee(Long employeeId, String name, String address, Integer salary, Integer companyId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("employee with id" + employeeId + "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(employee.getName(), name)){
            employee.setName(name);
        }

        if (address != null && address.length() > 0 && !Objects.equals(employee.getAddress(), address)){
            employee.setAddress(address);
        }
        if (salary != null && salary.intValue() > 0 && !Objects.equals(employee.getSalary(), salary)){
            employee.setSalary(salary);
        }

        if (companyId != null && companyId.intValue() > 0 && !Objects.equals(employee.getCompanyId(), companyId)){
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByCompanyId(companyId);
            if (employeeOptional.isPresent()) {
                throw new IllegalStateException("Company Id Taken");
            }
            employee.setCompanyId(companyId);
        }

    }
}
