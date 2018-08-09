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
		
		
		OwnerDTO odto=new OwnerDTO();
		
		odto.setOwnerid(102);
		
		odto.setOwnername("Deepika");
		
		odto.setOwneremail("deepika@gmail.com");
		
		odto.setOwnergender("Female");
		
		odto.setOwnermobile(999888777);
		
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

												
		
		
	sess.save(cdto1);
	
	sess.save(cdto2);
	
	sess.save(cdto3);
	
	
	Transaction ts=sess.beginTransaction();
	
	ts.commit();
	
	System.out.println("Inserted Successfully");
	
											
	
	sess.close();
	
	sf.close();
		
	}
	
	
	public static void GETBOTH(int OID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from CarDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			CarDTO car=(CarDTO) itr.next();
			
			if(car.getOwnerParent().getOwnerid() == OID)
			{
				
				
				
				System.out.println(car.getCarid()+"\t\t"+car.getBrand()+"\t\t"+car.getModel()+"\t\t"+car.getColor()+"\t\t"+car.getPurchaseyear());
				
				
				System.out.println();
				
			}
			
			else
			{
				
				System.out.println("Owner Not Found");
			
			}
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertALL();
		
		
		GETBOTH(101);
		
		
	}
	

}
