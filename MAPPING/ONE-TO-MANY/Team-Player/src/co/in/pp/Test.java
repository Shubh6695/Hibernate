package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;	


public class Test 
{

	public static void InsertALL() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		TeamDTO tdto=new TeamDTO();
		
		
		tdto.setTeamid(1002);
		
		tdto.setTeamname("Manchester United");
		
		tdto.setTeamcountry("Englend");
		
		tdto.setTeamsport("FootBall");
		
		
									PlayerDTO pdto1=new PlayerDTO();
									
									pdto1.setPid(5004);
									
									pdto1.setPname("David Backham");
		
									pdto1.setPemail("david@gmail.com");
									
									pdto1.setPaddress("LONDON");
									
									pdto1.setPmobile(999911111);
									
									pdto1.setPage(38);
									
									

									PlayerDTO pdto2=new PlayerDTO();
									
									pdto2.setPid(5005);
									
									pdto2.setPname("Shaun Marsh");
		
									pdto2.setPemail("shaun@gmail.com");
									
									pdto2.setPaddress("LORDS");
									
									pdto2.setPmobile(999922222);
									
									pdto2.setPage(27);

									
									PlayerDTO pdto3=new PlayerDTO();
									
									pdto3.setPid(5006);
									
									pdto3.setPname("Chirs Rabada");
		
									pdto3.setPemail("chris@gmail.com");
									
									pdto3.setPaddress("OVEL");
									
									pdto3.setPmobile(999933333);
									
									pdto3.setPage(32);

									
			
		Set s= new HashSet();
		
		
		s.add(pdto1);
		
		s.add(pdto2);
		
		s.add(pdto3);
									
	
		tdto.setTeamChild(s);
		
							
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(tdto);
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		
		sf.close();
		
									
	}
	
	
	
	public static void GetALL() throws Exception
	{
		
	
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from TeamDTO");
		
		
		List rows=q1.list();
		
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			TeamDTO tdto1=(TeamDTO) itr.next();
			
			
			
		
		//	System.out.println(tdto1.getTeamid()+"\t"+tdto1.getTeamname()+"\t"+tdto1.getTeamsport()+"\t"+tdto1.getTeamcountry());
			
		//	System.out.println();
			
			
			System.out.println(tdto1.getTeamname()+" Player List"+"\n");
			
			
			Set s=tdto1.getTeamChild();
			

			Iterator itr1=s.iterator();
			
			while(itr1.hasNext())
			{
				
				PlayerDTO pdto=(PlayerDTO) itr1.next();
				
				System.out.println(tdto1.getTeamname()+"\t"+tdto1.getTeamcountry()+"\t"+pdto.getPid()+"\t"+pdto.getPname()+"\t"+pdto.getPemail()+"\t"+pdto.getPaddress()+"\t"+pdto.getPmobile()+"\t"+pdto.getPage());
				
				
				System.out.println();
				
				
			}
			
		}
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	
	public static void GetSpecificTeam(int TID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		TeamDTO tdto1=(TeamDTO) sess.get(TeamDTO.class, TID);
		
		
		System.out.println(tdto1.getTeamname()+"Player List \n");
		
		
		
		Set s=tdto1.getTeamChild();
		
		
		Iterator itr=s.iterator();
		
		
		while(itr.hasNext())
		{
			
			PlayerDTO pdto=(PlayerDTO) itr.next();
			
			
			System.out.println(pdto.getPid()+"\t"+pdto.getPname()+"\t"+pdto.getPemail()+"\t"+pdto.getPaddress()+"\t"+pdto.getPmobile()+"\t"+pdto.getPage());
			
			
			System.out.println();

			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		
	//	InsertALL();
		
		
	//	GetALL();
		
		
	//	GetSpecificTeam(1001);
		
		
	}
	
	
}
