package com.mod8.spring.springboot.spring_course_springboot.dao;

import com.mod8.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

   public void saveEmployee(Employee employee);

    public  Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
