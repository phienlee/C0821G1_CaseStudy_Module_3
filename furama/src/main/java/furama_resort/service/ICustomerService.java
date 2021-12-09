package furama_resort.service;

import furama_resort.bean.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> selectAllCustomer();

    void insertUser(Customer customer);

    Customer selectCustomer(int id);
}
