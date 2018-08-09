package co.in.pp;


import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;


public class CriteriaRestrictionANDProjection {

	
	public static void COMBINE() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(UserDTO.class);
		
		
		ProjectionList p=Projections.projectionList();
		
		p.add(Projections.property("fname"));
		
		p.add(Projections.property("lname"));
		
		crit.setProjection(p);
		
		
		crit.add(Restrictions.gt("age", 20));
		
		
		List rows=crit.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			Object[] columns=(Object[]) itr.next();
			
			
			String fname=(String) columns[0];
			
			String lname=(String) columns[1];
			
			
			System.out.println(fname+"\t"+lname);
			
			System.out.println();
		}
		
		
		s.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
	
		COMBINE();
		
	}

}
