package co.in.pp;


import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Login1 
{

	public static void Demo(UserDTO dto)
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
	//	Query q=s.createQuery("from UserDTO");
		
		dto=(UserDTO) s.get(UserDTO.class, 1);
		
		
		System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
		System.out.println();
		
		
	}
	
	
	
	public static void main(String[] args)
	{
		
		UserDTO dto=new UserDTO();
		
		
		Demo(dto);
		
		
		
	}
	
	
	
}
