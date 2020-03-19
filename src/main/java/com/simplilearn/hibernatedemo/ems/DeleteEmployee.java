package com.simplilearn.hibernatedemo.ems;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.hibernatedemo.entity.Employee;
import com.simplilearn.hibernatedemo.entity.Payroll;


/**
 * Hello world!
 *
 */
public class DeleteEmployee 
{
    public static void main( String[] args )
    {
    			//1. create session factory		
    			SessionFactory factory = new Configuration()
    									.configure("hibernate.cfg.xml")
    									.addAnnotatedClass(Employee.class)
    									.addAnnotatedClass(Payroll.class)
    									.buildSessionFactory();
    			
    			//2.create a session (open a session)
    			Session session = factory.getCurrentSession();
    			
    			// 3. perform operations
    			try {
    				// start a transaction
    				session.beginTransaction();
    				
    				int theId = 1;
    				Employee employee = 
    						session.get(Employee.class, theId);
    				
    				System.out.println("Found Employee: " + employee);
    				
    				// delete the instructors
    				if (employee != null) {
    				
    					System.out.println("Deleting: " + employee);
    					
    					// Note: will ALSO delete associated "details" object
    					// because of CascadeType.ALL
    					//
    					session.delete(employee);				
    				}
    			
    				session.getTransaction().commit();
    				
    				
    				System.out.print("Done !");
    				
    				
    				
    			}catch (Exception e) {
    				e.printStackTrace();
    			}
    			finally {
    				factory.close();
    			}
    }
 
}
