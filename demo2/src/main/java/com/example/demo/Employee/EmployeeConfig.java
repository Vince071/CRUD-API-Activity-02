package com.example.demo.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class EmployeeConfig {

    @Bean

    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee Vincent = new Employee(
                    "Vincent",
                    "Metro Manila",
                    230119,
                    LocalDate.of(2000, FEBRUARY, 13),
                    50000
            );

            Employee Jeyssi = new Employee(
                    "Jeyssi",
                    "Metro Manila",
                    230115,
                    LocalDate.of(2000, FEBRUARY, 13),
                    50000
            );

            repository.saveAll(
                    List.of(Vincent, Jeyssi)
            );

        };
    }
}
