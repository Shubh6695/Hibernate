package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


// Query :- SELECT Roll_NO, S_NAME , MATHS FROM studetails WHERE Maths > 30;

public class Test

{
	
	public static void COMBINE() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);

			
		ProjectionList p=Projections.projectionList();

		p.add(Projections.property("rollno"));
		
		p.add(Projections.property("name"));
		
		p.add(Projections.property("maths"));
		
		crit.setProjection(p);
		
		
		
		crit.add(Restrictions.gt("maths", 30));
		
		
		List rows =crit.list();
		
		
		Iterator itr=rows.iterator();
		
		Object[] columns;
		
		while(itr.hasNext())
		{
			
			columns=(Object[])itr.next();
			
			Integer rollno=(Integer) columns[0];
			
			String name=(String) columns[1];
			
			Integer maths=(Integer) columns[2];
			
			
			System.out.println(rollno+"\t"+name+"\t"+maths);
			
			
			System.out.println();
			
		}
		
		
		s.close();
		
	
		
	}
	
	
	

	public static void main(String[] args)throws Exception
	{
		
		
		COMBINE();
		
	}
	
}
