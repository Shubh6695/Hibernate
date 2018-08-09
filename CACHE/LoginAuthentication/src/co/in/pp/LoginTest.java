package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;

public class LoginTest
{

	
	
	public static void LOGINSQL() throws Exception
	{
		
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s1=sf.openSession();
		
		Query q1=s1.createSQLQuery("select * from users where email= ? and mobile= ?");
		
		((SQLQuery) q1) .addEntity(UserDTO.class);
		
		
		q1.setString(0, "s@gmail.com");
		q1.setInteger(1, 778899);
		
		
		List rows1=q1.list();
		
		
		if(rows1.size()==1)
		{
			
			UserDTO dto=(UserDTO) rows1.get(0);
			
			System.out.println("Login Successfully");
						
			System.out.println("Welcome "+dto.getFname());
			
		}
		
		else
		{
			System.out.println("Details Not Valid");
		}
		
		s1.close();
		
		
		
	}
	

	public static  void LOGINHQL() throws Exception
	{
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s2=sf.openSession();
		
		
		Query q2=s2.createQuery("from UserDTO where email= ? and mobile= ?");
		
		q2.setParameter(0, "v@gmail.com");
		q2.setParameter(1, 22333);
		
		
		List rows2=q2.list();
		
		if(rows2.size()==1)
		{
			UserDTO dto=(UserDTO) rows2.get(0);
			
			System.out.println("Login Successfully");
			
		}
		
		else
		{
			
			System.out.println("Login Fail");
			
		}
		
		s2.close();
		
		sf.close();
	}
	
	
	public static  void LOGINCRITERIA() throws Exception
	{

		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s3=sf.openSession();
		
		
		Criteria crit=s3.createCriteria(UserDTO.class);
		
		Criterion c1=Restrictions.eq("email", "sv@gmail.com");

		Criterion c2=Restrictions.eq("mobile", 666333);
		
		Criterion c3=Restrictions.and(c1, c2);
		
		crit.add(c3);
		
		
		
		List rows3=crit.list();
		
		if(rows3.size()==1)
		{
			UserDTO dto=(UserDTO) rows3.get(0);
			
			System.out.println("Login Successfully");
			
		}
		
		else
		{
			
			System.out.println("Login Fail");
			
		}

		
		
		s3.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		System.out.println("Enter 1 for Login through SQL");
		
		
		System.out.println("Enter 2 for Login through HQL");
		
		
		System.out.println("Enter 3 for Login through Criteria");
		
		System.out.println();
		
		
		System.out.println("Enter Choice");
		
		
		Scanner sc=new Scanner(System.in);
		
		int choice=sc.nextInt();
		
		
		
		
		
		if(choice==1)
		{
			
			
			LOGINSQL();
			
		}
		
		
		if(choice==2)
		{
			
			LOGINHQL();
			
		}
		
		
		if(choice==3)
		{
			
			LOGINCRITERIA();
			
		}
		
	}
	
	
}
