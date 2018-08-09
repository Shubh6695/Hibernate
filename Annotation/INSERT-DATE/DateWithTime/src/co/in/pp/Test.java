package co.in.pp;

import java.time.*;
import java.text.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	public static void insertALL() throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
	//	String s="20/05/2010";
		
		String e="18/05/2015 12:10:25";
		
		
		Date start= dateFormat.parse(dateFormat.format(new Date()));										// Insert Current Date and Time
		
		Date end= dateFormat.parse(e);																		// Insert Specific Date 
		
		
		DateWithTimeDTO d=new DateWithTimeDTO();
		
		d.setId(102);
		
		d.setName("Aman");
		
		d.setStartdate(start);
		
		d.setEnddate(end);
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(d);
		
		ts.commit();
		
		System.out.println("Insert Successfully");
		
		sess.close();
		
		sf.close();
		
		
	}
	
	public static void getALL()throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

		Query q=sess.createQuery("from DateDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			DateWithTimeDTO d=(DateWithTimeDTO) itr.next();
			
			System.out.println(d.getId()+"\t"+d.getName()+"\t"+d.getStartdate()+"\t"+d.getEnddate());
			
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void getDateDifference() throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

		Query q=sess.createQuery("from DateDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			DateWithTimeDTO d=(DateWithTimeDTO) itr.next();
			
			SimpleDateFormat sformat=new SimpleDateFormat("dd/mm/yyyy");
			
			Date start=d.getStartdate();
			
			Date end=d.getEnddate();
			
			long timedifference= end.getTime() - start.getTime();
			
			System.out.println("Time Difference is :-- "+timedifference);
			
			long daydifference= timedifference /(1000 * 60 * 60 * 24);
			
			System.out.println("Day Difference is :-- "+daydifference);
			
			System.out.println(d.getId()+"\t"+d.getName()+"\t"+d.getStartdate()+"\t"+d.getEnddate());
			
		}
		
		sess.close();
		
		sf.close();

		
	}
	
	public static void updateEndDate(int Id)throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

		DateWithTimeDTO d=(DateWithTimeDTO) sess.get(DateWithTimeDTO.class, Id);
			
		System.out.println("Old Data");
		
		System.out.println(d.getId()+"\t"+d.getName()+"\t"+d.getStartdate()+"\t"+d.getEnddate());
			
		
		String e="18/05/2018";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date end= dateFormat.parse(e);
		
		d.setEnddate(end);
		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(d);
		
		ts.commit();
		
		System.out.println(" \n Update Successfully \n");
		
		System.out.println("New Data");
		
		System.out.println(d.getId()+"\t"+d.getName()+"\t"+d.getStartdate()+"\t"+d.getEnddate());

		

		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		insertALL();
		
	//	getALL();
		
	//	getDateDifference();
		
	//	updateEndDate(102);
		

		
		
	}
	
	
}
