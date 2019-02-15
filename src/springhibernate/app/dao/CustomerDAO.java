package springhibernate.app.dao;

import springhibernate.app.entities.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
}
