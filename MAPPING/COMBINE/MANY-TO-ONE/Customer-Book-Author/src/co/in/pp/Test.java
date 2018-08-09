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
		
		
		AuthorDTO adto=new AuthorDTO();
		
		adto.setAuthorid(101);
		
		adto.setAuthorfname("Chetan");
		
		adto.setAuthorlname("Bhagat");
		
		adto.setAuthoremail("chetan@gmail.com");
		
		
		
								BookDTO bdto1=new BookDTO();
								
								bdto1.setBookid(201);
		
								bdto1.setBookisbn(222111);
		
								bdto1.setBooktitle("Half Girlfriend");
								
								bdto1.setBookcategory("Friendship");
								
								bdto1.setBookpublicationyear(2014);
		
								bdto1.setAuthorParent(adto);
								
								
												
													CustomerDTO cdto1=new CustomerDTO();
													
													cdto1.setCid(501);
								
													cdto1.setCfname("Shubham");
								
													cdto1.setClname("Tale");
													
													cdto1.setCemail("shubham@gmail.com");
													
													cdto1.setCtype("Student");
													
													cdto1.setBookParent(bdto1);
													
													
													CustomerDTO cdto2=new CustomerDTO();
													
													cdto2.setCid(502);
													
													cdto2.setCfname("Aman");
													
													cdto2.setClname("Jain");
								
													cdto2.setCemail("aman@gmail.com");
													
													cdto2.setCtype("Professor");
													
													cdto2.setBookParent(bdto1);
													
													
								BookDTO bdto2=new BookDTO();
								
								bdto2.setBookid(202);
											
								bdto2.setBookisbn(222000);
													
								bdto2.setBooktitle("2 States");
													  
								bdto2.setBookcategory("Friendship");					
								
								bdto2.setBookpublicationyear(2004);
		
								bdto2.setAuthorParent(adto);
								
								
													CustomerDTO cdto3=new CustomerDTO();
								
													cdto3.setCid(503);
								
													cdto3.setCfname("Suraj");
								
													cdto3.setClname("Gawande");
								
													cdto3.setCemail("suraj@gmail.com");
													
													cdto3.setCtype("Student");
													
													cdto3.setBookParent(bdto2);
													
													
													CustomerDTO cdto4=new CustomerDTO();
													
													cdto4.setCid(504);
													
													cdto4.setCfname("Ankit");
								
													cdto4.setClname("Sharma");
								
													cdto4.setCemail("ankit@gmail.com");
													
													cdto4.setCtype("Banker");
													
													cdto4.setBookParent(bdto2);

					
				Transaction ts=sess.beginTransaction();
				
				sess.save(cdto1);
				
				sess.save(cdto2);
				
				sess.save(cdto3);
				
				sess.save(cdto4);
				
				
				ts.commit();
				
				
				System.out.println("Insert Successfully");
													
				
				sess.close();
				
				sf.close();
													
	}
	
	public static void getALL() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
	
		Session sess=sf.openSession();
		
		
	
		Query q1=sess.createQuery("from CustomerDTO");
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		
		while(itr.hasNext())
		{
			
			CustomerDTO cdto=(CustomerDTO) itr.next();
			
			System.out.println(cdto.getBookParent().getAuthorParent().getAuthorfname());
			
			
			
			
			
			
			
		}
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	
	public static void getALLDEMO() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
	
		Session sess=sf.openSession();
		
		
		
		int b=0;
	
		Query q1=sess.createQuery("from CustomerDTO");
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		
		while(itr.hasNext())
		{
			
			CustomerDTO cdto=(CustomerDTO) itr.next();
			
			BookDTO bdto=cdto.getBookParent();
			
			AuthorDTO adto=bdto.getAuthorParent();
			
			if(bdto.getBookid() != b)
			{

				b=bdto.getBookid();	
	
				
				System.out.println(bdto.getBookid()+"\t"+bdto.getBookisbn()+"\t"+bdto.getBooktitle()+"\t"+bdto.getBookcategory()+"\t"+bdto.getBookpublicationyear()+"\n");
				
			}

			
			System.out.println(cdto.getCid()+"\t"+cdto.getCfname()+"\t"+cdto.getClname()+"\t"+cdto.getCemail()+"\t"+cdto.getCtype()+"\n");
			
			
		}
		
		
		sess.close();
		
		sf.close();
		
		
	}

	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	insertALL();
		
	//	getALL();
		
	//	getALLDEMO();
		
	}
	
	
}
