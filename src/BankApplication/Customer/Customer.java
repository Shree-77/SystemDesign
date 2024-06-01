package BankApplication.Customer;

import LibraryManagement.Users.User;

public class Customer implements User {
    public int Customer_Id;
    public long AccountNo ;
    public String Name;
    public double Balance;
    public String Password;

    public Customer(int customer_Id, long accountNo, String name, double balance, String password) {
        Customer_Id = customer_Id;
        AccountNo = accountNo;
        Name = name;
        Balance = balance;
        Password = password;
    }


    @Override
    public String toString() {
        return
                "Customer_Id=" + Customer_Id +
                ", AccountNo='" + AccountNo + '\'' +
                ", Name='" + Name + '\'' +
                ", Balance=" + Balance +
                ", Password='" + Password ;
    }

    @Override
    public int getID() {
        return Customer_Id;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public void setPassword(String Password) {
        this.Password=Password;
    }

    @Override
    public void setName(String name) {
    this.Name=name;
    }

    @Override
    public void setID(int ID) {
        this.Customer_Id=ID;
    }
}
