package co.in;


import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Restrictions;


public class Restriction7 {

	
	//Query 7:- SELECT * FROM studetails LIMIT 5;
	
	public static void RestrictionDEMO() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		// Hibernate Session Provides the createCriteria() 
		// It is used to create Criteria object that return instance of the persistent object class
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		//setMaxResults() is used to show Top 5 record of a table
		
		
		crit.setMaxResults(5);
	
		
		
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
	
			RestrictionDEMO();
	}

}
