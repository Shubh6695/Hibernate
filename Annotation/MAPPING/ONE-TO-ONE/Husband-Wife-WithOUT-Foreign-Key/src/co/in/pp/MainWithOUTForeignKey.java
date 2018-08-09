package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class MainWithOUTForeignKey 
{

	public static void insertALL()
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		HusbandDTO hdto1=new HusbandDTO();
		
		hdto1.setHid(1001);
		
		hdto1.setHname("Vijay");
		
		hdto1.setHegnder("Male");
		
		
												WifeDTO wdto1=new WifeDTO();
												
												wdto1.setWid(1001);
												
												wdto1.setWname("Sadhana");
		
												wdto1.setWgender("Female");
		
												wdto1.setHusbandParent(hdto1);
		
												
												
		HusbandDTO hdto2=new HusbandDTO();
												
		hdto2.setHid(1005);
												
		hdto2.setHname("Santosh");
												
		hdto2.setHegnder("Male");
												
												
												WifeDTO wdto2=new WifeDTO();
															
												wdto2.setWid(1005);
												
												wdto2.setWname("Aruna");
												
												wdto2.setWgender("Female");
												
												wdto2.setHusbandParent(hdto2);
												
												
												
		Transaction ts=sess.beginTransaction();
		
		sess.save(wdto1);
		
		sess.save(wdto2);
		
		
		
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void getALL()
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		Session sess=sf.openSession();
		

		Query q=sess.createQuery("from WifeDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			WifeDTO wdto=(WifeDTO) itr.next();
			
			
			System.out.println(wdto.getWid()+"\t"+wdto.getWname()+"\t"+wdto.getWgender());
			
		}
		
		
		sess.close();
		
		sf.close();
		
	
	}	
	
	
	public static void deleteWIFE(Integer WID)
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		WifeDTO wdto=(WifeDTO) sess.get(WifeDTO.class, WID);
		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.delete(wdto);
		
		ts.commit();
		
		
		System.out.println("Delete Successfully");
		
		
		sess.close();
		
		sf.close();

	}	
	
	
	
	public static void getWifeOnly()
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		Session sess=sf.openSession();
		

		Query q=sess.createQuery("from WifeDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			WifeDTO wdto=(WifeDTO) itr.next();
			
			
			System.out.println(wdto.getWid()+"\t"+wdto.getWname()+"\t"+wdto.getWgender());
			
		}
		
		
		sess.close();
		
		sf.close();
		
	
	}	
	

	public static void getHusbandOnly()
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		Session sess=sf.openSession();
		

		Query q=sess.createQuery("from HusbandDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			HusbandDTO hdto=(HusbandDTO) itr.next();
	
			WifeDTO wdto=hdto.getWifeChild();
			
			
			System.out.println(hdto.getHid()+"\t"+hdto.getHname()+"\t"+hdto.getHegnder());
			
			System.out.println(wdto.getWid()+"\t"+wdto.getWname()+"\t"+wdto.getWgender());
			
			
		}

		sess.close();
		
		sf.close();
		
	}


	
	public static void deleteHUSBAND(Integer HID)
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		HusbandDTO hdto=(HusbandDTO) sess.get(HusbandDTO.class, HID);
		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.delete(hdto);
		
		ts.commit();
		
		
		System.out.println("Delete Successfully");
		
		
		sess.close();
		
		sf.close();

	}	

	
	
	public static void main(String[] args)
	{
		
	//	insertALL();
		
	//	getALL();
		
	//	getWifeOnly();
		
		getHusbandOnly();
		
	//	deleteWIFE(1001);
		
	//	deleteHUSBAND(1001);										// Exception Foreign Key Constraint fails  
		
		
		
	}
	
}
