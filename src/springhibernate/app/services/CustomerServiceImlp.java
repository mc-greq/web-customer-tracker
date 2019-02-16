package springhibernate.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springhibernate.app.dao.CustomerDAO;
import springhibernate.app.entities.Customer;

import java.util.List;

@Service
public class CustomerServiceImlp implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImlp(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}
