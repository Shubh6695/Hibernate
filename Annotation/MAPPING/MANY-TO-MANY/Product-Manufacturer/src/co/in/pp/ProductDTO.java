package co.in.pp;

import java.util.*;
import javax.persistence.*;


@Entity
@Table(name="productdetail")

public class ProductDTO 
{
	@Id
	@Column(name="P_ID")
	private Integer pid;
	
	
	@Column(name="P_NAME")
	private String pname;
	
	

	@ManyToMany(targetEntity=ManufacturerDTO.class, cascade=CascadeType.ALL)
	
	
	
	@JoinTable(name="productrelationship" , joinColumns=@JoinColumn(name="PRODUCT_ID" , referencedColumnName="P_ID"),
				inverseJoinColumns=@JoinColumn(name="MAN_ID", referencedColumnName="M_ID")
			)
	
	

	
	
	private Set manufacturerChild;

	
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	
	
	
	public Set getManufacturerChild() {
		return manufacturerChild;
	}

	public void setManufacturerChild(Set manufacturerChild) {
		this.manufacturerChild = manufacturerChild;
	}
	
	
	
}
