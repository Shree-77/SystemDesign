package LibraryManagement.Users;

import LibraryManagement.Books.Book;
import LibraryManagement.Books.BookController;
import LibraryManagement.Order.Orders;

import java.util.*;

public class Customer implements User{

    Scanner in = new Scanner(System.in);
    private int Id;
    private String Name;
    private String Password;

    public static List<Customer>customerList = new ArrayList<>();

    public Customer(int id, String name , String password) {
        Id = id;
        Name = name;
        Password = password;
    }

    @Override
    public int getID() {
        return Id;
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
        this.Password = Password;
    }

    @Override
    public void setName(String name) {
        this.Name=name;
    }

    @Override
    public void setID(int Id) {
        this.Id=Id;
    }

    public Book SearchBook(String Name){
        BookController bookController = new BookController();
        for(Book b : BookController.Book_list){
            if(b.getName().equals(Name)){
                return b;
            }
        }
        return null;
    }
    public List<Book> SearchByGenre(String genre){
        List<Book>genreList = new ArrayList<>();
        for(Book b : BookController.Book_list){
            if(b.getGenre().equals(genre)){
                genreList.add(b);
            }
        }
        if(genreList.isEmpty()) System.out.println("No books available in the genre");

        return genreList;
    }
    public void purchaseBook(){
        while(true){
            System.out.println("1. Purchase Book ");
            System.out.println("2. List all books");
            System.out.println("3.Exit ");
            int choice = in.nextInt();
            in.nextLine();

            switch (choice){
                case 1 :
                    System.out.println("Enter the name of the Book ");
                    String name = in.next();
                   Book orderedBook =  SearchBook(name);
                   if(orderedBook!=null){
                       orderedBook.setQuantity(orderedBook.getQuantity()-1);
                       orderedBook.setSold(orderedBook.getSold()+1);
                       Seller seller = new Seller(orderedBook.getSeller_id() , orderedBook.getName());
                       seller.setEarned(seller.getEarned()+ orderedBook.getRate());
                       Orders.ordersList.add(orderedBook);
                       System.out.println("Successfully Purchased!!");
                   }else{
                       System.out.println("Book not available");
                       return;
                   }
                   break;

                case 2:
                    System.out.println(Arrays.toString(BookController.Book_list.toArray()));
                    break;
                case 3 :
                    return;
                default:
                    System.out.println("Enter the correct option");

            }
        }

    }

}
