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
		
		
		DoctorDTO dc1=new DoctorDTO();
		
		dc1.setDoctorid(1001);
		
		dc1.setDname("Dr. Somesh");
		
		dc1.setEmail("somesh@gmail.com");
		
		dc1.setAddress("Pune");
		
		dc1.setMobile(999888777);
		
		dc1.setSpecialistIn("Heart");
		
		
		
									PatientDTO p1=new PatientDTO();
									
									p1.setPatientid(301);
		
									p1.setPname("Aman");	
		
									p1.setPemail("aman@gmail.com");	
		
									p1.setAge(36);	
		
									p1.setMobile(111222333);	
									
									p1.setDisease("Heart Pain");
		
		
		
									
									PatientDTO p2=new PatientDTO();
									
									p2.setPatientid(302);
		
									p2.setPname("Raju");	
		
									p2.setPemail("raju@gmail.com");	
		
									p2.setAge(52);	
		
									p2.setMobile(111000111);	
									
									p2.setDisease("Chest Pain");
		
									
									
									
									PatientDTO p3=new PatientDTO();
									
									p3.setPatientid(303);
		
									p3.setPname("Nilesh");	
		
									p3.setPemail("nilesh@gmail.com");	
		
									p3.setAge(85);	
		
									p3.setMobile(111444777);	
									
									p3.setDisease("Heart Pain");

									
			
		Set s= new HashSet();							
									
						
		s.add(p1);
		
		s.add(p2);
		
		s.add(p3);
		
		
		
		dc1.setDoctorChild(s);
		
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(dc1);
		
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		
		sf.close();
		
		
		
	}
	
	
	public static void InsertDOCTORONLY() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		DoctorDTO dc1=new DoctorDTO();
		
		dc1.setDoctorid(1002);
		
		dc1.setDname("Dr. Nilesh");
		
		dc1.setEmail("somesh@gmail.com");
		
		dc1.setAddress("Indore");
		
		dc1.setMobile(999666555);
		
		dc1.setSpecialistIn("EYE");

	
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(dc1);
		
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		
		sf.close();
	
		
		
		
		
	}
	
	
	public static void UpdateDOCTORONLY(int DID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		DoctorDTO dc1=(DoctorDTO) sess.get(DoctorDTO.class, DID);
		
		
		dc1.setEmail("nilesh007@gmail.com");
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.update(dc1);
		
		ts.commit();
		
		
		System.out.println("Update Succcessfully");
		
		sess.close();
		
		
		
	}
	
	
	
	public static void InsertPATIENTONLY(int DID) throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		
		DoctorDTO dc=(DoctorDTO) sess.get(DoctorDTO.class, DID);
		
		
		System.out.println("Add  NEW Patient Under "+dc.getDname());
		
		
		
					PatientDTO p1=new PatientDTO();
					
					p1.setPatientid(306);
		
					p1.setPname("Shubham");
		
					p1.setPemail("shubham@gmail.com");
					
					p1.setAge(42);
		
					p1.setMobile(111555999);
					
					p1.setDisease("EYE Problem");
					
					
					
					
					PatientDTO p2= new PatientDTO();
					
					p2.setPatientid(307);
					
					p2.setPname("Naveen");
					
					p2.setPemail("naveen@gmail.com");
					
					p2.setAge(12);
					
					p2.setMobile(111444222);
					
					p2.setDisease("EYE Problem");
					

					
					PatientDTO p3= new PatientDTO();
					
					p3.setPatientid(308);
					
					p3.setPname("Vijay");
					
					p3.setPemail("vijay@gmail.com");
					
					p3.setAge(64);
					
					p3.setMobile(111888999);
					
					p3.setDisease("EYE Problem");
					
					
		
					
					
		Set s= new HashSet();			
					
		s.add(p1);
		
		s.add(p2);
		
		s.add(p3);
		
		
		dc.setDoctorChild(s);
		
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.update(dc);
		
		ts.commit();
		
		
		System.out.println("Patient Successfully Inserted");
		
		
		sess.close();
		
		sf.close();
		
					
	}
	
	
	public static void DeleteDoctorPatientBOTH(int DID) throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		DoctorDTO dc=(DoctorDTO)sess.get(DoctorDTO.class, DID);
		
		
		System.out.println("Doctor's Details");
		
		System.out.println(dc.getDoctorid()+"\t"+dc.getDname());
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.delete(dc);
		
		ts.commit();
		
		
		System.out.println("DELETED Successfully");
		
		
		sess.close();
		
		
		sf.close();
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertALL();
		
	//	InsertDOCTORONLY();
		
	//	UpdateDOCTORONLY(1002);
		
	//	InsertPATIENTONLY(1002);
		
		DeleteDoctorPatientBOTH(1002);
		
	}
	
	
}
