package co.in.Main;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

import co.in.DTO.DepartmentDTO;
import co.in.DTO.EmployeeDTO;


public class Test {

	public static void insertALL() {

		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		Transaction ts=sess.beginTransaction();
		
		
		DepartmentDTO dep=new DepartmentDTO();
		
		dep.setDepartmentid(1001);
		
		dep.setDepartmentname("Developing");
		
		
		
							EmployeeDTO emp1=new EmployeeDTO();
							
							emp1.setEid(5001);
		
							emp1.setFname("Shubham");
		
							emp1.setLname("Tale");
							
							emp1.setEmail("shubham@gmail.com");
							
							emp1.setMobile(9039553040l);
							
							emp1.setSalary(20000.00);
							
							emp1.setDepParent(dep);
							
							
							EmployeeDTO emp2=new EmployeeDTO();
							
							emp2.setEid(5002);
		
							emp2.setFname("Aman");
		
							emp2.setLname("Jain");
							
							emp2.setEmail("aman@gmail.com");
							
							emp2.setMobile(9998887770l);
							
							emp2.setSalary(25000.00);

							emp2.setDepParent(dep);
							
							
							EmployeeDTO emp3=new EmployeeDTO();
							
							emp3.setEid(5003);
		
							emp3.setFname("Vijay");
		
							emp3.setLname("Patel");
							
							emp3.setEmail("vijay@gmail.com");
							
							emp3.setMobile(9998889998l);
							
							emp3.setSalary(10000.00);

							emp3.setDepParent(dep);
							
							
							
		sess.save(emp1);
		
		sess.save(emp2);
		
		sess.save(emp3);
		
		
		ts.commit();					
							
		System.out.println("Insert Successfully");					
							
		sess.close();
		
		sf.close();
		
							
							
	}

	public static void getALL()
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		Query q=sess.createQuery("from EmployeeDTO");
		
		List rows=q.list();
		
		Iterator itr1=rows.iterator();
		
		while(itr1.hasNext())
		{
			
			EmployeeDTO emp=(EmployeeDTO)itr1.next();
			
			DepartmentDTO dep=emp.getDepParent();
			
			System.out.println(dep.getDepartmentid()+"\t"+dep.getDepartmentname()+"\n");
			
			System.out.println(emp.getEid()+"\t"+emp.getFname()+"\t"+emp.getLname()+"\t"+emp.getEmail()+"\t"+emp.getMobile()+"\t"+emp.getSalary()+"\n");
			
			
		}
		
		
	}
	
	
	public static void updateParent(Integer eid)
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		Transaction ts=sess.beginTransaction();
		
		Query q=sess.createQuery("from EmployeeDTO");
		
		List rows=q.list();

		
		if(!rows.isEmpty())
		{
			
		Iterator itr1=rows.iterator();
		
		while(itr1.hasNext())
		{
			
			EmployeeDTO emp=(EmployeeDTO)itr1.next();
			
			if(emp.getEid().equals(eid))
			{
				
				DepartmentDTO dep=emp.getDepParent();
				
				dep.setDepartmentname("Testing");
				
				sess.update(emp);
				
				ts.commit();
				
				System.out.println("Update Successfully");
		
				break;
			}
		
			else 
			{
				System.out.println("Employee NOT FOUND");
				
			}
			
		}	
		
		}
		
		else
		{
			
			System.out.println("Employee Table is Empty");
			
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void delete(Integer eid)
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		Transaction ts=sess.beginTransaction();
		
		EmployeeDTO emp=(EmployeeDTO)sess.get(EmployeeDTO.class, eid);
		
		sess.delete(emp);
		
		ts.commit();
		
		System.out.println("Delete Successfully");
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) {

	//	insertALL();

	//	getALL();
		
	//	updateParent(5005);
		
		delete(5001);																				// Error
		
		
	}

}
