package BankApplication.Customer;

import BankApplication.Bank.Bank;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class HandleCustomer {
    public static final String file = "/Users/shree/Documents/SystemDesign/src/BankApplication/Data.txt";


    public void initializeBank() throws IOException {
        File file1 = new File(file);

        if(!file1.exists()){
            System.out.println("File not Available");
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String line;

        while ((line = reader.readLine())!=null){
            String[]customers = line.split(" ");
            Customer customer = new Customer(
                    Integer.parseInt(customers[0]),
                    Long.parseLong(customers[1]),
                    customers[2],
                    Double.parseDouble(customers[3]),
                    customers[4]
            );
            Bank.list.add(customer);
        }
        Bank.AccountNo = Bank.list.get(Bank.list.size()-1).AccountNo;
        Bank.RefNumber = Bank.list.get(Bank.list.size()-1).Customer_Id;
    }
    public void AddCustomer() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Name of the Customer ");
        String name= in.next();
        String password;String reenter;
        do{
            System.out.println("Re-Entering Password should be same");
            System.out.println("Enter the Password : ");
             password = in.next();
            System.out.println("Re enter the password : ");
            reenter = in.next();
        }while (!reenter.equals(password));
        String EncryptedPassword = Encrypt(password);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file , true))){
            writer.write(Bank.RefNumber+1 + " " + Bank.AccountNo+1 + " " + name + " "+ 10000 +" "+ EncryptedPassword);
            writer.newLine();
            System.out.println("Customer Added Successful");
        }catch (Exception e){
            System.out.println("Exception");
        }
    }
    public String Encrypt(String password){
        char[]arr = password.toCharArray();

        for(int i=0;i<password.length();i++){
            if(arr[i]>='a' && arr[i]<='z'){
                arr[i] = (arr[i]=='z' ? 'a' : (char)(arr[i]+1));
            }else if(arr[i]>='A' && arr[i]<='Z'){
                arr[i] = (arr[i]=='Z' ? 'A' : (char)(arr[i]+1));
            }else if(arr[i]>='0' && arr[i]<='9'){
                arr[i] = (arr[i]=='9' ? '0' : (char)(arr[i]+1));
            }
        }
       return new String(arr);
    }
}
