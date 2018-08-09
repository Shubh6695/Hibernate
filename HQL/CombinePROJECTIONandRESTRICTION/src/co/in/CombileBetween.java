package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class CombileBetween 
{

	// Query :- select roll_no, s_name from studetails where Roll_no between 1001 and 1005; 
	
	public static void COMBINE()throws Exception
	{

		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);
	
		
		
		ProjectionList p=Projections.projectionList(); 				// Projection Part start
		
		
		p.add(Projections.property("rollno"));
		
		
		p.add(Projections.property("name"));
		
		
		crit.setProjection(p);										// Projection end
		
		
		crit.add(Restrictions.between("rollno", 1001, 1005));		// Restriction Part
		
		
		List rows=crit.list();
		
		
		Iterator itr=rows.iterator();
		
		
		Object[] columns;
		
		
		while(itr.hasNext())
		{
			
			columns=(Object[]) itr.next();
			
			Integer rollno=(Integer) columns[0];
			
			String name=(String) columns[1];
			
			
			System.out.println(rollno+"\t"+name);
			
			System.out.println();
			
		}
		
		s.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		COMBINE();
	}

}
