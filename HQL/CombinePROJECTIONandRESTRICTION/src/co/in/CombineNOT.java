package co.in;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;

public class CombineNOT {

	
	public static void COMBINE() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
				
		
		
		
		ProjectionList p=Projections.projectionList();
		
		
		p.add(Projections.property("rollno"));
		
		p.add(Projections.property("name"));
				
		
		crit.setProjection(p);

		
		Criterion c1 =Restrictions.not(Restrictions.between("rollno", 1001, 1005)); 
		
		
		crit.add(c1);
		
		
		List rows=crit.list();
		
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			Object columns[]=(Object[]) itr.next();
			
			Integer rollno=(Integer) columns[0];
			
			String name=(String) columns[1];
			
			System.out.println(rollno+"\t"+name);
			
		}
		
		s.close();
		
		
	}
	
	public static void main(String[] args)throws Exception 
	{
	

	COMBINE();	
		
	}

}
