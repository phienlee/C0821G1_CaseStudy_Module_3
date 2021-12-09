package furama_resort.repository.impl;

import furama_resort.bean.Customer;
import furama_resort.bean.CustomerType;
import furama_resort.repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String INSERT_CUSTOMER_SQL = "insert into customers(customer_type_id, full_name, date_of_birth, id_card_number, phone_number, email ,address)\n" +
            " value(?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_CUSTOMER = "select * " +
            "from customers";

    private static final String UPDATE_CUSTOMER_SQL = "update customers \n" +
            "set customer_type_id= ?, full_name= ?, date_of_birth = ?, id_card_number = ?, phone_number = ?, email = ?, address = ?\n" +
            "where customer_id = ?";
    private static final String FIND_CUSTOMER_SQL = "select *\n" +
            "from customers\n" +
            "where customer_id=?;";

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = BaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int customerType = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String birthDay = resultSet.getString(4);
                String idCard = resultSet.getString(5);
                String phone = resultSet.getString(6);
                String email = resultSet.getString(7);
                String address = resultSet.getString(8);

                customerList.add(new Customer(id, name, birthDay, idCard, phone, email, customerType, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void insertUser(Customer customer) {
        try (
                Connection connection = BaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)
        ) {
            preparedStatement.setInt(1, customer.getCustomerType());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try (Connection connection = BaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_SQL))
        {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int customerType = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String birthDay = resultSet.getString(3);
            String idCard = resultSet.getString(4);
            String phone = resultSet.getString(5);
            String email = resultSet.getString(6);
            String address = resultSet.getString(7);

            customer = new Customer(id, name, birthDay, idCard, phone, email, customerType, address);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer customer, int id) {
        try (
                Connection connection = BaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)
        ) {
            preparedStatement.setInt(1, customer.getCustomerType());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        Customer customer = new Customer("Phienle", "1999-03-31", "0909090990", "091214299", "phien@gmail.com", 1, "Danang");
        CustomerRepository customerRepository = new CustomerRepository();
//        customerRepository.update(customer, 4);
        Customer customer1 = customerRepository.findById(2);
        System.out.println(customer1);
    }
}
