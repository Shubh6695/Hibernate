package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;


public class GetSelectedAttribute {

	
	public static void ProjectionDEMO() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
		// For a selected thing we used Projection
		
		ProjectionList p=Projections.projectionList();
		
		p.add(Projections.property("rollno"));
		
		p.add(Projections.property("name"));
		
		
		crit.setProjection(p);
		
		
		List rows=crit.list();
		
		
		
		s.close();
	}
	
	
	public static void main(String[] args) throws Exception
	{
	
		ProjectionDEMO();
		
	}

}
