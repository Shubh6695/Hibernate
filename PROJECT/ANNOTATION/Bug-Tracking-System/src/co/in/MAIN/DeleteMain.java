package co.in.MAIN;

import co.in.DTO.*;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class DeleteMain 
{

	
	public static void deleteCustomer() throws Exception
	{
		
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		Transaction ts=sess.beginTransaction();
		
		
	//	CustomerDTO cust=(CustomerDTO) sess.get(CustomerDTO.class, 1);
		
	//	sess.delete(cust);
		
		
/*		ProjectDTO project=(ProjectDTO) sess.get(ProjectDTO.class, 1);
		
		sess.delete(project);
*/		
/*
		BugDTO bug=(BugDTO) sess.get(BugDTO.class, 1);
		
		sess.delete(bug);
*/		
		ts.commit();
		
		System.out.println("Delete Succssfully ");
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		deleteCustomer();
		
	}
	
	
}
