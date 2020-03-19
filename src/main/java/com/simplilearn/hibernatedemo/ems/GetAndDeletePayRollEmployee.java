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
public class GetAndDeletePayRollEmployee 
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
    				
    				int theId = 3;
    				Payroll payroll = 
    						session.get(Payroll.class, theId);
    				
    				System.out.println("Payroll Employee: " + payroll);
    				
    				System.out.println(" Employee: " + payroll.getEmployee());
    				
    				// delete the instructors
    				if (payroll != null) {
    				
    					System.out.println("Deleting: " + payroll);
    					

    					// remove the associated object reference
    					// break bi-directional link
    					
    					payroll.getEmployee().setPayroll(null);
    					
    					// Note: will ALSO delete associated "employee" object
    					// because of CascadeType.ALL
    					//
    					session.delete(payroll);				
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
