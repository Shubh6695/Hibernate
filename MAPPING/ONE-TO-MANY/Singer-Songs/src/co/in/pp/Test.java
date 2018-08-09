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
		
		
		SingerDTO singer=new SingerDTO();
		
		singer.setSid(1002);
		
		singer.setSname("Neha");
		
		singer.setSemail("neha@gmail.com");
		
		singer.setSmobile(999888777);
		
		singer.setSaddress("mumbai");
		

		
	/*										SongsDTO song1=new SongsDTO();
											
											song1.setSongid(101);
												
											song1.setSongname("Aaj Se Teri");
		
											song1.setSongmovie("Padman");
											
											song1.setSonglength(5.12f);
											
											
											
											SongsDTO song2=new SongsDTO();
											
											song2.setSongid(102);
												
											song2.setSongname("Tum Hi Ho");
		
											song2.setSongmovie("Aashiqui 2");
											
											song2.setSonglength(4.21f);
		
											
											SongsDTO song3=new SongsDTO();
											
											song3.setSongid(103);
												
											song3.setSongname("Naina");
		
											song3.setSongmovie("Dangel");
											
											song3.setSonglength(3.45f);
		
											
											
		Set s=new HashSet();
		
		s.add(song1);
		
		s.add(song2);
		
		s.add(song3);
		
		
		
		singer.setSingerChild(s);
*/		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(singer);
		
		ts.commit();
		
		System.out.println("Record Successfully Inserted");
		
		
		sess.close();
		
		sf.close();
		
		
		
	}
	
	
	public static void UpdateParent(int SingerID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess= sf.openSession();
		
		
		SingerDTO singer=(SingerDTO) sess.get(SingerDTO.class, SingerID);
		
		
		System.out.println("OLD Detail's");
		
		System.out.println(singer.getSid()+"\t"+singer.getSname()+"\t"+singer.getSemail()+"\t"+singer.getSaddress()+"\t"+singer.getSmobile());
		
		
		singer.setSaddress("Chennai");
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.update(singer);
		
		ts.commit();
		
		
		System.out.println("NEW Detail's");
		
		System.out.println(singer.getSid()+"\t"+singer.getSname()+"\t"+singer.getSemail()+"\t"+singer.getSaddress()+"\t"+singer.getSmobile());
		
		
		sess.close();
		
		sf.close();
		
		
		
		
	}
	
	
	
	public static void UpdateChild(int SongID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		
		Query q1=sess.createQuery("from SingerDTO");		

		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			SingerDTO singer=(SingerDTO) itr.next();
			
			
			Set s=singer.getSingerChild();
			
			
			if(!s.isEmpty())
			{
				
				SongsDTO song=(SongsDTO) sess.get(SongsDTO.class, SongID);
				
				
				song.setSongmovie("Padman");
				
				
				sess.update(singer);				
				
					
				
				Transaction ts=sess.beginTransaction();
				
				ts.commit();
				
				
				
				
			}
			
			
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	

	public static void DeleteALL(int SingerID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		SingerDTO singer=(SingerDTO) sess.get(SingerDTO.class, SingerID);
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.delete(singer);
		
		ts.commit();
		
		
		System.out.println("Record Deleted Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
//		InsertALL();
	
//		UpdateParent(1001);
	
		UpdateChild(101);
		
		
//		DeleteALL(1001);
	
		
		
		
		
	}
	
	
	
}
