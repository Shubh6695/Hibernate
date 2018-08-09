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
		
		
		DoctorDTO dto=new DoctorDTO();
		
		dto.setDoctorid(1001);
		
		dto.setDname("Dr. Somesh");
		
		dto.setEmail("somesh@gmail.com");
		
		dto.setAddress("Pune");
		
		dto.setMobile(999888777);
		
		dto.setSpecialistIn("Heart");
		
		
													
														PatientDTO pdto1=new PatientDTO();
													
														pdto1.setPatientid(301);
		
														pdto1.setPname("Aman");
														
														pdto1.setPemail("aman@gmail.com");
															
														pdto1.setAge(36);
		
														pdto1.setMobile(111222333);
														
														pdto1.setDisease("Heart Pain");
														
														pdto1.setDoctorParent(dto);
	
														
														
														
														
														PatientDTO pdto2=new PatientDTO();
														
														pdto2.setPatientid(302);
		
														pdto2.setPname("Raju");
														
														pdto2.setPemail("raju@gmail.com");
															
														pdto2.setAge(52);
		
														pdto2.setMobile(111000111);
														
														pdto2.setDisease("Chest Pain");
														
														pdto2.setDoctorParent(dto);
														
														
														PatientDTO pdto3=new PatientDTO();
														
														pdto3.setPatientid(303);
		
														pdto3.setPname("Nilesh");
														
														pdto3.setPemail("nilesh@gmail.com");
															
														pdto3.setAge(85);
		
														pdto3.setMobile(111444777);
														
														pdto3.setDisease("Heart Pain");
														
														pdto3.setDoctorParent(dto);
														
	
														
														sess.save(pdto1);
														
														sess.save(pdto2);
														
														sess.save(pdto3);
														
														
				Transaction ts=sess.beginTransaction();	
				
				ts.commit();
				
				
				System.out.println("Insert Successfully");
				
				sess.close();
				
				
				sf.close();
														
														
	}
	
	
	
	public static void GETALL() throws Exception
	{

		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();

		
		Query q1=sess.createQuery("from PatientDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			PatientDTO pdto=(PatientDTO) itr.next();
			
			
			System.out.println("Informartion about Patient");
			
			System.out.println(pdto.getPatientid()+"\t"+pdto.getPname()+"\t"+pdto.getPemail()+"\t"+pdto.getAge()+"\t"+pdto.getMobile()+"\t"+pdto.getDisease());
			
			
			System.out.println("Informartion about Doctor");
			
			
			System.out.println(pdto.getDoctorParent().getDoctorid()+"\t"+pdto.getDoctorParent().getDname()+"\t"+pdto.getDoctorParent().getEmail()+"\t"+pdto.getDoctorParent().getMobile()+"\t"+pdto.getDoctorParent().getAddress()+"\t"+pdto.getDoctorParent().getSpecialistIn());
			
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertALL();
		
		GETALL();
		
		
	}
	
	
	
}
