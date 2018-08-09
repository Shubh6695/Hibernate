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
		
		
		ProductDTO pdto=new ProductDTO();
		
		pdto.setProductid(501);
		
		pdto.setProductname("Laptop");
		
		
		
																ManufacturerDTO mdto1=new ManufacturerDTO();
																
																mdto1.setMid(601);
																
																mdto1.setName("DELL");
																
																mdto1.setEmail("dell@gmail.com");
		
																mdto1.setAddress("India");
																	
																mdto1.setLicenceno(101010);
		
																mdto1.setValidity(2020);
																
																mdto1.setProductParent(pdto);
																
																
																
																ManufacturerDTO mdto2=new ManufacturerDTO();
																
																mdto2.setMid(602);
																
																mdto2.setName("APPLE");
																
																mdto2.setEmail("apple@gmail.com");
		
																mdto2.setAddress("America");
																	
																mdto2.setLicenceno(102030);
		
																mdto2.setValidity(2025);
																
																mdto2.setProductParent(pdto);
																
																
																ManufacturerDTO mdto3=new ManufacturerDTO();
																
																mdto3.setMid(603);
																
																mdto3.setName("HP");
																
																mdto3.setEmail("hp@gmail.com");
		
																mdto3.setAddress("China");
																	
																mdto3.setLicenceno(101020);
		
																mdto3.setValidity(2022);
																
																mdto3.setProductParent(pdto);																
								
																
																
		sess.save(mdto1);
		
		sess.save(mdto2);
		
		sess.save(mdto3);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("Inserted Successfully");
		
		sess.close();
		
		sf.close();
		
																
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		InsertALL();
		
	}
	
	
	
}
