package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{
	
	public static void InsertALL() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		DepartmentDTO ddto=new DepartmentDTO();
		
		ddto.setDepartmentid(101);
		
		ddto.setDepartmentname("Developing");
		
		
		
		
									EmployeeDTO edto1=new EmployeeDTO();
									
									edto1.setEid(201);
		
									edto1.setFname("Shubham");
									
									edto1.setLname("Tale");
									
									edto1.setEmail("shubham@gmail.com");
									
									edto1.setMobile(888999666);
									
									edto1.setSalary(20000);
		
									edto1.setDepParent(ddto);
									
									

									EmployeeDTO edto2=new EmployeeDTO();
									
									edto2.setEid(202);
		
									edto2.setFname("Naveen");
									
									edto2.setLname("Khapre");
									
									edto2.setEmail("naveen@gmail.com");
									
									edto2.setMobile(777666333);
									
									edto2.setSalary(35000);
		
									edto2.setDepParent(ddto);

									
									
									EmployeeDTO edto3=new EmployeeDTO();
									
									edto3.setEid(203);
		
									edto3.setFname("Shrangesh");
									
									edto3.setLname("Chourey");
									
									edto3.setEmail("shrangesh@gmail.com");
									
									edto3.setMobile(666333999);
									
									edto3.setSalary(15000);
		
									edto3.setDepParent(ddto);

								
									
									sess.save(edto1);
									
									sess.save(edto2);
									
									sess.save(edto3);
									
									
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
									
									
		sess.close();
		
		sf.close();
									
	}
	
	
	public static void GetALLEmployee() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from EmployeeDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			EmployeeDTO edto=(EmployeeDTO) itr.next();
			
			
			System.out.println(edto.getEid()+"\t"+edto.getFname()+"\t"+edto.getLname()+"\t"+edto.getEmail()+"\t"+edto.getMobile()+"\t"+edto.getSalary());
			
			System.out.println();
			
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertALL();
		
		
	//	GetALLEmployee();
		
		
		
		
		
		
	}
	
	
	

}
