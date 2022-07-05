import java.util.*;

public class Book{
    private String title;
    private String author;
    private String publisher;
    private String theme;
    private boolean state;
    private Date borrowDate;
    private Date returnDate;
    
    public Book(String title, String author, String publisher, String theme){
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setTheme(theme);
        setState(false);
    }

    public void setTitle(String title){this.title = title;}
    public String getTitle(){return title;}
    public void setAuthor(String author){this.author = author;}
    public String getAuthor(){return author;}
    public void setPublisher(String publisher){this.publisher = publisher;}
    public String getPublisher(){return publisher;}
    public void setTheme(String theme){this.theme = theme;}
    public String getTheme(){return theme;}
    public void setState(boolean state){this.state = state;}
    public boolean getState(){return state;}
    public void setBorrowDate(Date borrowDate){this.borrowDate = borrowDate;}
    public Date getBorrowDate(){return borrowDate;}
    public void setReturnDate(Date returnDate){this.returnDate = returnDate;}
    public Date getReturnDate(){return returnDate;}
}