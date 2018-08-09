package co.in;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import java.util.*;


public class Test {

	
	public static void testADD() throws Exception
	{
		
		Scanner sc=new Scanner(System.in);
		
	//	System.out.println("Insert Roll no :--  ");
		
	//	int rollno=sc.nextInt();
		
		
		System.out.println("Insert Name :--  ");
		
		String name=sc.next();
		
		
		System.out.println("Insert Physics Marks :--  ");
		
		int phy=sc.nextInt();
		
		
		System.out.println("Insert Chemistry Marks :--  ");
		
		int che=sc.nextInt();
		
		
		System.out.println("Insert Maths Marks :--  ");
		
		int maths=sc.nextInt();
		
		
		
		StudentDTO dto=new StudentDTO();
		
	//	dto.setRollno(rollno);
		
		dto.setName(name);
		
		dto.setPhysics(phy);
		
		dto.setChemistry(che);
		
		dto.setMaths(maths);
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
		
		
		s.save(dto);
				
		ts.commit();
		
		s.close();
		
	}
	
	
	
	
	public static void testUPDATE() throws Exception
	{
		
		System.out.println("Insert rollno for Updation");
		
		Scanner sc=new Scanner(System.in);
		
		int rollno=sc.nextInt();
		
	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
		
		
		StudentDTO dto=(StudentDTO)s.get(StudentDTO.class, rollno);
		
		
		
	System.out.println("Your old Name is:-- "+dto.getName());	
			
		
			System.out.println("Insert New Name ");
			
			String name=sc.next();
			
			dto.setName(name);
			
	
	System.out.println("Your Old Physics Marks:--  "+dto.getPhysics());
	
			
			System.out.println("Insert New Physics Marks");
			
			int phy=sc.nextInt();
			
			dto.setPhysics(phy);
			
			
	System.out.println("Your Old Chemistry Marks :--  "+dto.getChemistry());		
			
			
			System.out.println("Insert New Chemistry Marks");
			
			int che=sc.nextInt();
			
			dto.setChemistry(che);
			
	
	
	System.out.println("Your Old Maths Marks :-- "+dto.getMaths());		
		
	
			System.out.println("Insert New Maths Marks");
			
			int maths=sc.nextInt();
			
			dto.setMaths(maths);
		
		
		
		
		s.update(dto);
		
		ts.commit();
		
		s.close();
		
		
	}
	
	
	
	public static void testDELETE() throws Exception
	{
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Insert Roll no to delete :-- ");
		
		int rollno=sc.nextInt();
		
		StudentDTO dto=new StudentDTO();
		
		
		dto.setRollno(rollno);
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
		
		
		s.delete(dto);
		
		ts.commit();
		
		
		s.close();
		
	}
	
	
	public static void testGET() throws Exception
	{
	
		System.out.println("Insert rollno for Getting result");
		
		Scanner sc=new Scanner(System.in);
		
		int rollno=sc.nextInt();
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		
		StudentDTO dto=(StudentDTO)s.get(StudentDTO.class, rollno);
		
		
		System.out.println("Fected Record for rollno  "+rollno+" is :-- ");
		
		System.out.println(dto.getRollno()+"\t"+dto.getName()+"\t"+dto.getPhysics()+"\t"+dto.getChemistry()+"\t"+dto.getMaths());
		
		
		
	}
	
	
	
	public static void testGETALL() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
				
		Query q=s.createQuery("from StudentDTO");
		
		
		List li=q.list();
		
		Iterator it=li.iterator();
		
		
		StudentDTO dto;
		
		
		while(it.hasNext())
		{
		
			
			dto=(StudentDTO)it.next();
			
			System.out.println(dto.getRollno()+"\t"+dto.getName()+"\t"+dto.getPhysics()+"\t"+dto.getChemistry()+"\t"+dto.getMaths());
			
			System.out.println();
			
		}
		
		
		s.close();
		
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception
	{
	
		System.out.println("Whats you want to perform :---");
		
		System.out.println("Insert 1 for Insertion Record ");		
		
		System.out.println("Insert 2 for Updation Record ");
		
		System.out.println("Insert 3 for Deletion Record ");
		
		System.out.println("Insert 4 for Show Record ");
		
		System.out.println("Insert 5 for Show Full List ");
		
		
		
		Scanner sc=new Scanner(System.in);
		
		int i=sc.nextInt();
		
		
		if(i==1)
		{
			System.out.println("Insertion is Selected");
			
			testADD();
		
		}	
		
		
		else if(i==2)
		{

			System.out.println("Updation is Selected");
			
				testUPDATE();
			
		}

	
		else if(i==3)
		{
			System.out.println("Deletion is Selected");
			
				testDELETE();			
		}

		
		else if(i==4)
		{
			
			System.out.println("Show Record is Selected");
			
			
			  testGET();
			
		}
		
		else if(i==5)
		{
			
			System.out.println("Show Full list");
			
			
			testGETALL();
			
		}
		
	}
}
