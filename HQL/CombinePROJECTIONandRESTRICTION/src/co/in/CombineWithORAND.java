package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;


public class CombineWithORAND 
{
	
	// Query :- SELECT * FROM studetails WHERE (physics > 50 OR chemistry >50) AND maths >50;
	

	public static void CombineORAND() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Criteria crit= s.createCriteria(StudentDTO.class);
		
		
		
		ProjectionList p=Projections.projectionList();
		
		
		p.add(Projections.property("rollno"));
		
		p.add(Projections.property("name"));
		
		
		crit.setProjection(p);
		
		
		
		Criterion c1=Restrictions.gt("physics", 50);
		
		
		Criterion c2=Restrictions.gt("chemistry", 50);
		
		
		Criterion c3=Restrictions.gt("maths", 50);
		
		
		Criterion c4=Restrictions.and(Restrictions.or(c1, c2), c3);
		
		
		crit.add(c4);
		
		
		
		List rows=crit.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			Object[] columns=(Object[]) itr.next();
			
			Integer rollno=(Integer) columns[0];
			
			
			String name=(String) columns[1];
			
			
			System.out.println(rollno+"\t"+name);
			
			System.out.println();
			
			
		}
		
		
		s.close();
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		CombineORAND();
		
	}
	

}
