package furama_resort.bean;

public class Customer extends Person {
    private int customerType;
    private String address;

    public Customer(int id, String name, String birthday, String idCard, String phone, String email, int customerType, String address) {
        super(id, name, birthday, idCard, phone, email);
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String name, String birthday, String idCard, String phone, String email, int customerType, String address) {
        super(name, birthday, idCard, phone, email);
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(int customerType, String address) {
        this.customerType = customerType;
        this.address = address;
    }

    public Customer() {
    }
    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

