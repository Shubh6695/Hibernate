package co.in.pp;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class Test 
{

	
	public static void getALL() 
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		Query q=sess.createQuery("from DepartmentDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			DepartmentDTO dep=(DepartmentDTO)itr.next();
			
			System.out.println("DepartMent Information \n");
			
			System.out.println(dep.getDepid()+"\t"+dep.getDepname()+"\n");
			
			System.out.println("Employree Information \n");
			
			Set s=dep.getEmpolyeeChild();
			
			Iterator itr2=s.iterator();
			
			while(itr2.hasNext())
			{
				
				EmployeeDTO emp=(EmployeeDTO)itr2.next();
				
				
				System.out.println(emp.getEid()+"\t"+emp.getFname()+"\t"+emp.getLname()+"\t"+emp.getEmail()+"\t"+emp.getMobile()+"\t"+emp.getSalary()+"\t"+emp.getDid());
				
			}
			
		}
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void main(String[] args)
	{
		
		getALL();
		
	}
	
	
}
