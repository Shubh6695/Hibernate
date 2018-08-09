package co.in;


import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


// Query 4 :- SELECT * FROM studetails WHERE S_NAME LIKE 'a%' ORDER BY ROLL_NO;


public class Test4 

{
	
	public static void SQLQUERY() throws Exception
	{
		
		System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		//SQL Query
		
		Query q=s.createSQLQuery("select * from studetails where S_NAME like 'a%' order by ROLL_NO");
		
	
		((SQLQuery) q).addEntity(StudentDTO.class);
		
		
		
		
		List rows=q.list();
		
		
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
		
		
		// HQL Query
		
		
		Query h=s.createQuery("from StudentDTO where name like 'a%' order by rollno");
	
		
		// Useing List Interface 
		
		List rows=h.list();
		
		
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
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		
		SQLQUERY();
		
		HQLQUERY();
		
		
		
	}
	
	

}
