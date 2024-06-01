package LibraryManagement;

import LibraryManagement.Users.Admin;
import LibraryManagement.Users.Customer;
import LibraryManagement.Users.Seller;
import LibraryManagement.Users.User;

import java.util.Scanner;

import static LibraryManagement.Users.Customer.customerList;
import static LibraryManagement.Users.Seller.sellerList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Admin admin = new Admin();
        int customerId = 0;
        int sellerId = 0;

        int n;
        do {
            System.out.println("Login As : ");
            System.out.println("1. Customer");
            System.out.println("2. Seller");
            System.out.println("3. Admin");
            System.out.println("4. Quit");
            n = in.nextInt();
            in.nextLine();

            switch (n) {
                case 1:
                    System.out.println("Enter the name of the customer:");
                    String customerName = in.nextLine();
                    System.out.println("Enter the Password of the customer : ");
                    String pass = in.nextLine();
                    Customer customer;
                    customer = admin.Verify_customer_login(customerName , pass);
                    if(customer!=null){
                        customer.purchaseBook();
                    }else{
                        System.out.println("invalid Login");
                        return;
                    }
                    break;
                case 2:
                    System.out.println("Enter the name of the Seller:");
                    String sellerName = in.nextLine();
                    System.out.println("Enter the Password of the Seller : ");
                    String sellerpass = in.nextLine();
                    Seller seller;
                    seller = admin.Verify_seller_login(sellerName , sellerpass);
                    if(seller!=null){
                        int sellerOption;
                        do {
                            System.out.println("1. Add a book");
                            System.out.println("2. Remove a book");
                            System.out.println("3. Track sales");
                            System.out.println("4. Exit");
                            sellerOption = in.nextInt();
                            in.nextLine(); // Consume newline
                            switch (sellerOption) {
                                case 1:
                                    seller.AddBook();
                                    break;
                                case 2:
                                    seller.RemoveBook();
                                    break;
                                case 3:
                                    seller.trackSales();
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("Enter a valid option");
                            }
                        } while (sellerOption != 4);
                    }else{
                        System.out.println("invalid Login");
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Enter admin name:");
                    String adminName = in.nextLine();
                    System.out.println("Enter admin password:");
                    String adminPassword = in.nextLine();
                    if (admin.login(adminName, adminPassword)) {
                        int adminOption;
                        do {
                            System.out.println("1. Add a customer");
                            System.out.println("2. Add a seller");
                            System.out.println("3. Remove a customer");
                            System.out.println("4. Remove a seller");
                            System.out.println("5. View users");
                            System.out.println("6. Exit");
                            adminOption = in.nextInt();
                            in.nextLine(); // Consume newline
                            switch (adminOption) {
                                case 1:
                                    System.out.println("Enter the name of the customer:");
                                    String newCustomerName = in.nextLine();
                                    System.out.println("Enter the password of the customer : ");
                                    String newCustomerPassword = in.nextLine();
                                    Customer newCustomer = new Customer(customerId++, newCustomerName , newCustomerPassword);
                                    admin.addCustomer(newCustomer);
                                    break;
                                case 2:
                                    System.out.println("Enter the name of the seller:");
                                    String newSellerName = in.nextLine();
                                    System.out.println("Enter the password of the new Seller : ");
                                    String newSellerPassword = in.nextLine();
                                    Seller newSeller = new Seller(sellerId++, newSellerName , newSellerPassword);
                                    admin.addSeller(newSeller);
                                    break;
                                case 3:
                                    System.out.println("Enter the ID of the customer to remove:");
                                    int customerToRemoveId = in.nextInt();
                                    in.nextLine(); // Consume newline
                                    Customer customerToRemove = customerList.stream()
                                            .filter(c -> c.getID() == customerToRemoveId)
                                            .findFirst()
                                            .orElse(null);
                                    if (customerToRemove != null) {
                                        admin.removeCustomer(customerToRemove);
                                    } else {
                                        System.out.println("Customer not found");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Enter the ID of the seller to remove:");
                                    int sellerToRemoveId = in.nextInt();
                                    in.nextLine(); // Consume newline
                                    Seller sellerToRemove = sellerList.stream()
                                            .filter(s -> s.getID() == sellerToRemoveId)
                                            .findFirst()
                                            .orElse(null);
                                    if (sellerToRemove != null) {
                                        admin.removeSeller(sellerToRemove);
                                    } else {
                                        System.out.println("Seller not found");
                                    }
                                    break;
                                case 5:
                                    admin.viewUsers();
                                    break;
                                case 6:
                                    break;
                                default:
                                    System.out.println("Enter a valid option");
                            }
                        } while (adminOption != 6);
                    } else {
                        System.out.println("Invalid admin credentials");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter a valid option");
            }
        } while (n != 4);
    }
}
