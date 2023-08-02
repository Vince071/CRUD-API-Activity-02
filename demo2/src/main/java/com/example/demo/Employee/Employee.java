package com.example.demo.Employee;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )

    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String address;

    private Integer CompanyId;

    private LocalDate Date_Hired;

    @Transient

    private Integer YearsCompany;

    private Integer Salary;

    public Employee() {
    }

    public Employee(Long id, String name, String address, Integer companyId, LocalDate date_Hired, Integer Salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        CompanyId = companyId;
        Date_Hired = date_Hired;
        this.Salary = Salary;

    }

    public Employee(String name, String address, Integer companyId, LocalDate date_Hired, Integer Salary) {
        this.name = name;
        this.address = address;
        CompanyId = companyId;
        Date_Hired = date_Hired;
        this.Salary = Salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(Integer companyId) {
        CompanyId = companyId;
    }

    public LocalDate getDate_Hired() {
        return Date_Hired;
    }

    public void setDate_Hired(LocalDate date_Hired) {
        Date_Hired = date_Hired;
    }

    public Integer getYearsCompany(){
        return Period.between(this.Date_Hired, LocalDate.now()).getYears();
    }

    public void setYearsCompany(Integer YearsCompany){
        this.YearsCompany = YearsCompany;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", CompanyId=" + CompanyId +
                ", Date_Hired=" + Date_Hired +
                ", YearsCompany=" + YearsCompany +
                ", Salary=" + Salary +
                '}';
    }
}
