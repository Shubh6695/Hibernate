package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	public static void InsertALL() throws Exception
	{
		
		Configuration cfg=new Configuration().configure();
		
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		UserDTO udto1=new UserDTO(1001, 999666333, "Shubham", "shubham@gmail.com", 25);
		
		
		GadgetDTO gdto1=new GadgetDTO(101, 2015, 1001, "Mobile", "HTC");
		
		
		GadgetDTO gdto2=new GadgetDTO(102, 2016, 1001, "Laptop", "DELL");
		
		
		Set s=new HashSet();
		
		s.add(gdto1);
		
		s.add(gdto2);
		
		
		udto1.setGadgetChild(s);
		
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(udto1);
		
		
		ts.commit();
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		InsertALL();
		
		
	}
	
	
	
}
