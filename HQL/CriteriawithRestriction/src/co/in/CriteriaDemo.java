package co.in;

import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;



public class CriteriaDemo
{

	public static void CRITERIAQUERY() throws Exception 
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		
		
		// Hibernate Session Provides the createCriteria() 
		// It is used to create Criteria object that return instance of the persistent object class
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		List rows =crit.list();
		
		
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
		
		
		CRITERIAQUERY();
		
	}
	
	
}
