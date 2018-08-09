package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	
	public static void InsertALL() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		DepartmentDTO depdto=new DepartmentDTO();
		
		depdto.setDepartmentid(101);
		depdto.setDepartmentname("Developing");
		
		
					EmployeeDTO edto1=new EmployeeDTO();
					
					edto1.setEid(201);
		
					edto1.setFname("Anmol");
					
					edto1.setLname("Rathore");
					
					edto1.setEmail("a@gmail.com");
					
					edto1.setMobile(888999666);
					
					edto1.setSalary(20000);
					
					
					
					
					
					EmployeeDTO edto2= new EmployeeDTO();
					
					edto2.setEid(202);
					
					edto2.setFname("Naveen");
					
					edto2.setLname("Khapre");
					
					edto2.setEmail("n@gmail.com");
					
					edto2.setMobile(777666333);
					
					edto2.setSalary(35000);
					
										
					
					
					EmployeeDTO edto3=new EmployeeDTO();
					
					edto3.setEid(203);
					
					edto3.setFname("Shrangesh");
					
					edto3.setLname("Chourey");
					
					edto3.setEmail("sc@gmail.cocm");
					
					edto3.setMobile(666333999);
					
					edto3.setSalary(15000);
					
							
					
					
		Set s=new HashSet();
		
		s.add(edto1);
		
		s.add(edto2);
		
		s.add(edto3);
					
					
					
		depdto.setDepartmentChild(s);			
					
					
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(depdto);
		
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
					
		sf.close();	
	
	}
	
	
	
	
	public static void UpdateChild(int DID, int EID) throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
	
		DepartmentDTO depdto=(DepartmentDTO) sess.get(DepartmentDTO.class, DID);
		
		
		System.out.println("Department Details");
		
		
		System.out.println(depdto.getDepartmentid()+"\t"+depdto.getDepartmentname());
		
		
		
		Set s=depdto.getDepartmentChild();
		
		
		if(!s.isEmpty())
		{
			Iterator itr =s.iterator();
			
			
			EmployeeDTO edto=(EmployeeDTO) itr.next();
			
			
			if(edto.getEid()==EID)
			{
				
				
				System.out.println("OLD Record is :--");
			
				System.out.println(edto.getEid()+"\t"+edto.getFname()+"\t"+edto.getLname()+"\t"+edto.getEmail()+"\t"+edto.getMobile()+"\t"+edto.getSalary()+"\t"+edto.getDid());
				
				
				edto.setFname("Shubham");
				
				edto.setLname("Tale");
				
				edto.setEmail("st@gmail.com");
				
				
				
				
				
				Transaction ts=sess.beginTransaction();
				
				
				sess.update(edto);
				
				
				ts.commit();
				
				
				
				System.out.println("Update Successfully");
			
				System.out.println("NEW Record is :--");
				
				
				System.out.println(edto.getEid()+"\t"+edto.getFname()+"\t"+edto.getLname()+"\t"+edto.getEmail()+"\t"+edto.getMobile()+"\t"+edto.getSalary()+"\t"+edto.getDid());
			
				
				
				
				
				sess.close();
				
				
				
				
			}
			
			
			
		}
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		
	//	InsertALL();
		
		
		UpdateChild(101, 201);
		
		
	}
	
}
