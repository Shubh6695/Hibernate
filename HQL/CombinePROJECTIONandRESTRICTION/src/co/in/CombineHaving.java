package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CombineHaving {
	
	
	public static void COMBINE() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		ProjectionList p=Projections.projectionList();
		
		
		p.add(Projections.property("maths"));
		
		
		p.add(Projections.count("maths"));
		
		
		p.add(Projections.groupProperty("maths"));
		
	
		crit.setProjection(p);
		
		
		crit.add(Restrictions.g);
		
		
		
		List rows=crit.list();
		
		Iterator itr=rows.iterator();
		
		Object[] columns;
		
		
		while(itr.hasNext())
		{
			columns=(Object[]) itr.next();
			
			Integer maths=(Integer) columns[0];
			
			Integer count=(Integer) columns[1];
			
			
			System.out.println(maths+"\t"+count);
			
			System.out.println();
			
		}
		
		
		s.close();
		
		
		
	}
	

	public static void main(String[] args) throws Exception
	{

		COMBINE();
		
	}

}
