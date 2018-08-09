package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Main2 
{

	public static void Demo() 
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		UserDTO dto=(UserDTO) s.get(UserDTO.class, 1);
		
		
		dto.setFname("Vijay");
		
		Transaction ts=s.beginTransaction();
		
		s.update(dto);
		
		ts.commit();
		
		
		System.out.println("Update Successfully");
		
		s.close();
		
		
		
	}
	
	public static void main(String[] args)throws Exception
	{
		
		Demo();
		
	}
}
