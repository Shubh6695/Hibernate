package co.in.MAIN;

import co.in.DTO.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class UpdateMain
{

	
	
	
	
	public static void updateBugListProjectBased() throws Exception
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
		
		boolean flag4=false; 
		
		Integer cusid=0;
		
		while(itr.hasNext())
		{
			
			LoginDTO ldto=(LoginDTO) itr.next();
			
			name=ldto.getCustomerParent().getFname();
			cusid=ldto.getCustomerParent().getCid();
			
			System.out.println(" \n \n Hello "+name);
			
			flag4=true;
		}

		
		if(flag4==true)
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
			
			
			Integer projectid=0;
			
			
			Iterator itr2=rows2.iterator();

			boolean flag1=false;
			
			while(itr2.hasNext())
			{
				
				ProjectDTO project=(ProjectDTO) itr2.next();
				
				if(project.getPname().equalsIgnoreCase(projectname))
				{
					
					projectid=project.getPid();
					
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
				
					if(flag2==true)
					{
						System.out.println("Insert Bug Name");
						
						String bugname=sc.nextLine();
						
						
						Criteria crit3=sess.createCriteria(BugDTO.class);
						
						Criterion c8= Restrictions.eq("bugname", bugname);
						
						Criterion c9= Restrictions.eq("projectid", projectid);
						
						Criterion c10= Restrictions.and(c8, c9);
						
						crit3.add(c10);
						
						List rows3=crit3.list();
						
						Iterator itr4=rows3.iterator();
						
						Integer bugid=0;
						
						boolean flag3=false;
						
						while(itr4.hasNext())
						{
							
							BugDTO bug=(BugDTO) itr4.next();
							
							System.out.println();
							
							System.out.println("OLD Data");
								
							bugid=bug.getBugid();
							
							System.out.println(bug.getBugname()+"\t"+bug.getBugdescription()+"\t"+bug.getBugstartdate()+"\t"+bug.getBugenddate());
							
							flag3=true;
							
						}

						if(flag3==true)
						{
							
							
							System.out.println(" \n Insert 1 for Update Bug Name \n");
							
							System.out.println(" Insert 2 for Update Bug Description \n");
							
							System.out.println(" Insert 3 for Update Bug End-Date");
							
							Integer choice=sc.nextInt();
							
							sc.nextLine();
							
							
							Criteria crit4=sess.createCriteria(BugDTO.class);
							
							Criterion c11= Restrictions.eq("bugid", bugid);
							
							Criterion c12= Restrictions.eq("bugname", bugname);
							
							Criterion c13= Restrictions.and(c11, c12);
							
							crit4.add(c13);

							List rows4=crit4.list();
							
							Iterator itr5=rows4.iterator();
							
							while(itr5.hasNext())
							{
								
							
							BugDTO bug=(BugDTO) itr5.next();	
							
							BugStatusDTO status= bug.getBugstatusChild();
							
							if(choice == 1)
							{
								
								System.out.println("Insert New Bug Name");
								
								String bname=sc.nextLine();
								
								bug.setBugname(bname);
								
								status.setBugname(bname);
								
							}
							
							if(choice == 2)
							{
								
								System.out.println("Insert New Bug Description");
								
								String bdescription=sc.nextLine();
								
								bug.setBugdescription(bdescription);
								
								
								
							}
							
							if(choice == 3)
							{
								
								System.out.println("Insert New Bug Date in (dd/mm/yyyy) Format");
								
								String benddate=sc.nextLine();
								
								SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

								Date end = dateFormat.parse(benddate);

								
								bug.setBugenddate(end);
								
								
							}
							
							
							sess.update(bug);
							
							ts.commit();
							
							System.out.println(" \n Update Successfully");
							
							}																									// while loop close itr4
						
							
							
							
						}
						
						else if(flag3== false)
						{
							
							System.out.println("\n \n Bug is Not FOUND");
							
						}
					}
					else if(flag2==false)
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
		
		}																						// If close of flag4
		else if(flag4==false)
		{
			System.out.println("You Have Insert Wrong User Id and Password");
			
		}


		sess.close();
		
		sf.close();

	}

	
	public static void updateProjectListCustomerBased() throws Exception
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
		
		boolean flag2=false;
		
		Integer cusid=0;
		
		while(itr.hasNext())
		{
			
			LoginDTO ldto=(LoginDTO) itr.next();
			
			name=ldto.getCustomerParent().getFname();
			cusid=ldto.getCustomerParent().getCid();
			
			System.out.println(" \n \n Hello "+name);
			
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
			
			
			Integer projectid=0;
			
			
			Iterator itr2=rows2.iterator();

			boolean flag1=false;
			
			while(itr2.hasNext())
			{
				
				ProjectDTO project=(ProjectDTO) itr2.next();
				
				if(project.getPname().equalsIgnoreCase(projectname))
				{
					
					projectid=project.getPid();
					
							
					flag1=true;
					
				}																				// If Loop Close.	
				
				
			}																					// While Loop End for itr2		

			if(flag1==true)
			{
				System.out.println("\n Insert 1 for Update Project Name \n");
				
				System.out.println("Insert 2 for Update Project Description \n");
				
				System.out.println("Insert 3 for Update Project End Date \n");
				
				Integer choice=sc.nextInt();
				
				sc.nextLine();
				
				Criteria crit3=sess.createCriteria(ProjectDTO.class);
				
				Criterion c8= Restrictions.eq("pid", projectid);
				
				Criterion c9= Restrictions.eq("pname", projectname);
				
				Criterion c10= Restrictions.and(c8, c9);
				
				crit3.add(c10);

				List rows3=crit3.list();
				
				Iterator itr3=rows3.iterator();
				
				while(itr3.hasNext())
				{
					
				
				ProjectDTO project=(ProjectDTO) itr3.next();	
				
				StatusDTO status= project.getStatusChild();
				
				
				
				if(choice == 1)
				{
					
					System.out.println("Insert New project Name");
					
					String projectnewname=sc.nextLine();
					
					project.setPname(projectnewname);
					
					status.setProjectname(projectnewname);
					
				}
				
				if(choice == 2)
				{
					
					System.out.println("Insert New Project Description ");
										
					String projectdescription=sc.nextLine(); 
					
					project.setDescription(projectdescription);
					
					
				}
				
				if(choice == 3)
				{
					System.out.println("Insert New Bug Date in (dd/mm/yyyy) Format");
					
					String penddate=sc.nextLine();
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					
					Date end = dateFormat.parse(penddate);

					project.setEnddate(end);
					
					
				}
				
				
				sess.update(project);
				
				ts.commit();
				
				System.out.println("Update Successfully ");
				
				}																			// Close While loop(itr3)		
				
				flag1=true;
			}
			
			else if(flag1==false)
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
		}																										// If close of flag2		
		
		else if(flag2==false)
		{
			System.out.println("You Have Insert Wrong User Id and Password");
			
		}


		sess.close();
		
		sf.close();

	}

	
	public static void updateEmployee() throws Exception
	{
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

		Transaction ts=sess.beginTransaction();
		
		Scanner sc=new Scanner(System.in);
		
		
		
		Query q=sess.createQuery("from TeamDTO");
		
		List rows=q.list();
		
		Iterator itr=rows.iterator();
		
		boolean flag=false;
		
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
		
		
			flag=true;
		}
		
		
		if(flag==true)
		{
			
			System.out.println("Insert Employee FIRST Name From The List");
			
			String fname=sc.nextLine();
			
			
			System.out.println("Insert Employee LAST Name From The List");
			
			String lname=sc.nextLine();
			
			System.out.println("Insert Employee ROLE From The List ");
			
			String role=sc.nextLine();
			
			System.out.println("Insert Employee TEAM ID From The List");
			
			Integer teamid=sc.nextInt();
			
			sc.nextLine();
			
			
			Criteria crit=sess.createCriteria(EmployeeDTO.class);
			
			Criterion c1= Restrictions.eq("fname",fname);
			
			Criterion c2= Restrictions.eq("lname",lname);
			
			Criterion c3= Restrictions.eq("role",role);
			
			Criterion c4= Restrictions.eq("tid",teamid);
			
			Criterion c5= Restrictions.and(c1, Restrictions.and(c2, Restrictions.and(c3, c4)));
			
			crit.add(c5);
			
			List rows1=crit.list();
			
			Iterator itr1=rows1.iterator();
			
			boolean flag1=false;
			
			while(itr1.hasNext())
			{
				
				
				EmployeeDTO emp=(EmployeeDTO) itr1.next();
				
				System.out.println("OLD DATA");
				
				System.out.println(emp.getEid()+"\t"+emp.getFname()+"\t"+emp.getLname()+"\t"+emp.getRole()+"\t"+emp.getTid());
				
				
				System.out.println("Insert Employee New FIRST Name");
				
				String nfname=sc.nextLine();
				
				System.out.println("Insert Employee New LAST Name");
				
				String nlname=sc.nextLine();
				
				
				System.out.println("Insert Employee New Email ");
				
				String nemail=sc.nextLine();
				
				
				System.out.println("Insert Employee New Role");
				
				String nrole=sc.nextLine();
				
				emp.setFname(nfname);
				
				emp.setLname(nlname);
				
				emp.setEmail(nemail);
				
				emp.setRole(nrole);
				
				sess.update(emp);
				
				ts.commit();

				System.out.println("Update Successfully ");
				
				flag1=true;
			}																								// While close(itr1)
			
			if(flag1==false)
			{
				
				System.out.println("Record NOT FOUND");
				
			}
			
		}																									// If close of flag	
		
		else if(flag==false)
		{
			
			System.out.println("You Don't Have Any Team");
		}
		
		sess.close();

		sf.close();
		
		
	}
	
	
	public static void forgetPassword() throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		Transaction ts=sess.beginTransaction();
		
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Insert Email Id");
		
		String email=sc.nextLine();
		
		
		System.out.println("Insert Alternate Password");
		
		String alt=sc.nextLine();
		
		
		Criteria crit=sess.createCriteria(LoginDTO.class);
		
		Criterion c1=Restrictions.eq("loginemail", email);
		
		Criterion c2=Restrictions.eq("altenatepassword", alt);
		
		Criterion c3=Restrictions.and(c1, c2);
		
		crit.add(c3);
		
		
		List rows=crit.list();
		
		Iterator itr=rows.iterator();
		
		boolean flag=false;
		
		Integer loginid=0;
		
		while(itr.hasNext())
		{
			
			LoginDTO login=(LoginDTO) itr.next();
			
			loginid=login.getId();
			
			flag=true;
		}
		
		if(flag== true)
		{
			
			System.out.println("Insert NEW Password");
			
			String n1=sc.nextLine();
			
			
			System.out.println("Confirm New Password");
			
			String n2=sc.nextLine();
			
			if(n1.equals(n2))
			{
				
				LoginDTO login=(LoginDTO) sess.get(LoginDTO.class, loginid);
				
				login.setPassword(n2);
				
				sess.update(login);
				
				ts.commit();
				
				System.out.println("\n Password Update Successfully");
				
							
			}
			else
			{
				
				System.out.println("\n \n Both Password is NOT Matched.");
			}
			
		}
		else if(flag== false)
		{
			System.out.println(" \n \n Email Id and Alternate Password is NOT Matched. ");
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
}
