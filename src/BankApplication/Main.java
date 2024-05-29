package BankApplication;

import BankApplication.Bank.Bank;
import BankApplication.Customer.Customer;
import BankApplication.Customer.HandleCustomer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HandleCustomer handleCustomer = new HandleCustomer();
        handleCustomer.initializeBank();

       handleCustomer.AddCustomer();

        for(int i =0;i< Bank.list.size();i++){
            System.out.println(Bank.list.get(i).toString());
        }

    }
}
