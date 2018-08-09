package co.in.DTO;



import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Main 
{

	
	public static void getAllCustomer() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();	
	
		long count=0;
		
		
		Query q=sess.createQuery("from CustomerDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		CustomerDTO cdto=null;
		
		while(itr.hasNext())
		{
			
			cdto=(CustomerDTO) itr.next();
			
			
			Set s=cdto.getUserChild();
						
			Iterator itr2=s.iterator();
			
			while(itr2.hasNext())
		
			{
				UserDTO udto=(UserDTO) itr2.next();
				
				System.out.println(udto.getUid()+"\t"+udto.getUname()+"\t"+udto.getFname()+"\t"+udto.getLname()+"\t"+udto.getGender()+"\t"+udto.getCid()+"\t\t\t"+cdto.getCustomerid()+"\t"+cdto.getCustomername()+"\t"+cdto.getCity()+"\t"+cdto.getState());
				
			
				count++;
			}
		
			
		}
		
		
		System.out.println("ALL Record Fetched Successfully");
		
	
		System.out.println("Count is :-- "+count);
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void getALLCustomer(int CID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();	
		
		int count=1;
		
		CustomerDTO cdto=(CustomerDTO) sess.get(CustomerDTO.class, CID);
		
			
			Set s=cdto.getUserChild();
						
			Iterator itr2=s.iterator();
			
			while(itr2.hasNext())
		
			{
				UserDTO udto=(UserDTO) itr2.next();
				
				System.out.println(udto.getUid()+"\t"+udto.getUname()+"\t"+udto.getFname()+"\t"+udto.getLname()+"\t"+udto.getGender()+"\t"+udto.getCid()+"\t\t\t"+cdto.getCustomerid()+"\t"+cdto.getCustomername()+"\t"+cdto.getCity()+"\t"+cdto.getState());
				
				
				count++;
			}
			
		
		
		
		System.out.println("ALL Record  Fetched Successfully");
		
		System.out.println("Count is :-- "+count);
		
		
		sess.close();
		
		sf.close();
		
	}
	

	
	
	
	
	
	public static void updateAllUSER(Integer min, Integer max) throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();	
		
	
		
		Query q1=sess.createQuery("from UserDTO");
		
		List rows=q1.list();
		
		Iterator itr1=rows.iterator();
		
		
		while(itr1.hasNext())
		{
			
			UserDTO udto=(UserDTO) itr1.next();
			
			Integer r=(int) ((Math.random() * ((max-min)+ 1)) +min);
			
			udto.setCid(r);
			
		
			sess.update(udto);
		}
		
		
		Transaction ts=sess.beginTransaction();
		
		
		
		ts.commit();
		
		System.out.println("Update Successfully");
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		getAllCustomer();
		
		
	//	getALLCustomer(9690);
		
		
	//	updateAllUSER(1, 9690); 
		
	}
	
	
	
}
