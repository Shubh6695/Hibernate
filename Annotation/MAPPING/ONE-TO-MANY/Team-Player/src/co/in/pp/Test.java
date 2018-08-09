package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	public static void insertALL() throws Exception
	{
			
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		TeamDTO tdto=new TeamDTO();
		
		
		tdto.setTeamid(1001);
		
		tdto.setTeamname("Manchester United");
		
		tdto.setTeamcountry("Englend");
		
		tdto.setTeamsport("FootBall");
		
		
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

		
		Set s=new HashSet();
					
		s.add(pdto1);
		
		s.add(pdto2);
									
		s.add(pdto3);
		
		
		tdto.setPlayerChild(s);
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(tdto);
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void insertPlayerOnly(int TID) throws Exception
	{

		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		

		TeamDTO tdto=(TeamDTO) sess.get(TeamDTO.class, TID);
		
		
		PlayerDTO pdto=new PlayerDTO();
		
		pdto.setPid(5004);
		
		pdto.setPname("John");
		
		pdto.setPemail("john@gmail.com");
		
		pdto.setPaddress("Birmingham ");
		
		pdto.setPmobile(999944444);
		
		pdto.setPage(26);
		
		
		Set s=new HashSet();
		
		s.add(pdto);
		
		
		tdto.setPlayerChild(s);
		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.update(tdto);
		
		ts.commit();
		
		sess.close();
		
		sf.close();
	}
	
	
	public static void getALL() throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		Query q=sess.createQuery("from TeamDTO");
		
		
		List rows=q.list();
		
		Iterator itr1=rows.iterator();
		
		while(itr1.hasNext())
		{
			
			TeamDTO tdto=(TeamDTO) itr1.next();
			
			System.out.println(tdto.getTeamid()+"\t"+tdto.getTeamname()+"\t"+tdto.getTeamcountry()+"\t"+tdto.getTeamsport());
		
			Set s=tdto.getPlayerChild();
			
			Iterator itr2=s.iterator();
			
			while(itr2.hasNext())
			{
				
				PlayerDTO pdto=(PlayerDTO) itr2.next();
				
				System.out.println(pdto.getPid()+"\t"+pdto.getPname()+"\t"+pdto.getPemail()+"\t"+pdto.getPaddress()+"\t"+pdto.getPage()+"\t"+pdto.getPmobile());
				
			}
		
		
		}
		
		sess.close();
		
		sf.close();
	}
	
	
	public static void updatePlayer(int PID) throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		Query q=sess.createQuery("from TeamDTO");
		
		
		List rows=q.list();
		
		Iterator itr1=rows.iterator();
		
		while(itr1.hasNext())
		{
			
			TeamDTO tdto=(TeamDTO) itr1.next();
			
			System.out.println(tdto.getTeamid()+"\t"+tdto.getTeamname()+"\t"+tdto.getTeamcountry()+"\t"+tdto.getTeamsport());
		
			Set s=tdto.getPlayerChild();
			
			Iterator itr2=s.iterator();
			
			while(itr2.hasNext())
			{
				
				PlayerDTO pdto=(PlayerDTO) itr2.next();
				
				if(pdto.getPid() == PID)
				{
					pdto.setPaddress("Newcastle");
					
				}
				
				
				
			}


			
			Transaction ts=sess.beginTransaction();
		
			sess.update(tdto);
			
			ts.commit();
			
			System.out.println("Update Successfully");
			
			
			
		}
		
		sess.close();
		
		sf.close();
	}
	
	
	public static void deletePlayer(int PID)throws Exception
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		Query q=sess.createQuery("from TeamDTO");
		
		
		List rows=q.list();
		
		Iterator itr1=rows.iterator();
		
		while(itr1.hasNext())
		{
			
			TeamDTO tdto=(TeamDTO) itr1.next();
	
			
			Set s=tdto.getPlayerChild();
			
			Iterator itr2=s.iterator();
			
			while(itr2.hasNext())
			{
				
				PlayerDTO pdto=(PlayerDTO) itr2.next();
				
				if(pdto.getPid() == PID)
				{
					
					sess.delete(pdto);
					
				}
				
				
				
			}


			
			Transaction ts=sess.beginTransaction();
		
			sess.update(tdto);
			
			ts.commit();
			
			System.out.println("Delete Successfully");
			
			
			
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	insertALL();
		
	//	insertPlayerOnly(1001);
		
	//	getALL();
		
	//	updatePlayer(5001);
		
	//	deletePlayer(5003);															// Error
		
		
	}
	
}
