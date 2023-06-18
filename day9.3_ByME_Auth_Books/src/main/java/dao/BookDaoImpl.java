package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Author;
import pojos.Book;


public class BookDaoImpl implements BookDao {

	@Override
	public String addNewBook(Book bk, long authid) {
		
		String mesg="Adding new book to author failed!!!!";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			
			Author auth = session.get(Author.class, authid);
			if(auth!=null) {
				
				auth.addBook(bk);
				session.persist(bk);
				mesg="Added new book to author : "+ auth.getFirstName() + " " + auth.getLastName();
				
			}
			tx.commit();
			
			
			
			
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return mesg;
	}

	
	
}
