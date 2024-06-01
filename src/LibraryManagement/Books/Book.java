package LibraryManagement.Books;

public class Book {
   public static int BookId =0;
   private String Name;
   private String Genre;
    private int rate;
    private String authorName;
    private String Categories;
    private  int Seller_id;
    private  int quantity;

    private  int sold =0;

    public Book(int bookId, String name, String genre, int rate, String authorName, String categories , int seller_id, int quantity) {
        BookId = bookId;
        Name = name;
        Genre = genre;
        this.rate = rate;
        this.authorName = authorName;
        Categories = categories;
        this.Seller_id=seller_id;
        this.quantity = quantity;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategories() {
        return Categories;
    }

    public void setCategories(String categories) {
        Categories = categories;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getSeller_id() {
        return Seller_id;
    }

    public void setSeller_id(int seller_id) {
        Seller_id = seller_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return
                "BookId=" + BookId +
                ", Name='" + Name + '\'' +
                ", Genre='" + Genre + '\'' +
                ", rate=" + rate +
                ", authorName='" + authorName + '\'' +
                ", Categories='" + Categories + '\'' +
                ", Seller_id=" + Seller_id +
                ", quantity=" + quantity +
                ", sold=" + sold ;
    }
}
