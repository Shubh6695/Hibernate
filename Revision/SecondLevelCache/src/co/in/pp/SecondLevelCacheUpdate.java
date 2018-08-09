package co.in.pp;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class SecondLevelCacheUpdate 
{

	public static void SecondUpdate() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s1=sf.openSession();
		
		
		UserDTO dto1=(UserDTO) s1.load(UserDTO.class, 1);
		
		
		System.out.println(dto1.getId()+"\t"+dto1.getFname()+"\t"+dto1.getLname()+"\t"+dto1.getEmail()+"\t"+dto1.getAddress()+"\t"+dto1.getMobile()+"\t"+dto1.getAge());
		
		System.out.println();
		
		
		s1.close();
		
		
		
		Thread.sleep(5000);
		
		
		Session s3=sf.openSession();
		
		
		UserDTO dto3=(UserDTO) s3.get(UserDTO.class, 1);
		
		
		dto3.setFname("Shubham");
		
		System.out.println(dto3.getId()+"\t"+dto3.getFname()+"\t"+dto3.getLname()+"\t"+dto3.getEmail()+"\t"+dto3.getAddress()+"\t"+dto3.getMobile()+"\t"+dto3.getAge());
		
		System.out.println();
		
		
		Transaction ts=s3.beginTransaction();
		
		s3.update(dto3);
		
		ts.commit();
		
		
		s3.close();
		
		
		Thread.sleep(5000);
		
		
		
		
		
		Session s2=sf.openSession();
		
		UserDTO dto2=(UserDTO) s2.load(UserDTO.class, 1);
		
		
		System.out.println(dto2.getId()+"\t"+dto2.getFname()+"\t"+dto2.getLname()+"\t"+dto2.getEmail()+"\t"+dto2.getAddress()+"\t"+dto2.getMobile()+"\t"+dto2.getAge());
		
		System.out.println();
		
		s2.close();
	}
	

	public static void main(String[] args)throws Exception
	{
		
		SecondUpdate();
		
	}
	
	
}
