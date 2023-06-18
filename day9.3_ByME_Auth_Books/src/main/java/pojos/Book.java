package pojos;

import javax.persistence.*;

//Book : id,title(unique), price + ?????

@Entity
@Table(name="Books")
public class Book extends BaseEntity{
	
	@Column(unique = true, length = 20)
	private String title;
	
	@Column(nullable = false)
	private double price;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author assignedAuthor;
	
	
	//==========================
	
	

	public String getTitle() {
		return title;
	}

	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Author getAssignedAuthor() {
		return assignedAuthor;
	}

	public void setAssignedAuthor(Author assignedAuthor) {
		this.assignedAuthor = assignedAuthor;
	}
	
	

}
