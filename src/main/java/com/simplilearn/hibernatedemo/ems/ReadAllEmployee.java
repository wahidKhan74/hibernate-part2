package com.simplilearn.hibernatedemo.ems;

import java.security.KeyStore.PasswordProtection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.hibernatedemo.entity.Employee;
import com.simplilearn.hibernatedemo.entity.Payroll;
import com.simplilearn.hibernatedemo.entity.Project;


/**
 * Hello world!
 *
 */
public class ReadAllEmployee 
{
    public static void main( String[] args )
    {
    			//1. create session factory		
    			SessionFactory factory = new Configuration()
    									.configure("hibernate.cfg.xml")
    									.addAnnotatedClass(Employee.class)
    									.addAnnotatedClass(Payroll.class)
    									.addAnnotatedClass(Project.class)
    									.buildSessionFactory();
    			
    			//2.create a session (open a session)
    			Session session = factory.getCurrentSession();
    			
    			// 3. perform operations
    			try {
    				
//    				Employee employee = new Employee("Will", "Smith", 2000, "Dev");
//    				Payroll payroll = new Payroll("1000$", "$1000", "$1800", "$200");
//    				employee.setPayroll(payroll);
//    				//start transaction
    				session.beginTransaction();
//    				session.save(employee);
//    				session.getTransaction().commit();
    				
    				
    				System.out.print("Done !");
    				
    				List <Employee>listOfEmp = session.createQuery("from Employee as e").getResultList();
    				
    				display(listOfEmp);
    				
    			}catch (Exception e) {
    				e.printStackTrace();
    			}
    			finally {
    				factory.close();
    			}
    }
 // display
 	private static void display(List <Employee> listOfEmp) {		
 		for(Employee emp : listOfEmp) {			
 			System.out.println(emp);			
 		}
 	}
}
