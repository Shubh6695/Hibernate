package co.in.MAIN;

import co.in.DTO.*;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	
	public static void insertALL() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		StudentDTO student=new StudentDTO();
		
		student.setSid(501);
		
		student.setFname("Shubham");
		
		student.setLname("Tale");
		
		student.setEmail("shubham@gmail.com");
		
		student.setAge(24);
		
		student.setMobile(999666333);
		
		
		
													AddressDTO address=new AddressDTO();
													
													address.setCity("Indore");
		
													address.setState("Madhya Pradesh");
													
													address.setCountry("India");
													
													address.setPincode(452010);
													
													address.setStudentParent(student);
													
													
		Transaction ts=sess.beginTransaction();
		
		sess.save(address);
		
		ts.commit();
		
		System.out.println("Insert Successfully");
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		insertALL();
		
	}
	
	
}
