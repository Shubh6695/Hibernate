package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test 
{

	public static void insertALL() throws Exception
	{
		
		
		AnnotationConfiguration cfg= new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		TeamDTO tdto=new TeamDTO();
		
		tdto.setTeamid(1001);
		
		tdto.setTeamname("Manchester United");
		
		tdto.setTeamcountry("Englend");
		
		tdto.setTeamsport("Football");
		
	
		
		PlayerDTO pdto1=new PlayerDTO();
		
		pdto1.setPid(5004);
		
		pdto1.setPname("David Backham");

		pdto1.setPemail("david@gmail.com");
		
		pdto1.setPaddress("LONDON");
		
		pdto1.setPmobile(999911111);
		
		pdto1.setPage(38);
		
		pdto1.setTeamParent(tdto);
		
		

		PlayerDTO pdto2=new PlayerDTO();
		
		pdto2.setPid(5005);
		
		pdto2.setPname("Shaun Marsh");

		pdto2.setPemail("shaun@gmail.com");
		
		pdto2.setPaddress("LORDS");
		
		pdto2.setPmobile(999922222);
		
		pdto2.setPage(27);

		pdto2.setTeamParent(tdto);
		
		
		PlayerDTO pdto3=new PlayerDTO();
		
		pdto3.setPid(5006);
		
		pdto3.setPname("Chirs Rabada");

		pdto3.setPemail("chris@gmail.com");
		
		pdto3.setPaddress("OVEL");
		
		pdto3.setPmobile(999933333);
		
		pdto3.setPage(32);

		pdto3.setTeamParent(tdto);
		
		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(pdto1);
		
		sess.save(pdto2);
		
		sess.save(pdto3);
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void getALL() throws Exception
	{
		
		AnnotationConfiguration cfg= new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

		
		Query q=sess.createQuery("from PlayerDTO"); 
		
		List rows=q.list();
		
		Iterator itr1=rows.iterator();
		
			while(itr1.hasNext())	
			{
				PlayerDTO pdto=(PlayerDTO) itr1.next();
		
				TeamDTO tdto=pdto.getTeamParent();
				
				
				
			}	
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	insertALL();
		
		getALL();
		
		
	}
	
	
}
