package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test 
{

	public static void Insert_ONE_TO_MANY() throws Exception
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
					
																			edto1.setDepartmentParent(depdto);
					
					
					
																			EmployeeDTO edto2= new EmployeeDTO();
					
																			edto2.setEid(202);
					
																			edto2.setFname("Naveen");
					
																			edto2.setLname("Khapre");
					
																			edto2.setEmail("n@gmail.com");
					
																			edto2.setMobile(777666333);
					
																			edto2.setSalary(35000);
					
																			edto2.setDepartmentParent(depdto);
					
																			
					
																			EmployeeDTO edto3=new EmployeeDTO();
					
																			edto3.setEid(203);
					
																			edto3.setFname("Shrangesh");
					
																			edto3.setLname("Chourey");
					
																			edto3.setEmail("sc@gmail.cocm");
					
																			edto3.setMobile(666333999);
					
																			edto3.setSalary(15000);

																			edto3.setDepartmentParent(depdto);
																			
		
			Set s=new HashSet();
			
			s.add(edto1);
			
			s.add(edto2);
			
			s.add(edto3);
																			
																			
		depdto.setEmployeeChild(s);
		
		
		
		sess.save(depdto);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void Insert_MANY_TO_ONE() throws Exception
	{
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		DepartmentDTO depdto=new DepartmentDTO();
		
		depdto.setDepartmentid(102);
		
		depdto.setDepartmentname("Testing");
		
		
																			EmployeeDTO edto1=new EmployeeDTO();
					
																			edto1.setEid(204);
		
																			edto1.setFname("Anmol");
					
																			edto1.setLname("Rathore");
					
																			edto1.setEmail("anmol@gmail.com");
					
																			edto1.setMobile(888000666);
					
																			edto1.setSalary(18000);
					
																			edto1.setDepartmentParent(depdto);
					
					
					
																			EmployeeDTO edto2= new EmployeeDTO();
					
																			edto2.setEid(205);
					
																			edto2.setFname("Sunil");
					
																			edto2.setLname("Verma");
					
																			edto2.setEmail("sunil@gmail.com");
					
																			edto2.setMobile(888666333);
					
																			edto2.setSalary(22000);
					
																			edto2.setDepartmentParent(depdto);
					
																			
					
																			EmployeeDTO edto3=new EmployeeDTO();
					
																			edto3.setEid(206);
					
																			edto3.setFname("Aman");
					
																			edto3.setLname("Jain");
					
																			edto3.setEmail("aman@gmail.cocm");
					
																			edto3.setMobile(666555999);
					
																			edto3.setSalary(15000);

																			edto3.setDepartmentParent(depdto);
			
																			
					sess.save(edto1);
					
					sess.save(edto2);
					
					sess.save(edto3);
									
					
					Transaction ts=sess.beginTransaction();
					
					ts.commit();
					
					
					System.out.println("Insert Successfully");
					
					
					sess.close();
					
					sf.close();
					
					
		

	}																	
	
	
	public static void Insert_SingleChild_ONE_TO_MANY(int DID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		DepartmentDTO depdto=(DepartmentDTO) sess.get(DepartmentDTO.class, DID);
		
		
		EmployeeDTO edto1=new EmployeeDTO();
		
		edto1.setEid(207);

		edto1.setFname("Pankaj");

		edto1.setLname("Trivedi");

		edto1.setEmail("pankaj@gmail.com");

		edto1.setMobile(777555333);

		edto1.setSalary(25000);

		edto1.setDepartmentParent(depdto);

		
		Set s=new HashSet();
		
		s.add(edto1);
		
		depdto.setEmployeeChild(s);
		
		
		
		sess.update(depdto);
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("New Record Inserted Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void Insert_SingleChild_MANY_TO_ONE(int DID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();

		
		DepartmentDTO depdto=(DepartmentDTO) sess.get(DepartmentDTO.class, DID);
		
		
		
													EmployeeDTO	edto=new EmployeeDTO();
		
													edto.setEid(208);
		
													edto.setFname("Ram");
		
													edto.setLname("Sharma");
		
													edto.setEmail("ram@gmail.com");
		
													edto.setMobile(777666000);
		
													edto.setSalary(12000);
		
													edto.setDepartmentParent(depdto);
		
													
		sess.save(edto);								
													
													
		Transaction ts=sess.beginTransaction();
		
		
		ts.commit();
		
		
		System.out.println("New Record Inserted Successfully");
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void Delete_Parent_ONE_TO_MANY(int DID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		DepartmentDTO depdto=(DepartmentDTO) sess.get(DepartmentDTO.class, DID);
		
		
		sess.delete(depdto);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("Deleted Successfully");
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	public static void Delete_Child_MANY_TO_ONE(int EID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		EmployeeDTO edto=(EmployeeDTO) sess.get(EmployeeDTO.class, EID);
		
		
		sess.delete(edto);
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		System.out.println("Deleted Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
//		Insert_ONE_TO_MANY();
	
		
//		Insert_MANY_TO_ONE();
	
		
//		Insert_SingleChild_ONE_TO_MANY(101);
	
		
//		Insert_SingleChild_MANY_TO_ONE(102);
	
		
		
//		Delete_Parent_ONE_TO_MANY(102);
	
		
//		Delete_Child_MANY_TO_ONE(207);
		
		
		
		
	}
	
	
	
}
