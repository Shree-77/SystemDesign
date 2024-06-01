package LibraryManagement.Users;

import LibraryManagement.Books.Book;

import java.util.ArrayList;
import java.util.List;

public interface User {
     int getID();
     String getName();

     String getPassword();

     void setPassword(String Password);

     void setName(String name);
     void setID(int ID);
}
