package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	public static void insertALL()
	{
		
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		
		StudentDTO sdto=new StudentDTO();
		
	//	sdto.setSid(102);
				
		sdto.setFname("Shubham");
				
		sdto.setLname("Tale");
		
		sdto.setMobile(999666333);
		
		sdto.setEmail("shubham@gmail.com");
		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(sdto);
		
	//	sess.persist(sdto);
		
		
		ts.commit();
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
		
	}
	
	public static void updateONEColumn(Integer SID)
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		StudentDTO sdto=(StudentDTO) sess.get(StudentDTO.class, SID);
		
		
		System.out.println("OLD Data");
		
		System.out.println(sdto.getSid()+"\t"+sdto.getFname()+"\t"+sdto.getLname()+"\t"+sdto.getEmail()+"\t"+sdto.getMobile());
		
		
		sdto.setMobile(201030405);
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.update(sdto);
		
		ts.commit();
		
		System.out.println("Update Successfully \n");
		
		System.out.println("NEW Data");
		
		System.out.println(sdto.getSid()+"\t"+sdto.getFname()+"\t"+sdto.getLname()+"\t"+sdto.getEmail()+"\t"+sdto.getMobile());

		
		
		sess.close();
		
		sf.close();
		
		
		
	}
	
	
	public static void getALL() 
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

		
		Query q=sess.createQuery("from StudentDTO");
		
		
		List s=q.list();
		
		Iterator itr=s.iterator();
		
		while(itr.hasNext())
		{
			
			StudentDTO sdto=(StudentDTO) itr.next();
			
			System.out.println(sdto.getSid()+"\t"+sdto.getFname()+"\t"+sdto.getLname()+"\t"+sdto.getEmail()+"\t"+sdto.getMobile());
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void deleteONERow(Integer SID)
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		StudentDTO sdto=(StudentDTO) sess.get(StudentDTO.class, SID);
		
		
		System.out.println("Record before Delete");
		
		System.out.println(sdto.getSid()+"\t"+sdto.getFname()+"\t"+sdto.getLname()+"\t"+sdto.getEmail()+"\t"+sdto.getMobile());
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.delete(sdto);
		
		ts.commit();
		
		System.out.println("Delete Successfully \n");

		
		sess.close();
		
		sf.close();
		
		
		
	}

	
	
	
	
	public static void main(String[] args)
	{
		
		insertALL();
		
		
	//	updateONEColumn(101);
		
		
	//	getALL();
		
		
	//	deleteONERow(101);
	}
	
	
}
