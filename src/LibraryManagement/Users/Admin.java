package LibraryManagement.Users;

import java.util.Arrays;
import java.util.Objects;

import static LibraryManagement.Users.Customer.customerList;
import static LibraryManagement.Users.Seller.sellerList;

public class Admin {

    private final int Id = 11;
    private final String Password = "123";

    public boolean login(String name, String password) {
        String name1 = "Shree";
        return name1.equals(name) && this.Password.equals(password);
    }

    public Seller Verify_seller_login(String name, String password) {
        for(Seller seller : sellerList){
            if(Objects.equals(seller.Name, name) &&  Objects.equals(seller.Password , password)){
                return seller;
            }
        }
        return null;
    }
    public Customer Verify_customer_login(String name, String password) {
        for(Customer customer : customerList){
            if(Objects.equals(customer.getName(), name) &&  Objects.equals(Password , password)){
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer) {
            customerList.add( customer);
    }
    public void addSeller(Seller seller) {
        sellerList.add( seller);
    }

    public void removeSeller(Seller seller) {
        sellerList.remove(seller);
    }
    public void removeCustomer(Customer customer) {
        customerList.remove(customer);
    }

    public void viewUsers() {
        System.out.println("Customers: " + Arrays.toString(customerList.toArray()));
        System.out.println("Sellers: " + Arrays.toString(sellerList.toArray()));
    }
}
