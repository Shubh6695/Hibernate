package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test 
{
	
	public static void MergeDEMO() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s1=sf.openSession();
		
		
		EmployeeDTO dto1=(EmployeeDTO) s1.get(EmployeeDTO.class, 1);
		
	
		dto1.setPincode(102030);

		Transaction ts=s1.beginTransaction();
		
		ts.commit();
		
	s1.close();	
		
	
	s1.merge(dto1);
		
	System.out.println("Update Successfully");
	
	sf.close();
	
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		MergeDEMO();
		
		
	}
	
	

}
