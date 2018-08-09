package co.in.MAIN;

import co.in.DTO.*;

import java.text.SimpleDateFormat;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


public class GetMain 
{
	
	
	public static void getALLCustomer() throws Exception
	{
		
		
		AnnotationConfiguration cfg=new  AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

		
		Query q=sess.createQuery("from CustomerDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			CustomerDTO customer=(CustomerDTO) itr.next();
			
			
			
			System.out.println(customer.getCid()+"\t"+customer.getFname()+"\t"+customer.getLname()+"\t"+customer.getEmail()+"\t"+customer.getGender()+"\t"+customer.getDateofbirth()+"\t"+customer.getAddress()+"\t"+customer.getMobile()+"\n");
			
			
			
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void getProjectListCustomerBased() throws Exception
	{
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		
			Scanner sc=new Scanner(System.in);
			
		//	sc.nextLine();
			System.out.println("Insert Login Email Id");
			
			String email=sc.nextLine();
			
			System.out.println("Insert Password");
			
			String pass=sc.nextLine();
			
			
			Criteria crit=sess.createCriteria(LoginDTO.class);
			
			Criterion c1= Restrictions.eq("loginemail", email);
			
			Criterion c2= Restrictions.eq("password", pass);
			
			Criterion c3= Restrictions.and(c1, c2);			
			
			crit.add(c3);
			
			
			List rows=crit.list();
			
			Iterator itr=rows.iterator();
			
			String name=null;
			
			boolean flag1=false;
			
			Integer cusid=0;
			
			while(itr.hasNext())
			{
				
				LoginDTO ldto=(LoginDTO) itr.next();
				
				name=ldto.getCustomerParent().getFname();
				cusid=ldto.getCustomerParent().getCid();
				
				System.out.println("Hello "+name);
				
				flag1=true;

			}
			

			if(flag1==true)
			{
				
		
			Criteria crit1=sess.createCriteria(ProjectDTO.class);
			
			Criterion c4= Restrictions.eq("cusid", cusid);
			
			crit1.add(c4);
			
			List rows1=crit1.list();
			
			Iterator itr1=rows1.iterator();

			System.out.println(" \n Your Project List \n");
		
			int count =1;
			
			boolean flag=false;
			
			while(itr1.hasNext())
			{
				
				ProjectDTO project=(ProjectDTO) itr1.next();
				
				System.out.println(count+"\t"+project.getPname()+"\n");
				
				count++;
				
				flag=true;
			}
		
			
			if(flag== false)
			{
				System.out.println("\n\n YOU Have NO Project \n");

				
			}
			
			}																												// If Close flag1	
			
			else if(flag1==false)
			{
				System.out.println("You Have Insert Wrong User Id and Password");
				
			}
			
			
		sess.close();
		
		sf.close();
			
	}

	
	public static void getBugListProjectBased() throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		Transaction ts=sess.beginTransaction();
		
		
		Scanner sc=new Scanner(System.in);

		System.out.println("Insert Login Email Id");
		
		String email=sc.nextLine();
		
		System.out.println("Insert Password");
		
		String pass=sc.nextLine();
		
		
		Criteria crit=sess.createCriteria(LoginDTO.class);
		
		Criterion c1= Restrictions.eq("loginemail", email);
		
		Criterion c2= Restrictions.eq("password", pass);
		
		Criterion c3= Restrictions.and(c1, c2);			
		
		crit.add(c3);
		
		
		List rows=crit.list();
		
		Iterator itr=rows.iterator();
		
		String name=null;
		
		boolean flag3=false;
		
		Integer cusid=0;
		
		while(itr.hasNext())
		{
			
			LoginDTO ldto=(LoginDTO) itr.next();
			
			name=ldto.getCustomerParent().getFname();
			cusid=ldto.getCustomerParent().getCid();
			
			System.out.println(" \n \n Hello "+name);
			
			flag3=true;
		}

		
		if(flag3==true)
		{
			
		Criteria crit1=sess.createCriteria(ProjectDTO.class);
		
		Criterion c4= Restrictions.eq("cusid", cusid);
		
		crit1.add(c4);
		
		List rows1=crit1.list();
		
		Iterator itr1=rows1.iterator();

		System.out.println(" \n Your Project List \n");
	
		Integer count =1;
		
		boolean flag=false;
		
		while(itr1.hasNext())
		{
			
			ProjectDTO project=(ProjectDTO) itr1.next();
			
			if(project.getCusid().equals(cusid))
			{
	
								
				System.out.println(count+"\t"+project.getPname());
				
				
				count++;

				flag =true;
				
			}
			
				
			
			
		}


		if(flag==true)
		{
			
			System.out.println("Insert Project Name from the Above List");	
			
			String projectname=sc.nextLine();

			
			Criteria crit2=sess.createCriteria(ProjectDTO.class);
			
			Criterion c5= Restrictions.eq("pname", projectname);
			
			Criterion c6= Restrictions.eq("cusid", cusid);
			
			Criterion c7= Restrictions.and(c5, c6);
			
			crit2.add(c7);
			
			List rows2=crit2.list();
			
		//	System.out.println("Row size :- "+rows2.size());
			
			Iterator itr2=rows2.iterator();

			boolean flag1=false;
			
			while(itr2.hasNext())
			{
				
				ProjectDTO project=(ProjectDTO) itr2.next();
				
				if(project.getPname().equalsIgnoreCase(projectname))
				{
					
					Set s=project.getBugChild();
					
					Iterator itr3=s.iterator();
					
					Integer count1=1;
					
					boolean flag2=false;
					
					while(itr3.hasNext())
					{
						
						BugDTO bug=(BugDTO) itr3.next();
						
						System.out.println(count1+"\t"+bug.getBugname()+"\t"+bug.getBugdescription()+"\t"+bug.getBugstartdate()+"\t"+bug.getBugenddate());
					
						count1++;
						
						flag2=true;
					}
				
					
					if(flag2==false)
					{
						
						System.out.println(" \n You Don't have Any Bug ");
					}
							
					flag1=true;
					
				}																				// If Loop Close.	
				
				
			}																					// While Loop End for itr2		

			
			if(flag1==false)
			{
				
				System.out.println(" \n \n Project Name is Wrong \n ");
				
				System.out.println("Insert Correct Project Name ");
				
			}

			
			
		}																						// If close of flag(Project available)
		else if (flag==false)
		{
			
				System.out.println("\n\n YOU Have NO Project \n");
		
				System.out.println("Insert Project First \n");

		}
		
		}																						// If close of flag3
		
		else if(flag3==false)
		{
				System.out.println("You Have Insert Wrong User Id and Password");
				
		}
		sess.close();
		
		sf.close();

	}
	
	
	public static void getALLInformationOfCustomer() throws Exception
	{
	
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		
			Scanner sc=new Scanner(System.in);
			
		//	sc.nextLine();
			System.out.println("Insert Login Email Id");
			
			String email=sc.nextLine();
			
			System.out.println("Insert Password");
			
			String pass=sc.nextLine();
			
			
			Criteria crit=sess.createCriteria(LoginDTO.class);
			
			Criterion c1= Restrictions.eq("loginemail", email);
			
			Criterion c2= Restrictions.eq("password", pass);
			
			Criterion c3= Restrictions.and(c1, c2);			
			
			crit.add(c3);
			
			
			List rows=crit.list();
			
			Iterator itr=rows.iterator();
			
			String name=null;
			
			boolean flag2=false;
			
			Integer cusid=0;
			
			while(itr.hasNext())
			{
				
				LoginDTO ldto=(LoginDTO) itr.next();
				
				name=ldto.getCustomerParent().getFname();
				cusid=ldto.getCustomerParent().getCid();
				
				System.out.println("Hello "+name);
				
				flag2=true;
				
			}
			

			if(flag2==true)
			{
			
			Criteria crit1=sess.createCriteria(ProjectDTO.class);
			
			Criterion c4= Restrictions.eq("cusid", cusid);
			
			crit1.add(c4);
			
			List rows1=crit1.list();
			
			Iterator itr1=rows1.iterator();

			System.out.println(" \n Your Project List \n");
		
			int count =1;
			
			boolean flag=false;
			
			while(itr1.hasNext())
			{
				
				ProjectDTO project=(ProjectDTO) itr1.next();
				
				System.out.println(count+"\t"+project.getPname()+"\n");
				
				Set s=project.getBugChild();
				
				Iterator itr2=s.iterator();
				
				int count1=1;
				
				boolean flag1=false;
				
				while(itr2.hasNext())
				{
				
					BugDTO bug=(BugDTO) itr2.next();
					
					BugStatusDTO status=bug.getBugstatusChild();
					
					System.out.println(count1+"\t"+bug.getBugname()+"\t"+bug.getBugdescription()+"\t"+bug.getBugstartdate()+"\t"+bug.getBugenddate()+"\t"+status.getStatus());
				
					count1++;
					
					flag1=true;
					
				}
				
				
				if(flag1==false)
				{
					
					System.out.println(" \n You Don't have Any Bug ");
					
				}
				
				count++;
				
				flag=true;
			}
		
			
			if(flag== false)
			{
				System.out.println("\n\n YOU Have NO Project \n");

				
			}
			
			}																									// If close flag2
			
			else if(flag2==false)
			{
				System.out.println("You Have Insert Wrong User Id and Password");
				
			}

			
			
		sess.close();
		
		sf.close();

		
	}
	
	
	public static void getALLTeam() throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

		
		Query q=sess.createQuery("from TeamDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		int count=1;
		
		while(itr.hasNext())
		{
			
			TeamDTO team=(TeamDTO) itr.next();
			
			System.out.println(count+"\t"+team.getTeamname()+"\t"+team.getTeamleadname()+"\n");
			
			count++;
		}
		
		sess.close();
		
		sf.close();
	}
	
	
	public static void getALLTeamWithEmployee() throws Exception
	{
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

		
		Query q=sess.createQuery("from TeamDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		int count=1;
		
		while(itr.hasNext())
		{
			System.out.println("Team Information");
			
			TeamDTO team=(TeamDTO) itr.next();
			
			System.out.println(count+"\t"+team.getTeamname()+"\t"+team.getTeamleadname()+"\n");
			
			count++;
			
			Set s=team.getEmployeeChild();
			
			Iterator itr1=s.iterator();
			
			int count1=1;
			
			System.out.println("Employee's Information");
			
			while(itr1.hasNext())
			{
				EmployeeDTO emp=(EmployeeDTO) itr1.next();
				
				System.out.println(count1+"\t"+emp.getFname()+"\t"+emp.getLname()+"\t"+emp.getRole()+"\t"+emp.getTid());
				
				count1++;
			}
		}
		
		sess.close();

		sf.close();
		
		
	}

	
	
	
	
}
