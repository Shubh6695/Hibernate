package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	
	public static void Insert_ONE_TO_MANY() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		OwnerDTO odto=new OwnerDTO();
		
		
		odto.setOwnerid(101);
		
		odto.setOwnername("Shubham");
		
		odto.setOwneremail("shubham@gmail.com");
		
		odto.setOwnergender("Male");
		
		odto.setOwnermobile(999666333);
		

																	CarDTO cdto1=new CarDTO();
																	
																	cdto1.setCarid(501);
		
																	cdto1.setBrand("Mahindra");
		
																	cdto1.setModel("XUV 500");
		
																	cdto1.setColor("BLACK");
																	
																	cdto1.setPurchaseyear(2016);
																	
																	cdto1.setOwnerParent(odto);
																	
																	
																	CarDTO cdto2=new CarDTO();
																	
																	cdto2.setCarid(502);
		
																	cdto2.setBrand("TATA");
		
																	cdto2.setModel("SAFARI");
		
																	cdto2.setColor("WHITE");
																	
																	cdto2.setPurchaseyear(2015);
																	
																	cdto2.setOwnerParent(odto);
																	
																	
																	CarDTO cdto3=new CarDTO();
																	
																	cdto3.setCarid(503);
		
																	cdto3.setBrand("Maruti");
		
																	cdto3.setModel("SWIFT DESIRE");
		
																	cdto3.setColor("WHITE");
																	
																	cdto3.setPurchaseyear(2017);
																	
																	cdto3.setOwnerParent(odto);
																	
						
				Set s=new HashSet();
				
				s.add(cdto1);
				
				s.add(cdto2);
				
				s.add(cdto3);
																	
	odto.setCarChild(s);																
	
				sess.save(odto);
				
				Transaction ts=sess.beginTransaction();
				
				ts.commit();
				
				
				System.out.println("Inserted Successfully");
				
				
				sess.close();
				
				sf.close();
				
																	
	}
	
	
	public static void Insert_MANY_TO_ONE() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		OwnerDTO odto=new OwnerDTO();
		
		
		odto.setOwnerid(102);
		
		odto.setOwnername("Deepika");
		
		odto.setOwneremail("deepika@gmail.com");
		
		odto.setOwnergender("Female");
		
		odto.setOwnermobile(999888777);
		

																	CarDTO cdto1=new CarDTO();
																	
																	cdto1.setCarid(504);
		
																	cdto1.setBrand("Audi");
		
																	cdto1.setModel("Q 7");
		
																	cdto1.setColor("RED");
																	
																	cdto1.setPurchaseyear(2016);
																	
																	cdto1.setOwnerParent(odto);
																	
																	
																	CarDTO cdto2=new CarDTO();
																	
																	cdto2.setCarid(505);
		
																	cdto2.setBrand("Mahindra");
		
																	cdto2.setModel("TUV 300");
		
																	cdto2.setColor("Black");
																	
																	cdto2.setPurchaseyear(2016);
																	
																	cdto2.setOwnerParent(odto);
																	
																	
																	CarDTO cdto3=new CarDTO();
																	
																	cdto3.setCarid(506);
		
																	cdto3.setBrand("Hyundai");
		
																	cdto3.setModel("VERNA");
		
																	cdto3.setColor("WHITE");
																	
																	cdto3.setPurchaseyear(2018);
																	
																	cdto3.setOwnerParent(odto);
																	
						

				sess.save(cdto1);
				
				sess.save(cdto2);
				
				sess.save(cdto3);
																	
								
				
				Transaction ts=sess.beginTransaction();
				
				ts.commit();
				
				
				System.out.println("Inserted Successfully ");
				
				
				sess.close();
		
				sf.close();
	}
	
	
	
	public static void Delete_Parent_ONE_TO_MANY(int OID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		OwnerDTO odto=(OwnerDTO) sess.get(OwnerDTO.class, OID);
		
		
		System.out.println("DATA For Deletion \n");
		
		System.out.println(odto.getOwnerid()+"\t"+odto.getOwnername()+"\t"+odto.getOwneremail()+"\t"+odto.getOwnergender()+"\t"+odto.getOwnermobile());
		
		
		sess.delete(odto);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		System.out.println();
		
		
		sess.close();
		
		sf.close();
		
		
		
	}
	
	
	
	public static void Delete_Child_MANY_TO_ONE(int CID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		CarDTO cdto=(CarDTO) sess.get(CarDTO.class, CID);
		
		
		sess.delete(cdto);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		System.out.println("Deleted Successfully");
		
		sess.close();
		
		sf.close();
		
		
		
	}
	
	
	public static void main(String[] args)throws Exception
	{
		
	//	Insert_ONE_TO_MANY();
		
	//	Insert_MANY_TO_ONE();
		
		
	//	Delete_Parent_ONE_TO_MANY(101);
		
		
	//	Delete_Child_MANY_TO_ONE(504);
		
	}
	
	
}
