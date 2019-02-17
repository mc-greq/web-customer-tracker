package springhibernate.app.services;

import springhibernate.app.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
