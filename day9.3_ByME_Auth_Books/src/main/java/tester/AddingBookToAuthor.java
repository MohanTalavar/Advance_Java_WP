package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;
import dao.*;
import pojos.Book;

import java.util.Scanner;

public class AddingBookToAuthor {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();
				Scanner sc= new Scanner(System.in)){
			
			BookDao dao = new BookDaoImpl();
			
			System.out.println("Enter book details: Title | price ");
			Book newBook = new Book(sc.next(), sc.nextDouble());
			
			System.out.println("Enter auth id: ");
			System.out.println(dao.addNewBook(newBook,sc.nextLong()));
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
