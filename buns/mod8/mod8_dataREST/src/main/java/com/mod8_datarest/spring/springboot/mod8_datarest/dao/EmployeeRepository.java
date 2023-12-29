package com.mod8_datarest.spring.springboot.mod8_datarest.dao;


//import com.mod8_jpa.spring.springboot.spring_data_jpa.entity.Employee;
import com.mod8_datarest.spring.springboot.mod8_datarest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
