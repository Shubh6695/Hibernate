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
		
		
		
		TrainDTO tdto1=new TrainDTO();
		
		tdto1.setTid(101);
		
		tdto1.setTnum(55220);
		
		tdto1.setTname("Tri-Shatabdi");
		
		tdto1.setTtype("Express");
		
		tdto1.setTsourcestation("Indore");
		
		tdto1.setTdestinationstation("Nagpur");
		
		
		
												UserDTO udto1=new UserDTO();
												
												
												udto1.setUid(201);
		
												udto1.setName("Shubham");
												
												udto1.setEmail("shubham@gmail.com");
												
												udto1.setAddress("Indore");
		
												udto1.setMobile(999666333);
												
												
												
												UserDTO udto2=new UserDTO();
												
												
												udto2.setUid(202);
		
												udto2.setName("Ram");
												
												udto2.setEmail("ram@gmail.com");
												
												udto2.setAddress("Ujjain");
		
												udto2.setMobile(999666444);
												

												UserDTO udto3=new UserDTO();
												
												
												udto3.setUid(203);
		
												udto3.setName("Suraj");
												
												udto3.setEmail("suraj@gmail.com");
												
												udto3.setAddress("Bhopal");
		
												udto3.setMobile(999666555);
												
												
		Set s=new HashSet();
	
		s.add(udto1);
	
		s.add(udto2);
	
		s.add(udto3);
	
												
	
		tdto1.setTrainChild(s);
												
							
		Transaction ts= sess.beginTransaction();
		
		
		sess.save(tdto1);
	
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
	
		sess.close();
		
		sf.close();
		
		
		
	}
	
	public static void main(String[] args) throws Exception
	{
		
		InsertALL();
		
		
	}
	
	
	
}
