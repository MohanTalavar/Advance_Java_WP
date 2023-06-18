package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.*;

import pojos.Author;

public class AuthorDaoImpl implements AuthorDao {

	@Override
	public String launchNewAuthor(Author auth) {
		
		String mesg="Adding new author failed";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.persist(auth);
			tx.commit();
			mesg="New author added!!!! "+auth.getId();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
				
		
		return mesg;
	}

}
