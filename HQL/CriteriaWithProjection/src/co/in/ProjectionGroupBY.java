package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;




public class ProjectionGroupBY
{
	
	// Query :- SELECT maths, COUNT(maths) FROM studetails GROUP BY maths;

	public static void GROUPBY() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);

		
		ProjectionList p=Projections.projectionList();

		
		p.add(Projections.property("maths"));
		
		p.add(Projections.count("maths"));
		
		p.add(Projections.groupProperty("maths"));
		
		crit.setProjection(p);
		
		
		List rows=crit.list();
		
		
		Iterator itr=rows.iterator();
		
		Object[] columns;
		
		
		while(itr.hasNext())
		{

			columns=(Object[])itr.next();

			Integer maths=(Integer) columns[0];
			
			
			Integer count=(Integer) columns[1];
			
			
			System.out.println(maths +"\t"+count);
			
		}
		
		
		
		
		s.close();
		
	}
	
	public static void main(String[] qargs)throws Exception
	{
		
		GROUPBY();
		
	}
	
	
	
}
