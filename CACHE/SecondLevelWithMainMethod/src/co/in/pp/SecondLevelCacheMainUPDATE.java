package co.in.pp;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class SecondLevelCacheMainUPDATE 
{
	
	public static void Cache1() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s1=sf.openSession();
		
		
		
		
		UserDTO dto1=(UserDTO) s1.load(UserDTO.class, 1); 
		
		
		
		System.out.println("UserDTO object 1 (dto1) ");
		
		System.out.println(dto1.getId()+"\t"+dto1.getFname()+"\t"+dto1.getLname()+"\t"+dto1.getEmail()+"\t"+dto1.getAddress()+"\t"+dto1.getMobile()+"\t"+dto1.getAge());
		
		System.out.println();
		
		
		s1.close();
		
		
	//	Thread.sleep(10000);
		
		
		
		Session s2=sf.openSession();
		

		System.out.println("Starting milisecond Time is :---"+System.currentTimeMillis());
		long start=System.currentTimeMillis();
		
		
		UserDTO dto2=(UserDTO) s2.get(UserDTO.class, 1);
		
		System.out.println("UserDTO object 2(dto2)");
		
		dto2.setFname("Shubham");
		
		
		System.out.println();
		
		
		Transaction ts=s2.beginTransaction();
		
		s2.update(dto2);
		
		ts.commit();
		
		System.out.println("After milisecond Time is :---"+System.currentTimeMillis());
		long end=System.currentTimeMillis();
		
		
		long diff=end-start;
		
		System.out.println("Difference is:---"+diff);
	
		
		
		System.out.println("Update Successfully");
		
		System.out.println();
		
		s2.close();
		
		
		
		
		
		
		Session s3=sf.openSession();
		
		
		UserDTO dto3=(UserDTO) s3.load(UserDTO.class, 1); 
		
		
		System.out.println("UserDTO object 3 (dto3) ");
		
		System.out.println(dto3.getId()+"\t"+dto3.getFname()+"\t"+dto3.getLname()+"\t"+dto3.getEmail()+"\t"+dto3.getAddress()+"\t"+dto3.getMobile()+"\t"+dto3.getAge());
		
		System.out.println();

		
		
		s3.close();
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		
		
		Cache1();
	
		
	}
	

}
