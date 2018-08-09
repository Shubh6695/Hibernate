package co.in;


import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Restrictions;

public class Restriction6 {
	
	// Query 6 :- SELECT * FROM studetails WHERE s_name LIKE 'a%' OR ROLL_NO=1005;
	// Query ?:- SELECT * FROM studetails WHERE s_name LIKE 'a%' AND ROLL_NO=1002;
	
	public static void RestrictionDEMO() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		// Hibernate Session Provides the createCriteria() 
		// It is used to create Criteria object that return instance of the persistent object class
	
	
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		//add() is used to add restrictions for a criteria query

		
		crit.add(Restrictions.or(Restrictions.like("name", "a%"), Restrictions.eq("rollno", 1005)));
		
		
		List rows=crit.list();
		
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
