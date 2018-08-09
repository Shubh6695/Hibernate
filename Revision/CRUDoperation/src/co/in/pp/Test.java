package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;



public class Test
{

	
	
	
	public static void RecordInsertion() throws Exception
	{
		
		
		
		Scanner sc=new Scanner(System.in);
		
		
			System.out.println("Insert First Name ");
		
			String fname=sc.nextLine();
		
			
			System.out.println("Insert Last Name");
		
			String lname=sc.nextLine();
			
			
			System.out.println("Insert Email ");
				
			String email=sc.nextLine();
			
			
			System.out.println("Insert Address");
			
			String address=sc.nextLine();
			
			
			System.out.println("Insert Mobile no");
			
			int mobile=sc.nextInt();
			
			
			System.out.println("Insert Age");
			
			int age=sc.nextInt();
			

																			// Case :- 1 
		UserDTO dto= new UserDTO();											// Transient State
		
			
			dto.setFname(fname);
			
			dto.setLname(lname);
			
			dto.setEmail(email);
			
			dto.setAddress(address);
			
			dto.setMobile(mobile);
			
			dto.setAge(age);
			

			
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
			
			
	Session s=sf.openSession();

			
	Transaction ts=s.beginTransaction();		
	
			
	s.save(dto);																// Persistent State
	
	ts.commit();
	
	System.out.println("Record is Inserted");
	
	s.close();
	
			
	}
	
	
	
	
	public static void RecordUpdation() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Insert ID for Updation ");
		int id=sc.nextInt();
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		Transaction ts=s.beginTransaction();
		
		
		UserDTO dto=(UserDTO)s.get(UserDTO.class, id);						// Persistent State
		
		
		System.out.println();
		System.out.println("Old Record is:---");
		System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
		
		
		System.out.println("Insert NEW First Name");
		String fname=sc.next();
		
		
		System.out.println("Insert NEW Last Name");
		String lname=sc.next();
		
		
		System.out.println("Insert NEW Email ");
		String email=sc.next();
		
		
		System.out.println("Insert NEW Address");
		String address=sc.next();
		
		
		System.out.println("Insert NEW Mobile");
		int mobile=sc.nextInt();
		
		System.out.println("Insert NEW Age");
		int age=sc.nextInt();
		
		
		
		dto.setFname(fname);											// Detached State
		
		dto.setLname(lname);											// In these State Permanent store data is change
						
		dto.setEmail(email);											// and it will go to Persistent State. 
		
		dto.setAddress(address);
		
		dto.setMobile(mobile);
		
		dto.setAge(age);
		
		
		
		
		s.update(dto);														// Again Persistent State
		
		ts.commit();
		
		
		System.out.println("Record is Update");
		
		s.close();
		
	}
	
	
	
	
	public static void RecordDeletion() throws Exception
	{
				
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Insert Id for Delete ");
		
		int id=sc.nextInt();
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
		
		
		UserDTO dto=new UserDTO();
		
		
		dto.setId(id);
		
		
		
		s.delete(dto);
		
		
		ts.commit();
		
		
		System.out.println("Record is Deleted");
		
		s.close();
	}
	
	
	
	public static void ShowSingle()throws Exception
	{
		System.out.println("Insert Id for Searching");
		
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		UserDTO dto=(UserDTO)s.get(UserDTO.class, id);
		
		
		System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
		System.out.println();
		
		s.close();
		
		
	}
	
	
	public static void ShowList() throws Exception 
	{
		
		System.out.println("IT HAS 3-Way ");
		System.out.println("1. SQL (createSQLQuery)");
		System.out.println("2. HQL (createQuery)");
		System.out.println("3. HCQL (createCriteria)");
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
	//	Query q=s.createSQLQuery("select * from users");						// 1. SQL
		
	//	((SQLQuery) q).addEntity(UserDTO.class);							// IN SQL we require Type-casting 
		
		
	//	Query q=s.createQuery("from UserDTO");									// 2. HQL
		
		
		
		Criteria q=s.createCriteria(UserDTO.class);								// 3. HCQL
		
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
		
			UserDTO dto=(UserDTO)itr.next();
						
			System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
			
			System.out.println();

			
			
		}
		
		s.close();
		
	}
	
	
	
	public static void main(String[] args)  throws Exception
	{
	
		System.out.println("Welcome :---- ");
		System.out.println();
		
		
		
		System.out.println("Insert 1 for Record Insertion");
		
		System.out.println("Insert 2 for Record Updation");
		
		System.out.println("Insert 3 for Record Deletion");
		
		System.out.println("Insert 4 for Show Record by Id");
		
		System.out.println("Insert 5 for Show Record List");
		
		
		
		
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();


		if(choice==1)
		{
			RecordInsertion();
			
		}
		

		if(choice==2)
		{
			
			RecordUpdation();
		}
		
		
		if(choice==3)
		{
			RecordDeletion();
			
		}
		
		
		if(choice==4)
		{
			ShowSingle();
		}
		
		
		if(choice==5)
		{
			ShowList();
		}
		
		
	}

}
