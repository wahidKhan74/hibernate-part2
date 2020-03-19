package com.simplilearn.hibernatedemo.ems;

import java.util.ArrayList;
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
public class ReadEmployeeAddProject 
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
    				session.beginTransaction();
    				
    				int theId = 6;
    				Employee employee = 
    						session.get(Employee.class, theId);
    				
    				System.out.println("Employee: " + employee);
    				
    				System.out.println("Employee Project List : " + employee.getProjects());
    				
    				
    				session.getTransaction().commit();
    				
    				
    				System.out.print("Done !");
    				
    				
    				
    			}catch (Exception e) {
    				e.printStackTrace();
    			}
    			finally {
    				session.close();
    				factory.close();
    			}
    }
 
}
