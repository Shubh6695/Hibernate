package co.in.pp;

public class CarDTO
{

	private Integer carid, purchaseyear; 
	
	private String brand, model ,color;

	private OwnerDTO OwnerParent;

	
	
	
	public Integer getCarid() {
		return carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public Integer getPurchaseyear() {
		return purchaseyear;
	}

	public void setPurchaseyear(Integer purchaseyear) {
		this.purchaseyear = purchaseyear;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public OwnerDTO getOwnerParent() {
		return OwnerParent;
	}

	public void setOwnerParent(OwnerDTO ownerParent) {
		OwnerParent = ownerParent;
	}
	
	
	
	
}
