package co.in;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;


public class CombineNOTNULL
{

// Query :- SELECT roll_no, s_name FROM  studetails WHERE s_name IS NOT NULL;
// Query SELECT roll_no, s_name FROM  studetails WHERE s_name IS NOT NULL and roll_no BETWEEN 1002 AND 1008;	
	
	public static void COMBINE() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Criteria crit=s.createCriteria(StudentDTO.class);
		
		
				
		
		
		
		ProjectionList p=Projections.projectionList();
		
		
		p.add(Projections.property("rollno"));
		
		p.add(Projections.property("name"));
				
		
		crit.setProjection(p);

		
		crit.add(Restrictions.isNotNull("name"));
		
		crit.add(Restrictions.between("rollno", 1002, 1008));
		
		
		List rows=crit.list();
		
		
		Iterator itr=rows.iterator();
		
		Object[] columns;
		
		
		while(itr.hasNext())
		{
			
			columns=(Object[]) itr.next();
			
			Integer rollno =(Integer) columns[0];
			
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
