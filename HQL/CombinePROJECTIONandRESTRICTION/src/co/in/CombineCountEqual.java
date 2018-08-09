package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;

public class CombineCountEqual
{

	// Query :- SELECT COUNT(maths) FROM studetails WHERE maths=50;
	
	public static void COMBINE() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		ProjectionList p=Projections.projectionList();
		
		p.add(Projections.rowCount());								// Projection Part
		
				
		crit.setProjection(p);
		
		
		crit.add(Restrictions.eq("maths", 50));						// Restriction Part
		
		
		List rows=crit.list();
	
		
		Integer count=(Integer) rows.get(0);
		
		
		System.out.println(count);
		
		
		
		s.close();
		
		
	}
	public static void main(String[] args)throws Exception
	{
		
		COMBINE();
		
	}
	
}
