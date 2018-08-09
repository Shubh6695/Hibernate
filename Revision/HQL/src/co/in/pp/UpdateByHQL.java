package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class UpdateByHQL {
	
	
	
	public static void UpdateDemo() throws Exception
	{
		
	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Insert ID for Updating Record");
		
		int id=sc.nextInt();
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		

		
		UserDTO dto=(UserDTO) s.get(UserDTO.class, id);
		
		
		System.out.println("OLD Record :---");
		
		System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
		System.out.println();

		
		System.out.println("Insert New First Name");

		String fname=sc.next();
		dto.setFname(fname);
		
		
		System.out.println("Insert New Last Name");

		String lname=sc.next();
		dto.setLname(lname);
		
		System.out.println("Insert New EMAIL ");

		String email=sc.next();
		dto.setEmail(email);
		
		
		System.out.println("Insert New Address");

		String address=sc.next();
		dto.setAddress(address);
		
		
		System.out.println("Insert New Mobile");

		int mobile=sc.nextInt();
		dto.setMobile(mobile);
		

		System.out.println("Insert New Age");

		int age=sc.nextInt();
		dto.setAge(age);
		
		
		
		Transaction ts=s.beginTransaction();
		
		s.update(dto);
		
		ts.commit();
		
		s.close();
		
	}

	public static void main(String[] args) throws Exception
	{
	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Insert 1 for Update() ");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			UpdateDemo();
		}
		
	
			
	}

}
