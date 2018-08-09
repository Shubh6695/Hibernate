package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	public static void insertALLFromProductSide()
	{
		
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		ProductDTO p1=new ProductDTO();
		
		p1.setPid(201);
		
		p1.setPname("Laptop");
		
		
		ProductDTO p2=new ProductDTO();
		
		p2.setPid(202);
		
		p2.setPname("Mobile");
		
		
													ManufacturerDTO m1=new ManufacturerDTO();
													
													m1.setMid(301);
		
													m1.setMname("SONY");
		
													m1.setMaddress("Japan");
													
													m1.setMcontact(999666333);
													
		

													ManufacturerDTO m2=new ManufacturerDTO();
													
													m2.setMid(302);
		
													m2.setMname("Apple");
		
													m2.setMaddress("America");
													
													m2.setMcontact(999888777);

						
				Set s=new HashSet();									
							
				s.add(m1);
				
				s.add(m2);
				
				
				
				p1.setManufacturerChild(s);
				
				p2.setManufacturerChild(s);
				
				
				
				Transaction ts=sess.beginTransaction();
				
				sess.save(p1);
				
				sess.save(p2);
				
				ts.commit();
				
				
				System.out.println("Insert Successfully");
				
				
				sess.close();
				
				sf.close();
				
				
													
	}
	
	
	
	
	
	public static void insertALLFromManufacturere()
	{
		
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();

	
		
		
		ManufacturerDTO m1=new ManufacturerDTO();
		
		m1.setMid(303);

		m1.setMname("HTC");

		m1.setMaddress("Taiwan");
		
		m1.setMcontact(999555222);
		


		ManufacturerDTO m2=new ManufacturerDTO();
		
		m2.setMid(304);

		m2.setMname("Lenovo");

		m2.setMaddress("China");
		
		m2.setMcontact(999888111);


		
													ProductDTO p1=new ProductDTO();
		
													p1.setPid(203);
		
													p1.setPname("Laptop");
		
													
													
													
													ProductDTO p2=new ProductDTO();
		
													p2.setPid(204);
		
													p2.setPname("Mobile");

		
	
					Set s=new HashSet();
					
					s.add(p1);
					
					s.add(p2);
								
					
			m1.setProductParent(s);
			
			m2.setProductParent(s);
					
									
			
			Transaction ts=sess.beginTransaction();
			
			sess.save(m1);
			
			sess.save(m2);
			
			ts.commit();
			
			
			System.out.println("Insert Successfully");
			
			
			sess.close();
			
			sf.close();

			
	
	}
	
	
	
	public static void getALLFromProductSide()
	{
		
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		

		Query q=sess.createQuery("from ProductDTO");
		
		List rows=q.list();
		
		
		Iterator itr1=rows.iterator();
		
		while(itr1.hasNext())
		{
			
			ProductDTO pdto=(ProductDTO) itr1.next();
			
			System.out.println(pdto.getPid()+"\t"+pdto.getPname()+"\n");
			
			
			Set s=pdto.getManufacturerChild();
			
			System.out.println(s.size());
			
			Iterator itr2=s.iterator();
		
			while(itr2.hasNext())
			{
				
				ManufacturerDTO mdto=(ManufacturerDTO) itr2.next();
				
				System.out.println(mdto.getMid()+"\t"+mdto.getMname()+"\t"+mdto.getMaddress()+"\t"+mdto.getMcontact()+"\n");
				
			}
			
			
		}
		
		
		sess.close();
		
		sf.close();
		
		
	}	
	
	
	public static void getALLFromManufacturere()
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		

		Query q=sess.createQuery("from ManufacturerDTO");
		
		List rows=q.list();
		
		
		Iterator itr1=rows.iterator();
		
		while(itr1.hasNext())
		{
			

			ManufacturerDTO mdto=(ManufacturerDTO) itr1.next();
			
			
			System.out.println(mdto.getMid()+"\t"+mdto.getMname()+"\t"+mdto.getMaddress()+"\t"+mdto.getMcontact()+"\n");
			
			
			
			Set s=mdto.getProductParent();
			
			
			Iterator itr2=s.iterator();
			
			
			while(itr2.hasNext())
			{
				
				ProductDTO pdto=(ProductDTO) itr2.next();
				
				System.out.println(pdto.getPid()+"\t"+pdto.getPname()+"\n");
				
			}

			
			
			

		}
		
		sess.close();
		
		sf.close();
		
	}
	
	public static void 	getALLManufacturerfromSingleProduct(int PID) 
	{
		
		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session sess=sf.openSession();
		
	
		ProductDTO pdto=(ProductDTO) sess.get(ProductDTO.class, PID);
		
		System.out.println("Product Detail's");
		
		System.out.println(pdto.getPid()+"\t"+pdto.getPname()+"\n");
		
		
		Set s=pdto.getManufacturerChild();
		
		Iterator itr=s.iterator();
		
		System.out.println("Manufacturer Detail's");
		
		
		while(itr.hasNext())
		{
			
			ManufacturerDTO mdto=(ManufacturerDTO) itr.next();
			
			System.out.println(mdto.getMid()+"\t"+mdto.getMname()+"\t"+mdto.getMaddress()+"\t"+mdto.getMcontact()); 
		
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args)
	{
		
	//	insertALLFromProductSide();
		
	//	insertALLFromManufacturere();
		
	//	getALLFromProductSide();
		
	//	getALLFromManufacturere();
		
	//	getALLManufacturerfromSingleProduct(201);
		
	}

	
}
