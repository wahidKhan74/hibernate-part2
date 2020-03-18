package com.simplilearn.hibernatedemo.ems;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.hibernatedemo.entity.Employee;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    			//1. create session factory		
    			SessionFactory factory = new Configuration()
    									.configure("hibernate.cfg.xml")
    									.addAnnotatedClass(Employee.class)
    									.buildSessionFactory();
    			
    			//2.create a session (open a session)
    			Session session = factory.getCurrentSession();
    			
    			// 3. perform operations
    			try {
    							
    				//start transaction
    				session.beginTransaction();
    				
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
