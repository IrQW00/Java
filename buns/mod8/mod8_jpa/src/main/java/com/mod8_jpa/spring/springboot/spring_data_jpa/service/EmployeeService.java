package com.mod8_jpa.spring.springboot.spring_data_jpa.service;

import com.mod8.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public  void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    public List<Employee> findAllByName(String name);
}
