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
		
		
		
		CreditDTO credit=new CreditDTO();
		
		credit.setPid(101);
		
		credit.setAmount(1000.00);
		
		credit.setCreditCardType("Visa");
		
		
		
										ChequeDTO cq=new ChequeDTO();
		
										cq.setPid(102);
		
										cq.setAmount(2000.00);
		
										cq.setChequeType("SBI");
		
										
			Transaction ts=sess.beginTransaction();
			
			sess.save(credit);
			
			sess.save(cq);
			
			ts.commit();
			
			System.out.println("Insert Successfully");
										
				
			sess.close();
			
			sf.close();

		
		
		
		
	}
	
	public static void main(String[] args) throws Exception
	{
		
		insertALL();
		
	}
	
	
}
