package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test 
{

	
	public static void InsertALL() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
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
	
	
	
									
									CarDTO cdto2=new CarDTO();
									
									cdto2.setCarid(505);	
										
									cdto2.setBrand("Mahindra");
	
									cdto2.setModel("TUV 300");
	
									cdto2.setColor("BLACK");	
	
									cdto2.setPurchaseyear(2016);
									
									

									CarDTO cdto3=new CarDTO();
									
									cdto3.setCarid(506);	
										
									cdto3.setBrand("Hyundai");
	
									cdto3.setModel("VERNA");
	
									cdto3.setColor("WHITE");	
	
									cdto3.setPurchaseyear(2018);


		Set s= new HashSet();
		
		s.add(cdto1);
		
		s.add(cdto2);
		
		s.add(cdto3);
		
									
		odto.setOwnerChild(s);
		
		
		Transaction ts= sess.beginTransaction();
		
		sess.save(odto);
		
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
									
	}
	
	
	public static void GETOWNERLIST() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Query q1= sess.createQuery("from OwnerDTO");
		
		
		List rows=q1.list();
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			OwnerDTO odto=(OwnerDTO) itr.next();
			
			
			System.out.println(odto.getOwnerid()+"\t"+odto.getOwnername()+"\t"+odto.getOwneremail()+"\t"+odto.getOwnergender()+"\t"+odto.getOwnergender());
			
			System.out.println();
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertALL();
		
		GETOWNERLIST();
		
		
		
	}
	
	
}
