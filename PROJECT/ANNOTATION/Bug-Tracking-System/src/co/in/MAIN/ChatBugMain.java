package co.in.MAIN;

import co.in.DTO.*;

import java.text.SimpleDateFormat;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class ChatBugMain 
{
	
	
	public static void insertMessagefromCustomer() throws Exception
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
			
			Integer pid=0;
			
			while(itr2.hasNext())
			{
				
				ProjectDTO project=(ProjectDTO) itr2.next();
				
				if(project.getPname().equalsIgnoreCase(projectname))
				{
					
					pid=project.getPid();
					
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

			
			if(flag==true)
			{
				
				System.out.println("Insert Bug Name from the Above List");
				
				String bname=sc.nextLine();
				
				
				Criteria crit3=sess.createCriteria(BugDTO.class);
				
				Criterion c8= Restrictions.eq("bugname", bname);
				
				Criterion c9= Restrictions.eq("projectid", pid);
				
				Criterion c10= Restrictions.and(c8, c9);
				
				crit3.add(c10);
				
				List rows3=crit3.list();
				
				Iterator itr3=rows3.iterator();
				
				boolean flag4=false;
				
				Integer bugid=0;
				
				while(itr3.hasNext())
				{
					
					BugDTO bug=(BugDTO) itr3.next();
					
					bugid=bug.getBugid();
					
					flag4=true;
					
				}
				
				
				if(flag4==true)
				{
					
					Criteria crit4=sess.createCriteria(BugStatusDTO.class);
					
					Criterion c11=Restrictions.eq("sid", bugid);
					
					Criterion c12=Restrictions.eq("bugname", bname);
					
					Criterion c13=Restrictions.and(c11, c12);
					
					crit4.add(c13);
					
					List rows4=crit4.list();
					
					Iterator itr4=rows4.iterator();
					
					boolean flag5=false;
					
					Integer eid=0;
					
					while(itr4.hasNext())
					{
						
						BugStatusDTO bstatus=(BugStatusDTO) itr4.next();
						
						eid=bstatus.getEid();
						
						flag5=true;
						
					}
					
					if(flag5==true)
					{
						
						EmployeeDTO emp=(EmployeeDTO) sess.get(EmployeeDTO.class, eid);
						
						BugDTO bug=(BugDTO) sess.get(BugDTO.class, bugid);
						
						CustomerDTO cust=(CustomerDTO) sess.get(CustomerDTO.class, cusid);
						
						
						String empemail=emp.getEmail();
						
						
						System.out.println("\n \n Insert Message to Employee \n");
						
						System.out.println("\n From  "+email);
						
						System.out.println("\n To  "+empemail);
						
						
						System.out.println("\n Insert Message ");
						
						String message=sc.nextLine();
						
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						
						Date msgtime= dateFormat.parse(dateFormat.format(new Date()));										// Insert Current Date and Time
						
						
						
						ChatBugDTO chat=new ChatBugDTO();
						
						chat.setMessage(message);
						
						chat.setMessagetime(msgtime);
						
						chat.setSender("Customer");
						
						chat.setEmployeeChild(emp);
						
						chat.setCustomerChild(cust);
						
						chat.setBugChild(bug);
						
						
						sess.save(chat);
						
						ts.commit();
						
						System.out.println(" \n Message Sucessfully Send");
						
					}
					
					else if(flag5== false)
					{
						System.out.println("\n NO Employee is Assign to Your Bug ");
						
					}
				}
				
				else if(flag4== false)
				{
					System.out.println("\n Bug Name is NOT FOUND");
					
				}
				
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
		
		}																						// If close of flag3
		
		else if(flag3==false)
		{
				System.out.println("You Have Insert Wrong User Id and Password");
				
		}
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void insertMessageFromEmployee() throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		Transaction ts=sess.beginTransaction();

		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Insert Employee Email ");
		
		String empemail=sc.nextLine();
		
		System.out.println("Insert Team Name ");
		
		String teamname=sc.nextLine();
		
	

		Criteria crit=sess.createCriteria(TeamDTO.class);
		
		Criterion c1=Restrictions.eq("teamname", teamname);
		
		crit.add(c1);
		
		
		List rows=crit.list();
		
		Iterator itr=rows.iterator();
		
		boolean flag=false;
		
		Integer teamid=0;
		
		while(itr.hasNext())
		{
			
			TeamDTO team=(TeamDTO) itr.next();
			
			teamid=team.getTeamid();
			
			flag=true;
		}
		
		
		if(flag== true)
		{
			
			Criteria crit1=sess.createCriteria(EmployeeDTO.class);
			
			Criterion c2=Restrictions.eq("email", empemail);
			
			Criterion c3=Restrictions.eq("tid", teamid);
			
			Criterion c4=Restrictions.and(c2, c3);
			
			crit1.add(c4);
			
			List rows1=crit1.list();
			
			Iterator itr1=rows1.iterator();
			
			boolean flag1=false;
			
			
			Integer empid=0;
			
			while(itr1.hasNext())
			{
				
				EmployeeDTO emp=(EmployeeDTO) itr1.next();
				
				empid=emp.getEid();
				
				flag1=true;
			}
			
			if(flag1== true)
			{
				
				
				Criteria crit2=sess.createCriteria(BugStatusDTO.class);
				
				Criterion c5=Restrictions.eq("eid", empid);
				
				crit2.add(c5);

				List rows2=crit2.list();
				
				Iterator itr2=rows2.iterator();
				
				boolean flag2=false;
				
				Integer bugid=0;
				
				while(itr2.hasNext())
				{
					
					BugStatusDTO bug=(BugStatusDTO) itr2.next();
					
					bugid=bug.getSid();
					
					flag2=true;
					
				}
				
				if(flag2== true)
				{
					
					EmployeeDTO emp=(EmployeeDTO) sess.get(EmployeeDTO.class, empid);
					
					
					BugDTO bug=(BugDTO) sess.get(BugDTO.class, bugid);
					
					Integer pid=bug.getProjectid();
					
					ProjectDTO project=(ProjectDTO) sess.get(ProjectDTO.class, pid);
					
					Integer cid=project.getCusid();
					
					CustomerDTO cust=(CustomerDTO) sess.get(CustomerDTO.class, cid);
					
					String cemail=cust.getEmail();
					
					
					
					
					
					System.out.println("\n \n Insert Message to Employee \n");
					
					System.out.println("\n From  "+empemail);
					
					System.out.println("\n To  "+cemail);
					
					
					System.out.println("\n Insert Message ");
					
					String message=sc.nextLine();
					
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					
					Date msgtime= dateFormat.parse(dateFormat.format(new Date()));										// Insert Current Date and Time
					
					
					
					
					
					ChatBugDTO chat=new ChatBugDTO();
					
					chat.setMessage(message);
					
					chat.setMessagetime(msgtime);
					
					chat.setSender("Employee");
					
					chat.setEmployeeChild(emp);
					
					chat.setCustomerChild(cust);
					
					chat.setBugChild(bug);
					
					
					sess.save(chat);
					
					ts.commit();
					
					System.out.println(" \n Message Sucessfully Send");
					
					
					
					
					
				}
				
				else if(flag2== false)
				{
					
					System.out.println("Employee Not in Your Team");
				}
			}
			else if(flag1== false)
			{
				
				System.out.println(" \n Employee Name is NOT in YOUR Team");
			}
		}
		else if(flag== false)
		{
			
			System.out.println("\n \n Team Name is NOT Available");
			
		}
	}
	
	

}
