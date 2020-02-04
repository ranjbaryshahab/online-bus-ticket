package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.repositories;

import ir.maktab.java32.projects.servlet.onlinebusticket.config.database.HibernateUtil;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.repositories.CrudRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Customer;

public class CustomerRepository extends CrudRepository<Customer, Long> {
    private static CustomerRepository customerRepository;

    private CustomerRepository() {
        setSession(HibernateUtil.getSession());
    }

    public static CustomerRepository getInstance() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepository();
        }
        return customerRepository;
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
