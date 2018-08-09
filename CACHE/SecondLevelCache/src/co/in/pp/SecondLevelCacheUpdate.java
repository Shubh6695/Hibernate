

package co.in.pp;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class SecondLevelCacheUpdate 
{
	
	public static void SecondCacheUpdate() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s1=sf.openSession();
		
		
		UserDTO dto1=(UserDTO) s1.load(UserDTO.class, 1);
		
		
		System.out.println(dto1.getId()+"\t"+dto1.getFname()+"\t"+dto1.getLname()+"\t"+dto1.getEmail()+"\t"+dto1.getAddress()+"\t"+dto1.getMobile()+"\t"+dto1.getAge());
		
		System.out.println();
		
		s1.close();
		
		
		
		Thread.sleep(10000);
		
		
		
		Session s2=sf.openSession();
		
		
		UserDTO dto2=(UserDTO) s2.load(UserDTO.class, 1);
		
		
		
		System.out.println(dto2.getId()+"\t"+dto2.getFname()+"\t"+dto2.getLname()+"\t"+dto2.getEmail()+"\t"+dto2.getAddress()+"\t"+dto2.getMobile()+"\t"+dto2.getAge());
		
		System.out.println();
		
		s2.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		SecondCacheUpdate();
		
		
	}
	

}
