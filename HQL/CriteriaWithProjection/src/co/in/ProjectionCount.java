package co.in;

import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class ProjectionCount {

	
	// Query :-select count(rollno) from studetails; 
	// Query :- select count(*) from studetails (1 method is used rowcount())
	
	
	
	public static void ProjectionDEMO() throws Exception 
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);

		
		ProjectionList p=Projections.projectionList();
		
	
		p.add(Projections.count("name"));
		
		
		// rowcount is used to show to total record count(*)
		
	//	p.add(Projections.rowCount());
		
		
		crit.setProjection(p);
		
		List rows=crit.list();
		
		
		System.out.println("Total element is :-- "+rows);
		
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
	
		ProjectionDEMO();
		
	}

	
}
