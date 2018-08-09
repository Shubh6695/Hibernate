package co.in;

import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class ProjectionMax {

	public static void ProjectionDEMO() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);

		
		ProjectionList p=Projections.projectionList();
		
		
//		p.add(Projections.max("maths"));
		
//		p.add(Projections.min("maths"));
		
		p.add(Projections.sum("maths"));
		
//		p.add(Projections.avg("maths"));
		
		
		crit.setProjection(p);
		
		
		List rows=crit.list();
		
		
		System.out.println(rows);
		
		s.close();
	}
	
	
	
	public static void main(String[] args)throws Exception
	{
		
		ProjectionDEMO();
	}

}
