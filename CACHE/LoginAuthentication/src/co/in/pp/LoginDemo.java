package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class LoginDemo 
{

	public UserDTO Login(UserDTO dto) throws Exception
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
			
			System.out.println("Login Successfully");

			
			
		}
		
		
		else
		{
			
			System.out.println("Details Not Valid");
		
		}
		
		return dto;
	}
	
	
	public static void main(String[] args) throws Exception
	{
	
		
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Insert Email ID");
		
		String email=sc.next();
		
		
		System.out.println("Insert Mobile No");
		
		int mobile=sc.nextInt();
		
		
		
		UserDTO dto1= new UserDTO();
		
		dto1.setEmail(email);
		
		dto1.setMobile(mobile);


		
		LoginDemo d=new LoginDemo();
		
		
		
		UserDTO dto=d.Login(dto1);
		
		System.out.println();
		
			
		System.out.println(dto.getId()+"\t"+dto.getFname()+"\t"+dto.getLname()+"\t"+dto.getEmail()+"\t"+dto.getAddress()+"\t"+dto.getMobile()+"\t"+dto.getAge());
		
	}
	
	
	
	
}
