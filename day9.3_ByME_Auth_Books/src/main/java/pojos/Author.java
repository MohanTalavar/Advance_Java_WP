package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Authors")
public class Author extends BaseEntity {
	
	@Column(name="first_name" , length = 30)
	private String firstName;
	
	@Column(name="last_name" , length = 30)
	private String lastName;
	
	@Column(length = 30, unique = true)
	private String email;
	
	@Column(nullable = false, length = 30)
	private String password;
	
	@OneToMany(mappedBy="assignedAuthor" , cascade = CascadeType.ALL)
	private List<Book> bookList = new ArrayList<>();
	
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	// pro tip : adiding helper methods 
	
	public void addBook(Book bk) {
		
		// parent --> child
		bookList.add(bk);
		
		// child --> parent 
		bk.setAssignedAuthor(this);
		
		
	}
	
	public void removeBook(Book bk) {
		bookList.remove(bk);
		bk.setAssignedAuthor(null);
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	

}
