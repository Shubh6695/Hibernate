package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;




public class Test {

	
	public static void SQLQUERY() throws Exception
	{
		
		
System.out.println("SQL Part is Executing");
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		
		Query s1=s.createSQLQuery("select * from studetails");
		
	
		((SQLQuery) s1).addEntity(StudentDTO.class);
		
		
		
		
		List li=s1.list();
		
		
		Iterator itr=li.iterator();
		
		
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
		
		
		
		Query h1=s.createQuery("from StudentDTO");
		
		
		
		List li=h1.list();
		
		
		Iterator itr=li.iterator();
		
		
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
