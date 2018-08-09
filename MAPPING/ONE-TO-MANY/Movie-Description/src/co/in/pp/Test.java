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
		
		
		MovieDTO mdto1=new MovieDTO();
		
		mdto1.setMovieid(101);
		
		mdto1.setMoviename("Padmaavat");
		
		mdto1.setMovietype("Histotic");
		
		mdto1.setReleaseyear(2018);
		
		mdto1.setMovielength(163.00f);
			
		
								
								DescriptionDTO dto1=new DescriptionDTO();
								
								dto1.setId(201);
								
								dto1.setDirectorname("Sanjay Leela Bhansali");
		
								dto1.setActorname("Ranveer Singh, Hritik Roshan");
								
								dto1.setActressname("Deepika Padukone");
								
								dto1.setProducer("Bhansali Productions");
								
								
		Set s=new HashSet();
		
		s.add(dto1);
		
		
		mdto1.setMovieChild(s);
								
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(mdto1);
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void UpdateChild(int MID, int ID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		MovieDTO mdto1=(MovieDTO) sess.get(MovieDTO.class, MID);
		
		
		Set s=mdto1.getMovieChild();
		
		
		if(!s.isEmpty())
		{
			DescriptionDTO dto1=(DescriptionDTO) sess.get(DescriptionDTO.class, ID);
			
			
			dto1.setActorname("Ranveer Singh, Shahid Kapoor");
			
			
			Transaction ts=sess.beginTransaction();
			
			sess.update(mdto1);
			
			ts.commit();
			
			System.out.println("Record Successfully Updated");
			
			
			
		}
		
		
		sess.close();
		
		
		sf.close();
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertALL();
		
		UpdateChild(101, 201);
		
		
	}
	
	
}
