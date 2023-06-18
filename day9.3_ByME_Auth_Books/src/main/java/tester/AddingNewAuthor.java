package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.AuthorDao;
import dao.AuthorDaoImpl;
import pojos.Author;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class AddingNewAuthor {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory() ;
				Scanner sc=new Scanner(System.in)){
			
			AuthorDao auth = new AuthorDaoImpl();
			System.out.println("Enter Auth details: firstName | lastName | email | password");
			System.out.println(auth.launchNewAuthor(new Author(sc.next(), sc.next(), sc.next(), sc.next())));
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
