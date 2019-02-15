package springhibernate.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springhibernate.app.entities.Customer;

import java.util.List;

@Repository // for DAO implementations use @Repository just like @Component in case of pojos
public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        // get the session
        Session session = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> getCustomerQuery = session
                .createQuery("FROM Customer", Customer.class);

        // return the list of customers
        return getCustomerQuery.getResultList();
    }
}
