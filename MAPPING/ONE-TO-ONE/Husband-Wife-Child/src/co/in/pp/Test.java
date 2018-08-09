package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	public static void insertALL() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		HusbandDTO hdto=new HusbandDTO();
		
	//	hdto.setHid(101);
		
		hdto.setHname("Santosh");
		
		hdto.setHgender("Male");
		
		hdto.setHage(48);
		
		hdto.setHmobile(999666444);
		
		hdto.setHoccupation("Engineer");
		
		
															WifeDTO wdto=new WifeDTO();
															
														//	wdto.setWid(101);
		
															wdto.setWname("Aruna");
															
															wdto.setWgender("Female");
															
															wdto.setWage(38);
		
															wdto.setWmobile(888555333);
		
															wdto.setWoccupation("House-Wife");
															
															
															
															
															ChildDTO cdto= new ChildDTO();
															
															cdto.setCid(102);
															
															cdto.setCname("Suraj");
															
															cdto.setCgender("Male");
															
															cdto.setCage(21);
															
															cdto.setCmobile(777444222);
															
															cdto.setCeducation("B.Tech");
															
															
															
															
			wdto.setChild(cdto);					// Store Child Object		
	
			hdto.setWife(wdto);
			
			
															
			Transaction ts=sess.beginTransaction();
			
			sess.save(hdto);
			
			ts.commit();
			
			System.out.println("Insert Successfully");
			
			
			sess.close();
			
			sf.close();
			
			
	}
	
	
	public static void getALL() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from HusbandDTO");
		
		
		List rows=q1.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			HusbandDTO hdto=(HusbandDTO) itr.next(); 
			
			WifeDTO wdto=hdto.getWife();
			
			ChildDTO cdto=wdto.getChild();
			
			
			System.out.println("Husband Information");
			
			System.out.println(hdto.getHid()+"\t"+hdto.getHname()+"\t"+hdto.getHgender()+"\t"+hdto.getHoccupation()+"\t"+hdto.getHage()+"\t"+hdto.getHmobile()+"\n");
			
			
			System.out.println("Wife Information");
			
			System.out.println(wdto.getWid()+"\t"+wdto.getWname()+"\t"+wdto.getWgender()+"\t"+wdto.getWoccupation()+"\t"+wdto.getWage()+"\t"+wdto.getWmobile()+"\n");
			
			
			
			System.out.println("Child Information");
			
			System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getCgender()+"\t"+cdto.getCeducation()+"\t"+cdto.getCage()+"\t"+cdto.getCmobile()+"\n");
			
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void getPerticularID(Integer HID) throws Exception
	{
		
	
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();

		
		HusbandDTO hdto=(HusbandDTO) sess.get(HusbandDTO.class, HID);
		
		
		WifeDTO wdto=hdto.getWife();
		
		ChildDTO cdto=wdto.getChild();
		
		
		System.out.println("Husband Information");
		
		System.out.println(hdto.getHid()+"\t"+hdto.getHname()+"\t"+hdto.getHgender()+"\t"+hdto.getHoccupation()+"\t"+hdto.getHage()+"\t"+hdto.getHmobile()+"\n");
		
		
		System.out.println("Wife Information");
		
		System.out.println(wdto.getWid()+"\t"+wdto.getWname()+"\t"+wdto.getWgender()+"\t"+wdto.getWoccupation()+"\t"+wdto.getWage()+"\t"+wdto.getWmobile()+"\n");
		
		
		
		System.out.println("Child Information");
		
		System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getCgender()+"\t"+cdto.getCeducation()+"\t"+cdto.getCage()+"\t"+cdto.getCmobile()+"\n");

		
	
		sess.close();
		
		sf.close();
		
		
		
	}
	
	
	
	public static void update_child(Integer HID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();

		
		HusbandDTO hdto=(HusbandDTO) sess.get(HusbandDTO.class, HID);
		
		
		WifeDTO wdto=hdto.getWife();
		
		
		ChildDTO cdto=wdto.getChild();
		
		
		cdto.setCname("Hitansh");

		
		System.out.println("Child OLD Information");
		
		System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getCgender()+"\t"+cdto.getCeducation()+"\t"+cdto.getCage()+"\t"+cdto.getCmobile()+"\n");

		
		

		Transaction ts =sess.beginTransaction();
		
		sess.update(hdto);
		
		ts.commit();
		
		

		System.out.println("Child NEW Information");
		
		System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getCgender()+"\t"+cdto.getCeducation()+"\t"+cdto.getCage()+"\t"+cdto.getCmobile()+"\n");
		
		
	
		sess.close();
		
		sf.close();
		
	}
	
	
	
	public static void update_all(Integer HID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();

		
		HusbandDTO hdto=(HusbandDTO) sess.get(HusbandDTO.class, HID);
		
		
		WifeDTO wdto=hdto.getWife();
		
		
		ChildDTO cdto=wdto.getChild();
		
		
		hdto.setHname("Aashish");
		
		wdto.setWname("Seema");
		
		cdto.setCname("Ankit");

		
		
		

		Transaction ts =sess.beginTransaction();
		
		sess.update(hdto);
		
		ts.commit();
		
		
		System.out.println("Husband NEW Information");
		
		System.out.println(hdto.getHid()+"\t"+hdto.getHname()+"\t"+hdto.getHgender()+"\t"+hdto.getHoccupation()+"\t"+hdto.getHage()+"\t"+hdto.getHmobile()+"\n");
		
		
		System.out.println("Wife NEW Information");
		
		System.out.println(wdto.getWid()+"\t"+wdto.getWname()+"\t"+wdto.getWgender()+"\t"+wdto.getWoccupation()+"\t"+wdto.getWage()+"\t"+wdto.getWmobile()+"\n");


		System.out.println("Child NEW Information");
		
		System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getCgender()+"\t"+cdto.getCeducation()+"\t"+cdto.getCage()+"\t"+cdto.getCmobile()+"\n");
		
		
	
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void delete_PerticularID(Integer HID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();

		
		HusbandDTO hdto=(HusbandDTO) sess.get(HusbandDTO.class, HID);


		
		Transaction ts=sess.beginTransaction();
		
		sess.delete(hdto);
		
		ts.commit();
		
		System.out.println("Delete Successfully");
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	insertALL();
		
	//	getALL();
		
	//	getPerticularID(102);
		
	//	update_child(102);
		
	//	update_all(102);
		
	//	delete_PerticularID(102);
		
		
	}
	
	
}
