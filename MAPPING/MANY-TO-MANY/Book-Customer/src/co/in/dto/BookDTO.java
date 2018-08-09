package co.in.dto;

import java.util.*;

public class BookDTO 
{

	
	private Integer bookid, price;
	
	private String title, author, category;
	
	private Set CustomerParent;

	
	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set getCustomerParent() {
		return CustomerParent;
	}

	public void setCustomerParent(Set customerParent) {
		CustomerParent = customerParent;
	}
	
	
}
