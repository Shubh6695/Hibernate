package co.in;


import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Restrictions;


public class Restriction8 {

	
	//Query 7:- (Neglate First 5 rows from table);
	
	public static void RestrictionDEMO() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		// Hibernate Session Provides the createCriteria() 
		// It is used to create Criteria object that return instance of the persistent object class
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		//setFirstResults() is used to neglate first 5 from table
		
		
		crit.setFirstResult(5);
		
		
		
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
