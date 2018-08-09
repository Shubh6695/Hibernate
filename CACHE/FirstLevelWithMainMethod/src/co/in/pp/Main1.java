package co.in.pp;


import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Main1 
{

	public static void Main1Demo() throws Exception  
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		
		UserDTO dto=(UserDTO) s.load(UserDTO.class, 1);
		
		
		System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
		System.out.println();
		
		
		Thread.sleep(20000);
		
		
		UserDTO dto1=(UserDTO) s.load(UserDTO.class, 1);
		
		
		System.out.println(dto1.getId()+"\t"+dto1.getFname()+"\t"+dto1.getLname()+"\t"+dto1.getEmail()+"\t"+dto1.getAddress()+"\t"+dto1.getMobile()+"\t"+dto1.getAge());
		
		
		System.out.println();
		
		
		s.close();
		
		sf.close();
		
		
	}
	
	public static void main(String[] args) throws Exception
	{
		
		Main1Demo();
		
	}
	
	
}
