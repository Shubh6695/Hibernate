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
		
		
		DepartmentDTO dc1=new DepartmentDTO();
		
		dc1.setDepartmentid(101);
		
		dc1.setDepartmentname("Physics");
		
		
										StudentDTO sdto1=new StudentDTO();
										
										sdto1.setSid(301);
										
										sdto1.setFname("Shubham");
										
										sdto1.setLname("Tale");
		
										sdto1.setEmail("shubham@gmail.com");
										
										sdto1.setBranch("Computer Science");
										
										sdto1.setMobile(111222333);
										
		
										StudentDTO sdto2=new StudentDTO();
										
										sdto2.setSid(302);
										
										sdto2.setFname("Ankit");
										
										sdto2.setLname("Sharma");
		
										sdto2.setEmail("ankit@gmail.com");
										
										sdto2.setBranch("Information Technology");
										
										sdto2.setMobile(111333222);
										
										
										StudentDTO sdto3=new StudentDTO();
										
										sdto3.setSid(303);
										
										sdto3.setFname("Pankaj");
										
										sdto3.setLname("Trivedi");
		
										sdto3.setEmail("pankaj@gmail.com");
										
										sdto3.setBranch("Civil");
										
										sdto3.setMobile(111555444);

										
		Set s=new HashSet();
		
		s.add(sdto1);
		
		s.add(sdto2);
		
		s.add(sdto3);
		
		
		dc1.setDepartmentChild(s);
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(dc1);
		
		ts.commit();
		
		
		System.out.println("Successfully Inserted");
		
		
		sess.close();
		
		sf.close();
		
										
		
	}
	
	
	public static void InsertDepartmentOnly() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		
		DepartmentDTO dc1=new DepartmentDTO();
		
		dc1.setDepartmentid(102);
		
		dc1.setDepartmentname("MATHS");
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(dc1);
		
		
		ts.commit();
		
		
		System.out.println("New Department Inserted");
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
public static void main(String[] args) throws Exception
{
	InsertALL();
	
//	InsertDepartmentOnly();
	
	
	
}
	
	
	
}
