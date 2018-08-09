package co.in.pp;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test {

	public static void Cache1() throws Exception
	{

		Configuration cfg=new Configuration();
		
		
		cfg.configure();
		
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		
		
		UserDTO dto1=(UserDTO) s.load(UserDTO.class, 1);		
		
		System.out.println("UserDTO Object 1 (dto1)");
		
		System.out.println(dto1.getId()+"\t"+dto1.getFname()+"\t"+dto1.getLname()+"\t"+dto1.getEmail()+"\t"+dto1.getAddress()+"\t"+dto1.getMobile()+"\t"+dto1.getAge());
		
		System.out.println();
		
		
		
		UserDTO dto2=(UserDTO) s.get(UserDTO.class, 1);
		
		System.out.println("UserDTO object 2 (dto2) ");
		
		dto2.setFname("Naveen");
		
		Transaction ts=s.beginTransaction();
		
		s.update(dto2);
		
		ts.commit();
		
		System.out.println("Update Successfully");
		
		System.out.println();
		
		
		
		UserDTO dto3=(UserDTO) s.load(UserDTO.class, 1); 
		
		
		
		System.out.println("UserDTO object 3 (dto3) ");
		
		System.out.println(dto3.getId()+"\t"+dto3.getFname()+"\t"+dto3.getLname()+"\t"+dto3.getEmail()+"\t"+dto3.getAddress()+"\t"+dto3.getMobile()+"\t"+dto3.getAge());
		
		System.out.println();

		
		s.close();
		
	}
	
	
	public static void main(String[] args) throws Exception 
	{
	
		
		Cache1();
		

	}

}
