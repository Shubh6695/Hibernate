package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test 
{
	
	public static void Insert_ONE_TO_MANY() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		TeamDTO tdto1=new TeamDTO();
		
		
		tdto1.setTeamid(1001);
		
		tdto1.setTeamname("Manchester United");
		
		tdto1.setTeamcountry("Englend");
		
		tdto1.setTeamsport("FootBall");
		
		
		TeamDTO tdto2=new TeamDTO();
		
		
		tdto2.setTeamid(1002);
		
		tdto2.setTeamname("Mumbai Indians");
		
		tdto2.setTeamcountry("India");
		
		tdto2.setTeamsport("Cricket");
		
		

									PlayerDTO pdto1=new PlayerDTO();
									
									pdto1.setPid(5001);
									
									pdto1.setPname("David Backham");
		
									pdto1.setPemail("david@gmail.com");
									
									pdto1.setPaddress("LONDON");
									
									pdto1.setPmobile(999911111);
									
									pdto1.setPage(38);
									
									

									PlayerDTO pdto2=new PlayerDTO();
									
									pdto2.setPid(5002);
									
									pdto2.setPname("Shaun Marsh");
		
									pdto2.setPemail("shaun@gmail.com");
									
									pdto2.setPaddress("LORDS");
									
									pdto2.setPmobile(999922222);
									
									pdto2.setPage(27);

									
									PlayerDTO pdto3=new PlayerDTO();
									
									pdto3.setPid(5003);
									
									pdto3.setPname("Chirs Rabada");
		
									pdto3.setPemail("chris@gmail.com");
									
									pdto3.setPaddress("OVEL");
									
									pdto3.setPmobile(999933333);
									
									pdto3.setPage(32);

									
			
		Set s= new HashSet();
		
		
		s.add(pdto1);
		
		s.add(pdto2);
		
		s.add(pdto3);
									

		
		tdto1.setPlayerChild(s);
		
		tdto2.setPlayerChild(s);
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(tdto1);
		
		sess.save(tdto2);
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void GET_PARENT_MANY_TO_ONE(int PID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from PlayerDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			PlayerDTO pdto=(PlayerDTO) itr.next();
			
			Set s=pdto.getTeamParent();
			
			Iterator itr1=s.iterator();
			
			while(itr1.hasNext())
			{
				
				TeamDTO tdto1=(TeamDTO) itr1.next();
				
				System.out.println(tdto1.getTeamid()+"\t"+tdto1.getTeamname()+"\t"+tdto1.getTeamcountry()+"\t"+tdto1.getTeamsport());
				
				System.out.println();
				
			}
			
			
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	public static void Update_PARENT_MANY_TO_ONE(int TID1, int TID2) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from PlayerDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			PlayerDTO pdto=(PlayerDTO) itr.next();
			
			Set s=pdto.getTeamParent();
			
			Iterator itr1=s.iterator();
			
			while(itr1.hasNext())
			{
				
				TeamDTO tdto1=(TeamDTO) sess.get(TeamDTO.class, TID1);
				
				System.out.println(tdto1.getTeamid()+"\t"+tdto1.getTeamname()+"\t"+tdto1.getTeamcountry()+"\t"+tdto1.getTeamsport());
				
				tdto1.setTeamsport("Football");

				
				
				TeamDTO tdto2=(TeamDTO) sess.get(TeamDTO.class, TID2);
				
				System.out.println(tdto2.getTeamid()+"\t"+tdto2.getTeamname()+"\t"+tdto2.getTeamcountry()+"\t"+tdto2.getTeamsport());
				
				tdto2.setTeamname("Mumbai Indians");
				
				sess.update(pdto);
				
				Transaction ts=sess.beginTransaction();
				
				ts.commit();
				
				
				System.out.println("Update Successfully");
				
				break;
				
			}
			
			
			
		}
		
		
		
		
		
		
		
		sess.close();
		
		sf.close();
		
	}

	
	

	public static void main(String[] args)throws Exception
	{
		
	//	Insert_ONE_TO_MANY();
		
		
	//	GET_PARENT_MANY_TO_ONE(5001);
		
		
	//	Update_PARENT_MANY_TO_ONE(1001, 1002);
		
		
	}
	
	
	
	
}
