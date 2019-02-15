package springhibernate.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springhibernate.app.dao.CustomerDAO;
import springhibernate.app.entities.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer DAO
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/list")
    public String listCustomers(Model theModel){

        // get customers from the dao
        List<Customer> customers = customerDAO.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", customers);

        return "list-customers";
    }
}
