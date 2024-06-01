package LibraryManagement.Books;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    public static List<Book>Book_list = new ArrayList<>();


    public void BooksAvailable(){
        System.out.println("There are " + Book_list.size() + " books available");
    }


}
