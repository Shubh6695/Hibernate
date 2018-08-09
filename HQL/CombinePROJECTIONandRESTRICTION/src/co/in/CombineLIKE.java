package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class CombineLIKE {

	//Query :-SELECT roll_no, s_name FROM studetails WHERE s_name LIKE 'a%';
	
	public static void COMBINE() throws Exception
	{
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		ProjectionList p=Projections.projectionList();
		
		p.add(Projections.property("rollno"));
		
		
		p.add(Projections.property("name"));
		
		
		
		crit.setProjection(p);
		
		
		
		crit.add(Restrictions.like("name", "a%"));
		
		
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
