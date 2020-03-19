package com.simplilearn.hibernatedemo.many;

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
public class CreateProjectThenAddEmployee 
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
    				//start transaction
    				session.beginTransaction();
    				
    				
    				
    				Project pro1 = new Project("A122","Basic Home Electronics");
    				
    				session.save(pro1);
    				
    				System.out.println("Project : "+pro1);
    				
    				Employee employee1 = new Employee("Miki", "Smith", 2000, "Dev");
    				Employee employee2 = new Employee("Sami", "Smith", 2000, "Dev");
    				
    				pro1.add(employee1);
    				pro1.add(employee2);
    				
    				session.save(employee1);
    				session.save(employee2);
    				    				
    				System.out.println("Saved Employee"+pro1.getEmployee());
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
