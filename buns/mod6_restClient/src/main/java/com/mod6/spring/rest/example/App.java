package com.mod6.spring.rest.example;

import com.mod6.spring.rest.Communication;
import com.mod6.spring.rest.configuration.MyConfig;
import com.mod6.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee empByID = communication.getEmployee(1);
//        System.out.println(empByID);

//        Employee emp = new Employee("Sveta", "Sokolova", "HR", 1200);
//        emp.setId(18);
//        communication.saveEmployee(emp);

        communication.deleteEmployee(18);
    }
}
