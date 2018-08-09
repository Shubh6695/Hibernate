package co.in.pp;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test 
{

	
	public static void Insert_Child_To_Parent() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		HusbandDTO hdto=new HusbandDTO();
		
		hdto.setHid(101);
		
		hdto.setHfname("Vijay");
		
		hdto.setHlname("Tale");
		
		hdto.setHgender("Male");
		
		hdto.setHage(52);
		
		hdto.setHmobile(999666333);
		
		
		
															WifeDTO wdto=new WifeDTO();
		
														//	wdto.setWid(201);									// Primary key of Parent is Set as the Primary Key of Child.  
																												// and treat as Foreign Key.
																												// So Here 201 is NOT store, IT Store 101.
															wdto.setWfname("Sadhana");
		
															wdto.setWlname("Tale");
		
															wdto.setWgender("Female");
		
															wdto.setWage(42);
															
															wdto.setWmobile(888555222);
	
															wdto.setHusbandParent(hdto);
															
			
															
				Transaction ts=sess.beginTransaction();
				
				sess.save(wdto);
				
				ts.commit();
				
				System.out.println("Insert Successfully");
	
	
				sess.close();
				
				sf.close();
	
	}
	
	
	
	public static void Get_CHILD_To_Parent(Integer WID) throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		WifeDTO wdto=(WifeDTO) sess.get(WifeDTO.class, WID);
		
		
		System.out.println("Wife Detail's");
		
		
		System.out.println(wdto.getWid()+"\t"+wdto.getWfname()+"\t"+wdto.getWlname()+"\t"+wdto.getWgender()+"\t"+wdto.getWage()+"\t"+wdto.getWmobile()+"\n");
		
		
		
		HusbandDTO hdto=wdto.getHusbandParent();
		
		
		System.out.println("Husband Detail's");
		
		
		System.out.println(hdto.getHid()+"\t"+hdto.getHfname()+"\t"+hdto.getHlname()+"\t"+hdto.getHgender()+"\t"+hdto.getHage()+"\t"+hdto.getHmobile()+"\n");
		
		
		
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void Update_Child_To_Parent(Integer WID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		WifeDTO wdto=(WifeDTO) sess.get(WifeDTO.class, WID);
		
		
		
		HusbandDTO hdto=wdto.getHusbandParent();
		

		System.out.println("Husband OLD Detail's");
		
		
		System.out.println(hdto.getHid()+"\t"+hdto.getHfname()+"\t"+hdto.getHlname()+"\t"+hdto.getHgender()+"\t"+hdto.getHage()+"\t"+hdto.getHmobile()+"\n");

		
		
		
		
		hdto.setHage(52);
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.update(wdto);
		
		ts.commit();
		
		
		System.out.println("Husband NEW Detail's");
		
		
		System.out.println(hdto.getHid()+"\t"+hdto.getHfname()+"\t"+hdto.getHlname()+"\t"+hdto.getHgender()+"\t"+hdto.getHage()+"\t"+hdto.getHmobile()+"\n");

		
		
		sess.close();
		
		sf.close();
		
	
		
		
	}
	
	
	
	public static void Update_Parent_To_Parent(Integer WID) throws Exception
	{
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		WifeDTO wdto=(WifeDTO) sess.get(WifeDTO.class, WID);
		
		
		System.out.println("Wife OLD Detail's");
		
		
		System.out.println(wdto.getWid()+"\t"+wdto.getWfname()+"\t"+wdto.getWlname()+"\t"+wdto.getWgender()+"\t"+wdto.getWage()+"\t"+wdto.getWmobile()+"\n");

		

		wdto.setWage(40);
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.update(wdto);
		
		ts.commit();
		
		
		System.out.println("Wife NEW Detail's");
		
		
		System.out.println(wdto.getWid()+"\t"+wdto.getWfname()+"\t"+wdto.getWlname()+"\t"+wdto.getWgender()+"\t"+wdto.getWage()+"\t"+wdto.getWmobile()+"\n");

		
		sess.close();
		
		sf.close();
		
		
		
	}
	
	
	public static void Delete_Child_To_Parent(Integer WID) throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		WifeDTO wdto=(WifeDTO) sess.get(WifeDTO.class, WID); 
		
		
		
		
		
		System.out.println("Wife Detail's");
		
		
		System.out.println(wdto.getWid()+"\t"+wdto.getWfname()+"\t"+wdto.getWlname()+"\t"+wdto.getWgender()+"\t"+wdto.getWage()+"\t"+wdto.getWmobile()+"\n");
		
		
		
		HusbandDTO hdto=wdto.getHusbandParent();
		
		
		System.out.println("Husband Detail's");
		
		
		System.out.println(hdto.getHid()+"\t"+hdto.getHfname()+"\t"+hdto.getHlname()+"\t"+hdto.getHgender()+"\t"+hdto.getHage()+"\t"+hdto.getHmobile()+"\n");
		

		
		System.out.println("Before Delete Detail's");
		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.delete(wdto);
		
		ts.commit();
		
		
		System.out.println("Deleted Successfully");
		
		
		
		sess.close();
		
		sf.close();
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		
			Insert_Child_To_Parent();
		
		//	Get_CHILD_To_Parent(101);
		
		//	Update_Child_To_Parent(101);
		
		//	Update_Parent_To_Parent(101);
		
		//	Delete_Child_To_Parent(101);
		
		
	}
	
	
	
	
}
