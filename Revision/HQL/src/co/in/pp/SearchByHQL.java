package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class SearchByHQL {

	
	
	
	public static void SearchHQL() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Insert ID for Search Record");
		
		int id=sc.nextInt();
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		UserDTO dto=(UserDTO)s.get(UserDTO.class, id);
		
		
		System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
		
		
	}
	
	
	
	public static void SearchALLfromList() throws Exception
	{
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Insert Name for Search");
		
		String name=sc.next();
		
		String name1="'"+name+"'";
		
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Query q=s.createQuery("from UserDTO where fname = "+name1);
		
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		
		UserDTO dto;
		
		while(itr.hasNext())
		{
			dto=(UserDTO)itr.next();
			
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
			
		}
			
		s.close();
		
		
		
	}
	
	
	
	public static void SearchFirstLast() throws Exception
	{
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Insert First Name ");
		String f=sc.next();
		
		
		System.out.println("Insert Last Name  ");
		String l=sc.next();
		
		
		String fname="'"+f+"'";
		String lname="'"+l+"'";
		
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		Query q=s.createQuery("from UserDTO where fname ="+fname+" and lname ="+lname);
		
		
		List rows=q.list();
		
		
		Iterator itr=rows.iterator();
		
		
		UserDTO dto;
		
		while(itr.hasNext())
		{
			dto=(UserDTO) itr.next();
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
			
			
		}
		
		s.close();
	}
	
	
	public static void SearchByPlaceholder() throws Exception
	{
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Insert First Name");
		
		String fname= sc.next();
		
		
		System.out.println("Insert Last Name");
		
		String lname= sc.next();
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Query q=s.createQuery("from UserDTO where fname = :n and lname = :l");
		
		
		q.setParameter("n", fname);
		q.setParameter("l", lname);
		
		
		
		
		List rows =q.list();
		
		
		Iterator itr= rows.iterator();
		
		
		UserDTO dto;
		
		while(itr.hasNext())
		{
			
			dto=(UserDTO) itr.next();
			
			
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		

		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Insert 1 for Search on Id basis");
		
		System.out.println("Insert 2 for Search on First Name");
		
		System.out.println("Insert 3 for Search on First Name and Last Name");
		
		System.out.println("Insert 4 for Search on First Name and Last Name by Placeholder");
		
		int choice=sc.nextInt();
		
		
		if(choice==1)
		{
			SearchHQL();
		
		}
		
		
		if(choice==2)
		{
			SearchALLfromList();
			
		}
			
		
		if(choice==3)
		{
			
			SearchFirstLast();
		}
		
		
		if(choice==4)
		{
			SearchByPlaceholder();
		}
		
		
		sc.close();
		
	}

}
