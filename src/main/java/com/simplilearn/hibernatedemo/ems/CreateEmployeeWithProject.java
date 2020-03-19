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
public class CreateEmployeeWithProject 
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
    				
    				Employee employee = new Employee("Rohn", "Smith", 2000, "Dev");
    				Payroll payroll = new Payroll("1000$", "$1000", "$1800", "$200");
    				
    			
    				Project pro1 = new Project("A121","Wood Working Around the House");
    				Project pro2 = new Project("A122","Basic Home Electronics");
    				    				
    				employee.add(pro1);
    				employee.add(pro2);
    				    				
    				employee.setPayroll(payroll);
    				//start transaction
    				session.beginTransaction();
    				session.save(pro1);
    				session.save(pro2);
    				
    				session.save(employee);
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
