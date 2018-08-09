package co.in.pp;

import java.util.*;

public class PoliceDTO 
{

	private Integer pid;
	
	private String pname, pdepartment, pstation,  ppost;
	
	
	private Set PoliceChild;
	
	
	
	public int getPid()
	{
		return pid;
	}
	
		public void setPid(Integer pid)
		{
			this.pid=pid;
		}

		public String getPname() {
			return pname;
		}

		public void setPname(String pname) {
			this.pname = pname;
		}

		public String getPdepartment() {
			return pdepartment;
		}

		public void setPdepartment(String pdepartment) {
			this.pdepartment = pdepartment;
		}

		public String getPstation() {
			return pstation;
		}

		public void setPstation(String pstation) {
			this.pstation = pstation;
		}

		public String getPpost() {
			return ppost;
		}

		public void setPpost(String ppost) {
			this.ppost = ppost;
		}

		public Set getPoliceChild() {
			return PoliceChild;
		}

		public void setPoliceChild(Set policeChild) {
			PoliceChild = policeChild;
		}

	
	
		
		
		
	
	
}
