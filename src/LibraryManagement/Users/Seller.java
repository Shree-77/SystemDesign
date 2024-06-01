package LibraryManagement.Users;

import LibraryManagement.Books.Book;
import LibraryManagement.Books.BookController;
import LibraryManagement.Order.Orders;

import java.util.*;

import static LibraryManagement.Books.Book.BookId;


public class Seller implements User{

    Scanner in = new Scanner(System.in);

   public int sellerId;
    public String Name;
   public String Password;

   public static List<Seller> sellerList = new ArrayList<Seller>();

    public Seller(int sellerId, String name) {
        this.sellerId = sellerId;
        Name = name;
    }

    public int getEarned() {
        return earned;
    }

    public void setEarned(int earned) {
        this.earned = earned;
    }

    int earned=0;

    public Seller(int sellerId, String name , String password) {
        this.sellerId = sellerId;
        Name = name;
        Password = password;
    }

    @Override
    public int getID() {
        return sellerId;
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
        this.Password = Password ;
    }

    public void setName(String name) {
        this.Name=name;
    }

    @Override
    public void setID(int Id) {
        this.sellerId =Id;
    }

    public void AddBook(){
        System.out.println("Enter the name of the book : ");
        String bookName = in.next();
        System.out.println("Enter the Genre of the book : ");
        String genreofbook = in.next();
        System.out.println("Rate of the book : ");
        int rate = in.nextInt();
        System.out.println("Enter the name of the Author : ");
        String AuthorName = in.next();
        System.out.println("enter the category : ");
        String bookCategory = in.next();
        System.out.println("Enter  no of books : ");
        int no_of_books = in.nextInt();
        Book book = new Book(BookId+=1 ,bookName , genreofbook ,rate, AuthorName , bookCategory , sellerId,no_of_books);
        BookController.Book_list.add(book);

    }
    public void RemoveBook(){
        System.out.println("Enter the bookId");
        int bookId = in.nextInt();
        BookController.Book_list.removeIf(book -> book.getBookId() == bookId);

    }
    public void trackSales(){
        for(Book book : Orders.ordersList){
            if(book.getSeller_id()== sellerId){
                System.out.println(book.getName() + " Sold " + book.getSold() + "books and earned rs." + book.getRate()* book.getSold());
            }
        }
    }
}
