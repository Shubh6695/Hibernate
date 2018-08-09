package co.in.pp;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class SecondTest {

	
	public static void SecondCache() throws Exception
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s1=sf.openSession();
		
			UserDTO dto1=(UserDTO) s1.load(UserDTO.class, 1);
		
			System.out.println(dto1.getId()+"\t"+dto1.getFname()+"\t"+dto1.getLname()+"\t"+dto1.getEmail()+"\t"+dto1.getAddress()+"\t"+dto1.getMobile()+"\t"+dto1.getAge());
		
			System.out.println();
		
		s1.close();
		
		
		Session s2=sf.openSession();
		
			UserDTO dto2=(UserDTO) s2.load(UserDTO.class, 2);	
		
			System.out.println(dto2.getId()+"\t"+dto2.getFname()+"\t"+dto2.getLname()+"\t"+dto2.getEmail()+"\t"+dto2.getAddress()+"\t"+dto2.getMobile()+"\t"+dto2.getAge());
			
			System.out.println();
		
		s2.close();	
			

		
		Session s3=sf.openSession();
		
		UserDTO dto3=(UserDTO) s3.load(UserDTO.class, 3);	
	
		System.out.println(dto3.getId()+"\t"+dto3.getFname()+"\t"+dto3.getLname()+"\t"+dto3.getEmail()+"\t"+dto3.getAddress()+"\t"+dto3.getMobile()+"\t"+dto3.getAge());
		
		System.out.println();
	
	s3.close();	
	

	Session s4=sf.openSession();
	
	UserDTO dto4=(UserDTO) s4.load(UserDTO.class, 1);	

	System.out.println(dto4.getId()+"\t"+dto4.getFname()+"\t"+dto4.getLname()+"\t"+dto4.getEmail()+"\t"+dto4.getAddress()+"\t"+dto4.getMobile()+"\t"+dto4.getAge());
	
	System.out.println();

s4.close();	

	
	
		
	}
	
	public static void main(String[] args) throws Exception
	{
		SecondCache();

	}

}
