package co.in.pp;

import java.util.*;

public class ProductDTO
{

	private Integer productid;
	
	private String productname;
	
	private Set ProductChild;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Set getProductChild() {
		return ProductChild;
	}

	public void setProductChild(Set productChild) {
		ProductChild = productChild;
	}
	
	
	
	
}
