package springhibernate.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
    public List<Customer> getCustomers() {

        // get the session
        Session session = sessionFactory.getCurrentSession();

        // create a query, sort by last name
        Query<Customer> getCustomerQuery = session
                .createQuery("FROM Customer ORDER BY lastName", Customer.class);

        // return the list of customers
        return getCustomerQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Session session = sessionFactory.getCurrentSession();

//        Query deleteQuery = session.createQuery("delete from Customer where id=:customerId");
//        deleteQuery.setParameter("customerId", customerId);
//        deleteQuery.executeUpdate();
        session.delete(session.get(Customer.class, customerId));
    }
}
