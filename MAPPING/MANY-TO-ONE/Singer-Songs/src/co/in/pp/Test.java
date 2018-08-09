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

											
		sess.save(song1);
		
		sess.save(song2);
		
		sess.save(song3);
						
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
											
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		InsertALL();
		
		
	}

	
	
	
	
	
}
