package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;


public class LoginMain 
{
	
	public static void SQLLOGIN(UserDTO dto) throws Exception
	{
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s1=sf.openSession();
		
		
		Query q1= s1.createSQLQuery("select * from users where email= ? and mobile= ?");
	

		((SQLQuery) q1) .addEntity(UserDTO.class);
		
		q1.setParameter(0, dto.getEmail());
		
		q1.setParameter(1, dto.getMobile());
			
		
		List rows1=q1.list();
		
		
		
		
		if(rows1.size()==1)
		{
			
			dto=(UserDTO) rows1.get(0);
			
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
	

	
	
	public static void HQLLOGIN(UserDTO dto) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s1=sf.openSession();
		
		
		Query q1=s1.createQuery("from UserDTO where email= ? and mobile= ?");
		
		q1.setString(0, dto.getEmail());
		
		q1.setInteger(1, dto.getMobile());
		
		
		List rows1=q1.list();
		
		if(rows1.size()==1)
		{
			dto=(UserDTO) rows1.get(0);
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
			
		}
		
		else
		{
			System.out.println("Details Not Valid");
		}
	
	s1.close();
	
	sf.close();
	
	
	}
	
	
	public static void LOGINCRITERIA(UserDTO dto) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s2=sf.openSession();
		
		Criteria crit=s2.createCriteria(UserDTO.class);
		
		
		Criterion c1=Restrictions.eq("email", dto.getEmail());
		
		Criterion c2=Restrictions.eq("mobile", dto.getMobile());
		
		Criterion c3=Restrictions.and(c1, c2);
		
		
		crit.add(c3);
		
		
		List rows2=crit.list();
		
		
		if(rows2.size()==1)
		{
			dto =(UserDTO) rows2.get(0);
			
			
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
	
	
	

	public static void main(String[] args) throws Exception
	{
		
		System.out.println("Enter 1 for Login through SQL");
		
		System.out.println("Enter 2 for Login through HQL");
		
		System.out.println("Enter 3 for Login through Criteria");
		
		
		System.out.println();
		
		
		System.out.println("Enter Choice");
		
				
		Scanner sc=new Scanner(System.in);
		
		int choice=sc.nextInt();
		
		
		System.out.println("Insert Email ID");
		
		String email=sc.next();
		
		
		System.out.println("Insert Mobile No");
		
		int mobile=sc.nextInt();
		
		
		
		UserDTO dto= new UserDTO();
		
		dto.setEmail(email);
		
		dto.setMobile(mobile);
		
		
		if(choice==1)
		{

		SQLLOGIN(dto);
		
		}
		

		if(choice==2)
		{

			HQLLOGIN(dto);
		
		}

		
		if(choice==3)

		{
			LOGINCRITERIA(dto);
			
		}
		
		
		
	}
	
	
}
