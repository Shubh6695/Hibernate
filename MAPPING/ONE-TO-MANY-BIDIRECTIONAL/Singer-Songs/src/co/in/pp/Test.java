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
		
		
		SingerDTO singer=new SingerDTO();
		
		singer.setSid(1001);
		
		singer.setSname("Arijit Singh");
		
		singer.setSemail("arijit@gmail.com");
		
		singer.setSmobile(999888777);
		
		singer.setSaddress("Chennai");
		

		
											SongsDTO song1=new SongsDTO();
											
											song1.setSongid(101);
												
											song1.setSongname("Aaj Se Teri");
		
											song1.setSongmovie("Padman");
											
											song1.setSonglength(5.12f);
											
											song1.setSingerParent(singer);
											
											
											
											SongsDTO song2=new SongsDTO();
											
											song2.setSongid(102);
												
											song2.setSongname("Tum Hi Ho");
		
											song2.setSongmovie("Aashiqui 2");
											
											song2.setSonglength(4.21f);
		
											song2.setSingerParent(singer);
											
											
											
											SongsDTO song3=new SongsDTO();
											
											song3.setSongid(103);
												
											song3.setSongname("Naina");
		
											song3.setSongmovie("Dangel");
											
											song3.setSonglength(3.45f);

											song3.setSingerParent(singer);
											
				
			Set s=new HashSet();
			
			
			s.add(song1);
			
			s.add(song2);
			
			s.add(song3);
			
			
			singer.setSongsChild(s);
			
			
			sess.save(singer);
			
			
			Transaction ts=sess.beginTransaction();
			
			ts.commit();
			
			
			System.out.println("Insert Successfully");
			
			
			
			sess.close();
			
			
			sf.close();
			
											
											
		
	}
	
	
	
	public static void Insert_MANY_TO_ONE() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		SingerDTO singer=new SingerDTO();
		
		singer.setSid(1002);
		
		singer.setSname("Sonu Nigam");
		
		singer.setSemail("sonu@gmail.com");
		
		singer.setSmobile(999666555);
		
		singer.setSaddress("Mumbai");
		

		
											SongsDTO song1=new SongsDTO();
											
											song1.setSongid(104);
												
											song1.setSongname("Abhi Mughme kahi ");
		
											song1.setSongmovie("Agneepath");
											
											song1.setSonglength(6.56f);
											
											song1.setSingerParent(singer);
											
											
											
											SongsDTO song2=new SongsDTO();
											
											song2.setSongid(105);
												
											song2.setSongname("Tanhayee");
		
											song2.setSongmovie("Dil Chahta Hai");
											
											song2.setSonglength(5.33f);
		
											song2.setSingerParent(singer);
											
											
											
											SongsDTO song3=new SongsDTO();
											
											song3.setSongid(106);
												
											song3.setSongname("Har Ghadi Badal Rahi HAi");
		
											song3.setSongmovie("Kal HO NA HO");
											
											song3.setSonglength(4.20f);

											song3.setSingerParent(singer);

		
			sess.save(song1);
			
			sess.save(song2);
			
			sess.save(song3);
			
			
			Transaction ts=sess.beginTransaction();
			
			
			ts.commit();
			
			
			System.out.println("Insert Successfully");
			
			
			sess.close();
			
			sf.close();								
											
		
	}
	
	
	public static void Update_Parent_MANY_TO_ONE(int SingerID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from SongsDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			
			SongsDTO sdto=(SongsDTO) itr.next();
			
			if(sdto.getSingerParent().getSid() == SingerID)
			{
			
				
			System.out.println("OLD Detail's");
			
			
			System.out.println(sdto.getSingerParent().getSid()+"\t"+sdto.getSingerParent().getSname()+"\t"+sdto.getSingerParent().getSemail()+"\t"+sdto.getSingerParent().getSaddress()+"\t"+sdto.getSingerParent().getSmobile());
			
			
			sdto.getSingerParent().setSaddress("Dehradun");
			
			
			sess.update(sdto);
			
			
			Transaction ts=sess.beginTransaction();
			
			
			ts.commit();
			

			
			System.out.println("NEW Detail's");
			
			
			System.out.println(sdto.getSingerParent().getSid()+"\t"+sdto.getSingerParent().getSname()+"\t"+sdto.getSingerParent().getSemail()+"\t"+sdto.getSingerParent().getSaddress()+"\t"+sdto.getSingerParent().getSmobile());

			
			break;
			
			}
			
			
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	
	public static void Delete_Parent_ONE_TO_MANY(int SingerID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();

		
		SingerDTO singer=(SingerDTO) sess.get(SingerDTO.class, SingerID);
		
		

		System.out.println("Record Before Detetion");
		
		
		System.out.println(singer.getSid()+"\t"+singer.getSname()+"\t"+singer.getSemail()+"\t"+singer.getSaddress()+"\t"+singer.getSmobile()); 
		
		
		sess.delete(singer);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("Record Deleted Successfully");
		
		
		sess.close();
		
		
		sf.close();
		
		
	}
	
	
	
	public static void Delete_Child_MANY_TO_ONE(int SongID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		SongsDTO song=(SongsDTO) sess.get(SongsDTO.class, SongID);
		
		
		sess.delete(song);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("Deleted Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	Insert_ONE_TO_MANY();
		
		
	//	Insert_MANY_TO_ONE();
		
		
	//	Update_Parent_MANY_TO_ONE(1002);
		
		
	//	Delete_Parent_ONE_TO_MANY(1002);
		
		
	//	Delete_Child_MANY_TO_ONE(101);
		
		
	}
	
	
	
}
