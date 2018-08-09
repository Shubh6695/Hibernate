package co.in.pp;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class FirstLevelCacheTest {

	
	public static void FirstCache() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s1=sf.openSession(); 																// Currently cache is empty 
		
																							
		UserDTO dto=(UserDTO) s1.load(UserDTO.class, 1);											// 1 Cache is Loaded in Cache-memory 
		
		
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
		
		
			
			
			
		UserDTO dto1=(UserDTO) s1.load(UserDTO.class, 2);											// 2 Cache is Loaded in Cache-memory	
	
		
		System.out.println(dto1.getId()+"\t"+dto1.getFname()+"\t"+dto1.getLname()+"\t"+dto1.getEmail()+"\t"+dto1.getAddress()+"\t"+dto1.getMobile()+"\t"+dto1.getAge());
		
		System.out.println();


		
		UserDTO dto2=(UserDTO) s1.load(UserDTO.class, 1);											// Getting record from cache 1
	
		
		System.out.println(dto2.getId()+"\t"+dto2.getFname()+"\t"+dto2.getLname()+"\t"+dto2.getEmail()+"\t"+dto2.getAddress()+"\t"+dto2.getMobile()+"\t"+dto2.getAge());
		
		System.out.println();

		
		
		
		s1.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		FirstCache();
	}
	
	
}
