package dao;

import com.mysql.cj.Session;
import entity.Employee;
import com.mysql.cj.Query;
import com.mysql.cj.xdevapi.SessionFactory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
//    @Transactional
    public List<Employee> getAllEmployees() {

//        Session session = sessionFactory.getCurrentSession();
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
//        Query <Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();
//        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return  employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee"+
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
