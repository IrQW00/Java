package com.module.spring.mvc;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class MyController {
    @RequestMapping
    public String showFirstView() { return "first-view"; }
    @RequestMapping
    public String askEmployeeDetails(Model model){

//        Employee emp = new Employee();
//        emp.setName("Ivan");
//        emp.setSurname("Petrov");
//        emp.setSalary(5000);
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

//    @RequestMapping
//    public String showEmpDetails(){
//        return "show-emp-details-view";
//    }

//    @RequestMapping
//    public String showEmpDetails(HttpServletRequest request, Model model){
//
//        String empName = request.getParameter("employeeName");
//        empName = "Ms " + empName;
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("description", "- udemy instructor");
//
//        return "show-emp-details-view";
//    }

    @RequestMapping
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp,
                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "ask-emp-details-view";
        }
        else{
            return "show-emp-details-view";
        }
//        empName = "Ms. " + empName + "!";
//        model.addAttribute("nameAttribute", empName);

//        String name = emp.getName();
//        emp.setName("Mr. " + name);
//
//        String surname = emp.getSurname();
//        emp.setSurname(surname + "!");
//
//        int salary = emp.getSalary();
//        emp.setSalary(salary*10);
    }
}
