package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	public static void InsertDemo() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
																							// Ventor Part (1 vendor is created)
		VendorDTO v= new VendorDTO();
		
		v.setVid(102);
		
		v.setVname("DELL");
		
		
						CustomerDTO c1= new CustomerDTO(); 									// 1 object of CustomerDTO	
							
						c1.setCid(506);
						
						c1.setCname("Shubham");
						
						
						
						
						CustomerDTO c2=new CustomerDTO();									//2 object of CustomerDTO 
						
		
						c2.setCid(507);
						
						c2.setCname("Aman");
						
						
						CustomerDTO c3= new CustomerDTO();									// 3 object of CustomerDTO
						
						c3.setCid(508);
						
						c3.setCname("Ankit");
						
		
		Set s= new HashSet();														//adding child objects to set, as we taken 3rd property set in parent

		
		s.add(c1);																			// adding CustomerDTO object (c1) in Set
		
		s.add(c2);																			// adding CustomerDTO object (c2) in Set
		
		s.add(c3);																			// adding CustomerDTO object (c3) in Set
		
		
		
		
		v.setChildren(s);															// adding Set(s) in the VendorDTO's setChildern() method 
		
		
		
		
		Transaction ts=sess.beginTransaction();										// Transaction Start
		
		
		sess.save(v);																// Save all the values in both tables;  	
		
		
		ts.commit();																// commit the transaction.
		
		
		
		
		sess.close();																// Close the Session
		
		
		sf.close();																	// Close the Session Factory	
		
						
	}
	
	
	public static void InsertNoCustomerVendor() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		VendorDTO vdto=new VendorDTO();
		
		
		vdto.setVid(102);
		
		vdto.setVname("APPLE");
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(vdto);
		
		
		ts.commit();
		
		
		System.out.println("Vendor Inserted Successfully");
		
		sess.close();
		
		
		sf.close();
		
		
	}
	
	
	
	public static void InsertCustomerOnly(int VID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		VendorDTO vdto=(VendorDTO) sess.get(VendorDTO.class, VID);
		
		
		System.out.println("Vendor's Details");
		
		
		System.out.println(vdto.getVid()+"\t"+vdto.getVname());
		
		
		
		
			
			CustomerDTO c1=new CustomerDTO();
			
			
			c1.setCid(506);
			c1.setCname("Kunal");
			
			
			CustomerDTO c2=new CustomerDTO();
			
			
			c2.setCid(507);
			c2.setCname("Ram");
			
			
			CustomerDTO c3=new CustomerDTO();
			
			
			c3.setCid(508);
			c3.setCname("Ankit");

			
			
	Set s=new HashSet();
	
	
	s.add(c1);
	
	s.add(c2);		
		
	s.add(c3);
	
	
	
	vdto.setChildren(s);
	
	
	Transaction ts=sess.beginTransaction();
	
	sess.update(vdto);
	
	ts.commit();
	
	
		sess.close();
		
		sf.close();
		
	}
	
	
	
	
	public static void GetDemo() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		
		Query v=sess.createQuery("from VendorDTO");													// HQL Query for Selecting Record from VendorDTO
		
		
		List rows=v.list();
		
		
		Iterator itr=rows.iterator();
		
		
		System.out.println("Vendor's List");
		
		
		while(itr.hasNext())
		{
			
			VendorDTO vdto=(VendorDTO) itr.next();													// Type-cast List in to VendorDTO
			
			
			System.out.println(vdto.getVid()+"\t"+vdto.getVname());
			
			System.out.println();
			
			
			
			
					Set s1=vdto.getChildren();													// Record of another table is store in Children() method of VendorDTO
			
					Iterator itr1=s1.iterator();
					
					
					System.out.println("Customer's List of Vendor "+vdto.getVid());
					
					
					while(itr1.hasNext())
					{
						
						CustomerDTO cdto=(CustomerDTO) itr1.next();									// Type-cast Set in to CustomerDTO
						
						
						System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getForeign_VID());
						
						System.out.println();
						
					}
			
		}
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void GetSingleRecord(int id) throws Exception									// Get ALL Record of Single Vendor 
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		VendorDTO vdto=(VendorDTO) sess.get(VendorDTO.class, id);							// Type-cast List in to VendorDTO
		
		
		System.out.println("Vendor's Details");
		
		
		System.out.println(vdto.getVid()+"\t"+vdto.getVname());
		
		
		System.out.println();
		
		System.out.println("Customer's Details");
		
		
		Set s=vdto.getChildren();															// Record of another table is store in Children() method of VendorDTO
		
		Iterator itr=s.iterator();
		
		
		while(itr.hasNext())
		{
			
			CustomerDTO cdto=(CustomerDTO) itr.next();										// Type-cast Set in to CustomerDTO
			
			System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getForeign_VID());
			
		}
		
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void UpdateChildTable(int VID, int CID) throws Exception
	{
	
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		VendorDTO vdto=(VendorDTO) sess.get(VendorDTO.class, VID);
		
		
		System.out.println("Vendor's Details");
		
		System.out.println(vdto.getVid()+"\t"+vdto.getVname());
		
		
		
		Set s=vdto.getChildren();
		
		
		if(!s.isEmpty())
		{
			
			CustomerDTO cdto=(CustomerDTO) sess.get(CustomerDTO.class, CID);
			
			
			System.out.println("OLD Record of Customer");
			
			
			System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getForeign_VID());
			
			
			
			cdto.setCname("Ankit");
			
			cdto.setForeign_VID(101);
			
			
			Transaction ts=sess.beginTransaction();
			
			
			sess.update(vdto);
			
			ts.commit();
			

			System.out.println("NEW Record of Customer");
			
			
			System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getForeign_VID());

			
			
		}
		else
		{
			System.out.println("Vendor ID NOT FOUND");
			
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	
	public static void UpdateParentTable(int VID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		VendorDTO vdto=(VendorDTO) sess.get(VendorDTO.class, VID);
		
		
		System.out.println("OLD Deatils of Vendor ");
		
		System.out.println(vdto.getVid()+"\t"+vdto.getVname());
		
		
		vdto.setVname("APPLE");
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.update(vdto);
		
		ts.commit();
		
		
		System.out.println("NEW Details of Vendor");
		
		System.out.println(vdto.getVid()+"\t"+vdto.getVname());
		
		
		sess.close();
		
		
		sf.close();
		
	}
	
	
	
	public static void DeleteSingleCustomer(int VID, int CID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		VendorDTO vdto=(VendorDTO) sess.get(VendorDTO.class, VID);
		
		
		Set s=vdto.getChildren();
		
		
		Iterator itr=s.iterator();
		
		
		while(itr.hasNext())
		{
			
			CustomerDTO cdto=(CustomerDTO) itr.next();
			
			
			if(cdto.getCid()==CID)
			{
				
				System.out.println("OLD Record of Customer");
				
				System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getForeign_VID());
				
				
				cdto.setCid(CID);
				
				
				System.out.println("CID is "+CID);
				
				Transaction ts=sess.beginTransaction();
				
				sess.delete(cdto);
				
				
				ts.commit();
				
				
				System.out.println("Successfully Delete Record for "+CID);
				
				
				sess.close();
				
				sf.close();
			
			}
			
			else
			{
				System.out.println("Record Not found for Deletetion");
				
			}
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	public static void DeleteVendor(int VID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		VendorDTO vdto=(VendorDTO) sess.get(VendorDTO.class, VID);
		
		
		sess.delete(vdto);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		System.out.println("Delete Successfully");
		
		
		sess.close();
		
		
		sf.close();
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertDemo();
		
		
	//	InsertNoCustomerVendor();
		
		
	//	InsertCustomerOnly(102);
		
		
	//	GetDemo();
		
		
	//	GetSingleRecord(101);
		
		
	//	UpdateChildTable(102, 508);

		
	//	UpdateParentTable(102);
		
		
	//	DeleteSingleCustomer(102, 508);
		
		
	//	DeleteVendor(102);
		
		
		
	}
	
	
}
