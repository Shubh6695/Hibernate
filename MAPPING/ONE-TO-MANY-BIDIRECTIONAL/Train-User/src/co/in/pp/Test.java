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
		
		
		
		TrainDTO tdto=new TrainDTO();
		
		tdto.setTid(101);
		
		tdto.setTnum(55220);
		
		tdto.setTname("Tri-Shatabdi");
		
		tdto.setTtype("Express");
		
		tdto.setTsourcestation("Indore");
		
		tdto.setTdestinationstation("Nagpur");
		
		
		
		
																			UserDTO udto1=new UserDTO();
		
		
																			udto1.setUid(201);

																			udto1.setName("Shubham");
		
																			udto1.setEmail("shubham@gmail.com");
		
																			udto1.setAddress("Indore");

																			udto1.setMobile(999666333);
		
																			udto1.setTrainParent(tdto);
																			
		
																			UserDTO udto2=new UserDTO();
		
		
																			udto2.setUid(202);

																			udto2.setName("Ram");
		
																			udto2.setEmail("ram@gmail.com");
		
																			udto2.setAddress("Ujjain");

																			udto2.setMobile(999666444);
		
																			udto2.setTrainParent(tdto);
																			

																			UserDTO udto3=new UserDTO();
		
		
																			udto3.setUid(203);

																			udto3.setName("Suraj");
		
																			udto3.setEmail("suraj@gmail.com");
		
																			udto3.setAddress("Bhopal");

																			udto3.setMobile(999666555);
		
																			udto3.setTrainParent(tdto);	
		
				Set s=new HashSet();
				
				s.add(udto1);
					
				s.add(udto2);
				
				s.add(udto3);
				
				
				tdto.setUserChild(s);
				
				
				sess.save(tdto);
				
				Transaction ts=sess.beginTransaction();
						
				ts.commit();
				
				System.out.println("Insert Successfully");
				
				sess.close();
				
				sf.close();
		
	}
	
	
	
	
	public static void Insert_MANY_TO_ONE() throws Exception
	{
		
		SessionFactory sf=new  Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		
		TrainDTO tdto=new TrainDTO();
		
		tdto.setTid(102);
		
		tdto.setTnum(55660);
		
		tdto.setTname("Malwa");
		
		tdto.setTtype("Express");
		
		tdto.setTsourcestation("Indore");
		
		tdto.setTdestinationstation("Jammu");
		
		
		
		
																			UserDTO udto1=new UserDTO();
		
		
																			udto1.setUid(204);

																			udto1.setName("Ankit");
		
																			udto1.setEmail("ankit@gmail.com");
		
																			udto1.setAddress("Delhi");

																			udto1.setMobile(999888555);
		
																			udto1.setTrainParent(tdto);
																			
																			
		
																			UserDTO udto2=new UserDTO();
		
		
																			udto2.setUid(205);

																			udto2.setName("Aman");
		
																			udto2.setEmail("aman@gmail.com");
		
																			udto2.setAddress("Bhopal");

																			udto2.setMobile(999777444);
		
																			udto2.setTrainParent(tdto);
																			

																			UserDTO udto3=new UserDTO();
		
		
																			udto3.setUid(206);

																			udto3.setName("Amit");
		
																			udto3.setEmail("amit@gmail.com");
		
																			udto3.setAddress("Indore");

																			udto3.setMobile(999555222);
		
																			udto3.setTrainParent(tdto);	
		

		
				sess.save(udto1);
				
				sess.save(udto2);
				
				sess.save(udto3);
				
				Transaction ts=sess.beginTransaction();
				
				ts.commit();
				
				
				System.out.println("Insert Successfully");
														
				
				sess.close();
				
				sf.close();
		
		
		
	}
	
	
	public static void Update_Child_ONE_TO_MANY(int UID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		
		Query q1=sess.createQuery("from TrainDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			TrainDTO tdto=(TrainDTO) itr.next();
			
			
			Set s=tdto.getUserChild();
			
			
			Iterator itr1=s.iterator();
			
			
			while(itr1.hasNext())
			{
				
				
				UserDTO udto=(UserDTO) itr1.next();
				
				
				if(udto.getUid() == UID)
				{
					
					
					System.out.println("OLD Details");
					
					
					System.out.println(udto.getUid()+"\t"+udto.getName()+"\t"+udto.getEmail()+"\t"+udto.getAddress()+"\t"+udto.getMobile());
					
					
					udto.setAddress("Dewas");
					
					
					
					
					sess.update(tdto);
					
					
					Transaction ts=sess.beginTransaction();
					
					
					ts.commit();
					
					
					System.out.println("NEW Details");
					
					
					System.out.println(udto.getUid()+"\t"+udto.getName()+"\t"+udto.getEmail()+"\t"+udto.getAddress()+"\t"+udto.getMobile());
					
					
					
					
				}
					
					
				
			}
			
			
			
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		
	//	Insert_ONE_TO_MANY();
		
		
	//	Insert_MANY_TO_ONE();
		
		
		Update_Child_ONE_TO_MANY(206);
		
		
		
	}
	
	
}
