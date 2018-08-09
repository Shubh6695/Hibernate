package co.in.pp;

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
		
		
		
		StudentDTO student1=new StudentDTO();
		
		student1.setFname("Shubham");
		
		student1.setLname("Tale");
		
		student1.setEmail("shubham@gmail.com");
		
		student1.setAge(24);
		
		student1.setMobile(999666333);
		
		
		StudentDTO student2=new StudentDTO();
		
		student2.setFname("Aman");
		
		student2.setLname("Jain");
		
		student2.setEmail("aman@gmail.com");
		
		student2.setAge(45);
		
		student2.setMobile(999888777);

		
		
		StudentDTO student3=new StudentDTO();
		
		student3.setFname("Ankit");
		
		student3.setLname("Sharma");
		
		student3.setEmail("ankit@gmail.com");
		
		student3.setAge(18);
		
		student3.setMobile(999555222);

		
		
		StudentDTO student4=new StudentDTO();
		
		student4.setFname("Naveen");
		
		student4.setLname("Khapre");
		
		student4.setEmail("naveen@gmail.com");
		
		student4.setAge(22);
		
		student4.setMobile(999666555);

		
		StudentDTO student5=new StudentDTO();
		
		student5.setFname("Vijay");
		
		student5.setLname("Patel");
		
		student5.setEmail("vijay@gmail.com");
		
		student5.setAge(49);
		
		student5.setMobile(999444111);

		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(student1);
		
		sess.save(student2);
		
		sess.save(student3);
		
		sess.save(student4);
		
		sess.save(student5);
		
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();

		
		
		
	}
	
	public static void likeFilterDemo1() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Filter f=sess.enableFilter("firstnamelike");
		
		f.setParameter("first", "Shubham");
		
		
		Query q=sess.createQuery("from StudentDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			StudentDTO student=(StudentDTO) itr.next();
			
			
			System.out.println(student.getSid()+"\t"+student.getFname()+"\t"+student.getLname()+"\t"+student.getEmail()+"\t"+student.getAge()+"\t"+student.getMobile()+"\n");
			
			
		}
		
		sess.disableFilter("firstnamelike");
		
		sess.close();
		
		sf.close();

		
		
	}

	
	
	
	public static void agegreaterthanDemo() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Filter f=sess.enableFilter("agegreaterthan");
		
		f.setParameter("a", 23);
		
		
		Query q=sess.createQuery("from StudentDTO");
		
		List rows=q.list();
		
				
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			StudentDTO student=(StudentDTO) itr.next();
			
			
			System.out.println(student.getSid()+"\t"+student.getFname()+"\t"+student.getLname()+"\t"+student.getEmail()+"\t"+student.getAge()+"\t"+student.getMobile()+"\n");
			
			
		}
		
		sess.disableFilter("agegreaterthan");
		
		sess.close();
		
		sf.close();

		
		
	}


	public static void main(String[] args)throws Exception
	{
		
	//	insertALL();
		
	//	likeFilterDemo1();
		
		agegreaterthanDemo();
		
		
	}
}
