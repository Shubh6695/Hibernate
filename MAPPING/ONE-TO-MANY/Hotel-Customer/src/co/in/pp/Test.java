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
		
		
		HotelDTO hdto1=new HotelDTO();
		
		hdto1.setHotelid(1001);
		
		hdto1.setHotelname("Sayaji");
		
		hdto1.setHotelemail("sayaji@gmail.com");
		
		hdto1.setHotelcity("Indore");
		
		hdto1.setHotelcontact(999666333);
		
		hdto1.setHotelrating(4.5f);
		
		
														CustomerDTO cdto1=new CustomerDTO();
														
														cdto1.setCid(5001);
														
														cdto1.setFname("Shubham");
		
														cdto1.setLname("Tale");
														
														cdto1.setEmail("shubham@gmail.com");
		
														cdto1.setAddress("Indore");
														
														cdto1.setMobile(111222333);
														
														cdto1.setRoomno(1);
														

														CustomerDTO cdto2=new CustomerDTO();
														
														cdto2.setCid(5002);
														
														cdto2.setFname("Ankit");
		
														cdto2.setLname("Sharma");
														
														cdto2.setEmail("ankit@gmail.com");
		
														cdto2.setAddress("Indore");
														
														cdto2.setMobile(111222444);
														
														cdto2.setRoomno(2);
														
														
										
														CustomerDTO cdto3=new CustomerDTO();
														
														cdto3.setCid(5003);
														
														cdto3.setFname("Aman");
		
														cdto3.setLname("Jain");
														
														cdto3.setEmail("aman@gmail.com");
		
														cdto3.setAddress("Bhopal");
														
														cdto3.setMobile(111222555);
														
														cdto3.setRoomno(3);

														
														CustomerDTO cdto4=new CustomerDTO();
														
														cdto4.setCid(5004);
														
														cdto4.setFname("Sunil");
		
														cdto4.setLname("Verma");
														
														cdto4.setEmail("sunil@gmail.com");
		
														cdto4.setAddress("Pune");
														
														cdto4.setMobile(111222666);
														
														cdto4.setRoomno(4);

														
														CustomerDTO cdto5=new CustomerDTO();
														
														cdto5.setCid(5005);
														
														cdto5.setFname("Naveen");
		
														cdto5.setLname("khapre");
														
														cdto5.setEmail("naveen@gmail.com");
		
														cdto5.setAddress("Mumbai");
														
														cdto5.setMobile(111222777);
														
														cdto5.setRoomno(5);

														
														
		Set s= new HashSet();					
							
		s.add(cdto1);
		
		s.add(cdto2);
		
		s.add(cdto3);
		
		s.add(cdto4);
		
		s.add(cdto5);
		
														
														
		hdto1.setHotelChild(s);												
														
					
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(hdto1);
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
														
	}
	
	
	
	public static void UpdateParent(int HID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		HotelDTO hdto1=(HotelDTO) sess.get(HotelDTO.class, HID);
		
		
		System.out.println("OLD DATA");
		
		
		System.out.println(hdto1.getHotelid()+"\t"+hdto1.getHotelname()+"\t"+hdto1.getHotelcity()+"\t"+hdto1.getHotelemail()+"\t"+hdto1.getHotelcontact()+"\t"+hdto1.getHotelrating());
		
		
		hdto1.setHotelcontact(888555222);
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.update(hdto1);
		
		
		ts.commit();
		

		
		System.out.println("Update Succssfully");
		
		
		System.out.println("NEW DATA");
		
		
		System.out.println(hdto1.getHotelid()+"\t"+hdto1.getHotelname()+"\t"+hdto1.getHotelcity()+"\t"+hdto1.getHotelemail()+"\t"+hdto1.getHotelcontact()+"\t"+hdto1.getHotelrating());

		
		
		sess.close();
		
		
		sf.close();
		
		
	}
	
	
	public static void InsertChildOnly(int HID) throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		HotelDTO hdto1=(HotelDTO) sess.get(HotelDTO.class, HID);
		
		
		System.out.println("Hotel Detail's");
		
		
		System.out.println(hdto1.getHotelid()+"\t"+hdto1.getHotelname()+"\t"+hdto1.getHotelcity()+"\t"+hdto1.getHotelemail()+"\t"+hdto1.getHotelcontact()+"\t"+hdto1.getHotelrating());
		
		
		
		System.out.println("Add NEW Customer ");								
		
						
											CustomerDTO cdto1=new CustomerDTO();
							
							
											cdto1.setCid(5007);
							
											cdto1.setFname("Anmol");

											cdto1.setLname("Rathore");
							
											cdto1.setEmail("anmol@gmail.com");
							
											cdto1.setAddress("Hyderabad");
							
											cdto1.setMobile(111222888);
							
											cdto1.setRoomno(6);
							
		
	Set s=new HashSet();
	
	s.add(cdto1);
	
	
	hdto1.setHotelChild(s);
	
	
	Transaction ts=sess.beginTransaction();
	
	sess.save(hdto1);
	
	ts.commit();
	
	
	System.out.println("New Record Insert Successfully");
	
	
	sess.close();
	
	sf.close();
	
	
		
	}
	
	
	public static void GETALLCHILD(int HID) throws Exception
	{
		
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			
			Session sess=sf.openSession();
			
			
			HotelDTO hdto1=(HotelDTO) sess.get(HotelDTO.class, HID);
			
			
			Set s=hdto1.getHotelChild(); 	
		
			if(!s.isEmpty())
			{
				
				Query q= sess.createQuery("from CustomerDTO");
				
				List rows=q.list();
				
				
				Iterator itr=rows.iterator();
				
				
				while(itr.hasNext())
				{
					
					CustomerDTO cdto1=(CustomerDTO) itr.next();
					
					
					System.out.println(cdto1.getCid()+"\t"+cdto1.getFname()+"\t"+cdto1.getLname()+"\t"+cdto1.getEmail()+"\t"+cdto1.getAddress()+"\t"+cdto1.getMobile()+"\t"+cdto1.getRoomno()+"\t"+cdto1.getHid());
					
					
					System.out.println();
					
					
				}

			}
			
			
			
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void UpdateChild(int HID, int CID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		HotelDTO hdto1=(HotelDTO) sess.get(HotelDTO.class, HID);
		
		
		Set s=hdto1.getHotelChild(); 	

		if(!s.isEmpty())
		{
			
			Query q= sess.createQuery("from CustomerDTO");
			
			List rows=q.list();
			
			
			Iterator itr=rows.iterator();
			
			
			while(itr.hasNext())
			{
				
				CustomerDTO cdto1=(CustomerDTO) itr.next();
				
				
				if(cdto1.getCid() == CID)
				{
					
					cdto1.setAddress("Nagpur");
					
					Transaction ts=sess.beginTransaction();
					
					sess.update(hdto1);
					
					
					ts.commit();
					
					
					System.out.println("Update Successfully");
					
				}
				
				else 
				{
					
					System.out.println("NO Customer ID Found");
				}
				
				
			}
			
		}	
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void UpdateChild1(int HID, int CID) throws Exception
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		HotelDTO hdto1=(HotelDTO) sess.get(HotelDTO.class, HID);
		
		
		Set s=hdto1.getHotelChild(); 	

		
		
		if(!s.isEmpty())
		{
			
			CustomerDTO cdto1= (CustomerDTO) sess.get(CustomerDTO.class, CID);
			
			
			System.out.println("OLD Detail's");
			
			System.out.println(cdto1.getCid()+"\t"+cdto1.getFname()+"\t"+cdto1.getLname()+"\t"+cdto1.getEmail()+"\t"+cdto1.getAddress()+"\t"+cdto1.getMobile()+"\t"+cdto1.getRoomno()+"\t"+cdto1.getHid());
			
			System.out.println();
			
			
			
			cdto1.setAddress("Chennai");
			
			
			Transaction ts=sess.beginTransaction();
			
			
			sess.update(hdto1);
			
			ts.commit();

			System.out.println("Update Successfully");
			
		}
		
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void DeleteALL(int HID) throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		HotelDTO hdto1=(HotelDTO) sess.get(HotelDTO.class, HID);
		
		
		Transaction ts= sess.beginTransaction();
		
		
		sess.delete(hdto1);
		
		ts.commit();
		
		System.out.println("All Record Deleted");
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertALL();
		
	//	UpdateParent(1001);
		
	//	InsertChildOnly(1001);
		
		GETALLCHILD(1001);
		
		
	//	UpdateChild(1001, 5006);
		
	//	UpdateChild1(1001, 5006);
		
		
	//	DeleteALL(1001);
		
		
	}
	
	
	
	
}
