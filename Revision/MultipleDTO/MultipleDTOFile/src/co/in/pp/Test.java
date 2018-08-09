package co.in.pp;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test {

	
	public static void MultipleDTOFileTest() throws Exception
	{
	
		
		StudentDTO stu=new StudentDTO();
		
		ResultDTO res=new ResultDTO();
		
		
				stu.setFname("Ankit");
		
				stu.setLname("Sharma");
		
				stu.setPhysics(30);
		
				stu.setChemistry(20);
		
				stu.setMaths(10);
		
		
		
		int Total=stu.getPhysics()+ stu.getChemistry()+ stu.getMaths();		
				
		float avg=(Total)/3;		
		
		String status=null;
		
		if(avg < 35)
		{
			status="fail";
		}
		
		
		else if(avg > 35)
		{
			status="pass";
		}
		
		
		System.out.println("Total is :--- "+Total+ " and Average is :--"+avg );
		
				
				res.setRollno(stu.getRollno());
				
				res.setFname(stu.getFname());
		
				res.setLname(stu.getLname());
				
				res.setTotal(Total);
				
				res.setAverage(avg);
				
				res.setStatus(status);
				
				
				
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
		
		
		s.save(stu);
		
		s.save(res);
		
		ts.commit();
		
		s.close();
				
				
				
		
	}
	
	
	public static void main(String[] args) throws Exception 
	
	{
		
		MultipleDTOFileTest();

	}

}
