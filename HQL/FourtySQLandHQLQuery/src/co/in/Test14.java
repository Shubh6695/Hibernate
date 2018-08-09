package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;



public class Test14 {


	// Query 13 :- select * from studetails where  PHYSICS > 30 or CHEMISTRY > 30 or MATHS > 30
	
	public static void SQLQUERY() throws Exception
	{
	
		System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();

		Query s1=s.createSQLQuery("select * from studetails where  PHYSICS > 30 or CHEMISTRY > 30 or MATHS > 30");
		
		
		((SQLQuery) s1).addEntity(StudentDTO.class);
		
		
		// Useing List Interface 
		
		List rows=s1.list();
		
		
		// Useing Iterator Interface 
		
		Iterator itr=rows.iterator();
		
		
		StudentDTO dto;
		
		
		while(itr.hasNext())
		{
			
			dto=(StudentDTO)itr.next();
			
			System.out.println(dto.getRollno()+"\t"+dto.getName()+"\t"+dto.getPhysics()+"\t"+dto.getChemistry()+"\t"+dto.getMaths());
			
			System.out.println();
		}
		
		
		
		s.close();


	
	}
	
	
	public static void HQLQUERY() throws Exception
	{
		

		System.out.println("HQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();

		Query h1=s.createQuery("from StudentDTO where physics > 30 or chemistry > 30 or maths > 30");
		
		
		
		List rows=h1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		StudentDTO dto;
		
		
		while(itr.hasNext())
		{
			
			// Type cast itr.next() into StudentDTO
			
			dto=(StudentDTO)itr.next();
			
			System.out.println(dto.getRollno()+"\t"+dto.getName()+"\t"+dto.getPhysics()+"\t"+dto.getChemistry()+"\t"+dto.getMaths());
			
			System.out.println();
		}
		
		
		
		s.close();
	

	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		SQLQUERY();

		HQLQUERY();



	}

}
