package BankApplication.Customer;

public class Customer {
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
}
