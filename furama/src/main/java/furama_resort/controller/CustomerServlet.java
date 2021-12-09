package furama_resort.controller;

import furama_resort.bean.Customer;
import furama_resort.bean.CustomerType;
import furama_resort.repository.impl.BaseConnection;
import furama_resort.repository.impl.CustomerRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateCustomerPage(request, response);
                break;
            case "edit":
                showEditPage(request,response);
                break;
            default:
                listCustomer(request, response);
        }
    }

    private void showEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customerEdit = customerRepository.findById(id);
        request.setAttribute("customerEdit",customerEdit);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
            case "update":
                editCustomer(request, response);
                break;

        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerRepository.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateCustomerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(name, birthDay, idCard, phone, email, customerType, address);
        customerRepository.insertUser(customer);
//        String successfullyMsg="successfullyMsg";
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
//        request.setAttribute("successfullyMsg",successfullyMsg) ;
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(name, birthDay, idCard, phone, email, customerType, address);

//        customerRepository.update(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }
}
