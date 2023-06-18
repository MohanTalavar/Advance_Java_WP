package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import dao.*;
import pojos.Author;
import pojos.Book;


public class AddNewAuthorWithBooks {
	public static void main(String[] args) {

		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in)){
			
			AuthorDao dao = new AuthorDaoImpl();
			
			System.out.println("Enter author details:  firstName,  lastName,  email,  password");
			Author newAuth = new Author(sc.next() , sc.next(), sc.next(), sc.next());
			
			for (int i=0; i<2; i++) {
				
				System.out.println("Enter book details: title | price");
				
				Book newbook = new Book(sc.next() , sc.nextDouble());
				
				newAuth.addBook(newbook);
			}
			
			System.out.println(dao.launchNewAuthor(newAuth));
			
		}
		

	}
}
