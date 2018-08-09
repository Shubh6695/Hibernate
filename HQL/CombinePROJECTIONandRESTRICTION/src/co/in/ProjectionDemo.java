package co.in;

import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class ProjectionDemo {

	// Query :- select s_name form studetails; 
	
	
	public static void ProjectionDEMO() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);

		
		ProjectionList p=Projections.projectionList();
		

		p.add(Projections.property("name"));
		
				
		crit.setProjection(p);
		
		
		List rows=crit.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			String name=(String) itr.next();
			
			
			System.out.println(name);
			
			System.out.println();
			
		}
		
		
		
		
		s.close();
	}
	
	
	
	public static void main(String[] args)throws Exception
	{
		
		ProjectionDEMO();
	}

}
