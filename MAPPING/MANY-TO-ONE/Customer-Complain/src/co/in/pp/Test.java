package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{
	
	public static void InsertALL() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess= sf.openSession();
		
		
		CustomerDTO cust=new CustomerDTO();
		
		cust.setCid(101);
		
		cust.setName("Shubham");
		
		cust.setEmail("shubham@gmail.com");
		
		cust.setAddress("Indore");
		
		cust.setMobile(999555111);
		
		
																	ComplainDTO complain=new ComplainDTO();
																	
																	complain.setComplainid(201);
		
																	complain.setComplaindetail("Mobile Lost");
		
																	complain.setComplaintype("Losting");
																	
																	complain.setComplainstatus("NOT Resolved");
																	
																	complain.setCustomerParent(cust);
																	
																	
																	sess.save(complain);
																	
		
																	
			Transaction ts=sess.beginTransaction();
			
			ts.commit();
			
			System.out.println("Insert Successfully");
			
			
			sess.close();
			
			sf.close();
			
																	
	}
	
	
	public static void DeleteBOTH(int COMPLAIN_ID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		ComplainDTO complain=(ComplainDTO) sess.get(ComplainDTO.class, COMPLAIN_ID);
		
		
		System.out.println("Complain Detail's");
		
		System.out.println(complain.getComplainid()+"\t"+complain.getComplaindetail()+"\t"+complain.getComplaintype()+"\t"+complain.getComplainstatus());
		
		System.out.println("Now Record Deleted");
		
		
		sess.delete(complain);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("Record Deleted Successfully");
		
		sess.close();
		
		
		sf.close();
		
		
		
	}
	
	public static void GetBOTH() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from ComplainDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			ComplainDTO complain=(ComplainDTO) itr.next();
			
			
			System.out.println("Complain Detail's");
			
			System.out.println(complain.getComplainid()+"\t"+complain.getComplaindetail()+"\t"+complain.getComplaintype()+"\t"+complain.getComplainstatus());
			
			System.out.println();
			
			
			System.out.println("Customer Detail's");
			
			System.out.println(complain.getCustomerParent().getCid()+"\t"+complain.getCustomerParent().getName()+"\t"+complain.getCustomerParent().getEmail()+"\t"+complain.getCustomerParent().getAddress()+"\t"+complain.getCustomerParent().getMobile());
			
			System.out.println();
			
		}
		
		sess.close();
		
		sf.close();
	
	
	}
	
	
	public static void UpdateChild(int COMPLAIN_ID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();

		
		ComplainDTO complain=(ComplainDTO) sess.get(ComplainDTO.class, COMPLAIN_ID);
		
		
		complain.setComplainstatus("Resolved");
		
		
		sess.update(complain);
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		System.out.println("Update Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	
	public static void main(String[] aregs) throws Exception
	{
		
		
	//	InsertALL();
		
	//	DeleteBOTH(201);
		
	//	GetBOTH();
		
		UpdateChild(201);
		
		
	}
	
	
}
