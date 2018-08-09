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
		
		
		SingerDTO singer1=new SingerDTO();
		
		singer1.setSid(1001);
		
		singer1.setSname("Arijit Singh");
		
		singer1.setSemail("arijit@gmail.com");
		
		singer1.setSaddress("Chennai");
		
		singer1.setSmobile(999888777);
		
		
		
		SingerDTO singer2=new SingerDTO();
		
		singer2.setSid(1002);
		
		singer2.setSname("Neha Kakkar");
		
		singer2.setSemail("neha@gmail.com");
		
		singer2.setSaddress("Mumbai");
		
		singer2.setSmobile(999666333);
		
		
		
		
		
																				SongsDTO song1=new SongsDTO();		
		
																				song1.setSongid(101);
																				
																				song1.setSongname("Aaj Se Teri");
																				
																				song1.setSongmovie("Padman");
																				
																				song1.setSonglength(5.12f);
																				
																				
																				
																				
																				SongsDTO song2=new SongsDTO();
																				
																				song2.setSongid(102);
																				
																				song2.setSongname("Tum hi ho");
																				
																				song2.setSongmovie("Aashiqui 2");
																				
																				song2.setSonglength(4.21f);
																				
		
		
																				SongsDTO song3=new SongsDTO();
																				
																				song3.setSongid(103);
																				
																				song3.setSongname("Naina");
																				
																				song3.setSongmovie("Dangel");
																				
																				song3.setSonglength(3.45f);
																				
			
					Set s=new HashSet();
					
					s.add(singer1);
					
					s.add(singer2);
					
					
					song1.setSingerParent(s);
					
					song2.setSingerParent(s);
					
					song3.setSingerParent(s);
					
					
					
					Transaction ts=sess.beginTransaction();
					
					
					sess.save(song1);
																				
					sess.save(song2);
					
					sess.save(song3);
					
					ts.commit();
					
					System.out.println("Insert Successfully");
					
					
					sess.close();
					
					sf.close();
					
					
	}
	
	
	public static void Delete_ONE_TO_MANY1(int SingerID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		SingerDTO singer=(SingerDTO) sess.get(SingerDTO.class, SingerID);
		
		
	
		Transaction ts=sess.beginTransaction();
		
		sess.delete(singer);
		
		ts.commit();
		
		System.out.println("Deleted ALL Record");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void Delete_ONE_TO_MANY2(int SongID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		SongsDTO song=(SongsDTO) sess.get(SongsDTO.class, SongID);
		
		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.delete(song);
		
		ts.commit();
		
		System.out.println("Deleted ALL Record");
		
		
		sess.close();
		
		
		sf.close();
		
		
	}
	
	
	
	public static void Update_Parent_ONE_TO_MANY1(int SingerID1 , int SingerID2) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory(); 
		
		
		Session sess=sf.openSession();
				
		
		Query q=sess.createQuery("from SongsDTO");		
		
		
		List rows=q.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			SongsDTO song=(SongsDTO) itr.next();
			
			
			Set s=song.getSingerParent();
			
			while(!s.isEmpty())
			{
				
				SingerDTO singer1=(SingerDTO) sess.get(SingerDTO.class, SingerID1);
				
				singer1.setSaddress("Banglore");
				
				
				SingerDTO singer2=(SingerDTO) sess.get(SingerDTO.class, SingerID2);
				
				singer2.setSaddress("Dehradun");

				
				break;
				
			}
					
			
		sess.update(song);	

		}
		
		Transaction ts=sess.beginTransaction();

		ts.commit();
		
		
		System.out.println("Update Successfully");
		
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	Insert_ONE_TO_MANY();
		
		
	//	Delete_ONE_TO_MANY1(1001);					// Delete from Singer End
		
		
	//	Delete_ONE_TO_MANY2(101);					// Delete from Song End
		
		
	//	Update_Parent_ONE_TO_MANY1(1001, 1002);			// Update Parent from Child End (Song-to-Singer) 
		
		
		
	}
	
}
