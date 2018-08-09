package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test {

	
	public static void INSERTDEMO() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		TeacherDTO tdto=new TeacherDTO();
		
		
		tdto.setTeacherid(1001);
	
		tdto.setTname("Ankit");
		
		tdto.setEmail("a@gmail.com");
		
		tdto.setGender("Male");
		
		tdto.setMobile(996633);
		
		tdto.setSubject("MATHS");
		
		
		
							StudentDTO s1=new StudentDTO();
							
							s1.setStudentid(2001);
							
							s1.setFname("Shubham");	
							
							s1.setLname("Tale");
							
							s1.setAddress("Indore");	
							
							s1.setMobile(102030);	
		
		
							
							StudentDTO s2=new StudentDTO();
							
							s2.setStudentid(2002);
							
							s2.setFname("Aman");
							
							s2.setLname("Jain");
							
							s2.setAddress("Bhopal");
							
							s2.setMobile(101010);
							
							
							
							StudentDTO s3=new StudentDTO();
							
							s3.setStudentid(2003);
							
							s3.setFname("Vijay");
							
							s3.setLname("Patel");
							
							s3.setAddress("Mumbai");
							
							s3.setMobile(101122);
							
		
							
		Set s= new HashSet();
		
		s.add(s1);
		
		s.add(s2);
		
		s.add(s3);
		
		
		
		
		tdto.setTeacherChild(s);
		
		
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(tdto);
		
		
		ts.commit();
		
		System.out.println("Successfully Inserted");
		
		
		sess.close();
		
		
		sf.close();
		
							
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		INSERTDEMO();
		
	}
	
	
	
	
}
