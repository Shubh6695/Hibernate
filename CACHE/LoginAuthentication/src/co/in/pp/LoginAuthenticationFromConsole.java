package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;




public class LoginAuthenticationFromConsole 
{

	public static void SQLLOGIN(String email, int mobile) throws Exception
	{
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s1=sf.openSession();
		
		
		Query q1= s1.createSQLQuery("select * from users where email= ? and mobile= ?");
	

		((SQLQuery) q1) .addEntity(UserDTO.class);
		
		q1.setParameter(0, email);
		
		q1.setParameter(1, mobile);
			
		
		List rows1=q1.list();
		
		System.out.println("List Size is :---"+rows1.size());
		
		
		if(rows1.size()==1)
		{
			
			UserDTO dto=(UserDTO) rows1.get(0);
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println("Login Successfully");
						
			
			
		}
		
		else
		{
			System.out.println("Details Not Valid");
		}
		
		
		s1.close();
		
		sf.close();
		
	}
	
	
	
	public static void HQLLOGIN(String email, int mobile) throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s2=sf.openSession();
		
		
		Query q2=s2.createQuery("from UserDTO where email = ? and mobile= ?");
		
		
		q2.setString(0, email);
		
		q2.setInteger(1, mobile);
		
		
		List rows2=q2.list();
		
		
		if(rows2.size()==1)
		{
			
			UserDTO dto=(UserDTO) rows2.get(0);
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
			
		}
		
		else
		{
			System.out.println("Details Not Valid");
		}

		
	s2.close();
	
	sf.close();
		
		
	}
	
	
	
	public static void LOGINCRITERIA(String email, int mobile) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s3=sf.openSession();
		
		
		Criteria crit=s3.createCriteria(UserDTO.class);
		
		
		Criterion c1=Restrictions.eq("email", email);
		
		Criterion c2=Restrictions.eq("mobile", mobile);
		
		Criterion c3=Restrictions.and(c1, c2);
		
		
		crit.add(c3);
		
		
		List rows3=crit.list();
		
		if(rows3.size()==1)
		{
			
			UserDTO dto=(UserDTO) rows3.get(0);
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
			
		}
		
		else
		{
			System.out.println("Details Not Valid");
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
		
		
		System.out.println("Insert Email Id");
		
		String email=sc.next();
		
		
		System.out.println("Insert Mobile no");
		
		int mobile=sc.nextInt();
		
		
		if(choice==1)
		{
			
			SQLLOGIN(email, mobile);
			
		}
		
		
		
		if(choice==2)
		{
			
			HQLLOGIN(email, mobile);
		}
		
		
		
		if(choice==3)
		{
			
			LOGINCRITERIA(email, mobile);
		}
		
	}
	
	
}
