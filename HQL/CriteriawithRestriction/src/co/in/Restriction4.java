package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Restrictions;



public class Restriction4 
{

	// Query 4:- select * from studetails where maths > 30;
	// Query ?:- SELECT * FROM studetails WHERE MATHS >30 AND S_NAME LIKE 'a%' ;
	
	
	public static void RestrictionDEMO() throws Exception 
	{
	
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		// Hibernate Session Provides the createCriteria() 
		// It is used to create Criteria object that return instance of the persistent object class
	
	
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		//add() is used to add restrictions for a criteria query

		
	//	crit.add(Restrictions.gt("maths", 30));
	
	//	crit.add(Restrictions.ge("maths",30));
		
	//	crit.add(Restrictions.lt("maths",60));
		
	//	crit.add(Restrictions.le("maths",60));
		
	//	crit.add(Restrictions.like("name", "a%"));
		
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
