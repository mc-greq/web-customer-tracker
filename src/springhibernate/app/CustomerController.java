package springhibernate.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springhibernate.app.entities.Customer;
import springhibernate.app.services.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer DAO
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel){

        // get customers from the dao
        List<Customer> customers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", customers);

        return "list-customers";
    }
}
