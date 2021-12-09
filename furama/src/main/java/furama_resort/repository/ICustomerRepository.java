package furama_resort.repository;

import furama_resort.bean.Customer;

import java.util.List;

public interface ICustomerRepository {

    List<Customer> selectAllCustomer();

    void insertUser(Customer customer);

    Customer selectCustomer(int id);

    Customer findById(int id);

    void update(Customer customer,int id);
}
