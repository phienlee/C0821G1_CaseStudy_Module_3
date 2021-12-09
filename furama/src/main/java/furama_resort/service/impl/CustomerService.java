package furama_resort.service.impl;

import furama_resort.bean.Customer;
import furama_resort.repository.impl.CustomerRepository;
import furama_resort.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {

    CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public void insertUser(Customer customer) {
        customerRepository.insertUser(customer);
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }
}
