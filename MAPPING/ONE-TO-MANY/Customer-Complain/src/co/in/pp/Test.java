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
		
		
		CustomerDTO dto=new CustomerDTO();
		
		
		dto.setCid(101);
		
		dto.setName("Shubham");
		
		dto.setEmail("shubham@gmail.com");
		
		dto.setAddress("Indore");
		
		dto.setMobile(999555111);
		
		
		
											ComplainDTO cdto1=new ComplainDTO();
											
											cdto1.setComplainid(201);
		
											cdto1.setComplaindetail("Mobile Lost");
											
											cdto1.setComplaintype("Losting");
											
											cdto1.setComplainstatus("NOT Resolved");
		
											
											ComplainDTO cdto2=new ComplainDTO();
											
											cdto2.setComplainid(202);
		
											cdto2.setComplaindetail("Wallet Lost");
											
											cdto2.setComplaintype("Losting");
											
											cdto2.setComplainstatus("Resolved");
											
											
											
											ComplainDTO cdto3=new ComplainDTO();
											
											cdto3.setComplainid(203);
		
											cdto3.setComplaindetail("Mobile Lost");
											
											cdto3.setComplaintype("Losting");
											
											cdto3.setComplainstatus("Resolved");

											
		Set s= new HashSet();
		
		s.add(cdto1);
		
		s.add(cdto2);
		
		s.add(cdto3);
		
		
		dto.setCustomerChild(s);
		
		
								
		Transaction ts= sess.beginTransaction();
		
		sess.save(dto);
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
	
		
		sess.close();
		
		
		sf.close();
		
		
	}
	
	
	public static void GetALL() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		
		CustomerDTO dto=(CustomerDTO) sess.get(CustomerDTO.class, 101);
		
		
		System.out.println(dto.getCid()+"\t"+dto.getName()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile());
		
		System.out.println();
		
		
		Set s=dto.getCustomerChild();
		
		if(s.size() != 0)
		{
			
			Iterator itr=s.iterator();
			
			while(itr.hasNext())
			{
			
			ComplainDTO cdto=(ComplainDTO) itr.next();
			
			
			System.out.println(cdto.getComplainid()+"\t"+cdto.getComplaintype()+"\t"+cdto.getComplaindetail()+"\t"+cdto.getComplainstatus());
			
			System.out.println();
			
			
			}
		}
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	
	public static void main(String[] args)throws Exception
	{
		
	//	InsertALL();
		
		
		GetALL();
		
		
	}
	
	
}
