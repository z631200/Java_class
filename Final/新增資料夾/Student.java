public class Student extends Member{
    private Book [] booklist = new Book [30];

    public Student(String account, String password, String name){
        super(account, password, name);
    }
    public void addBook(Book book){
        int i;
        for(i = 0;i<3;i++){
            if(booklist[i] == null){
                booklist[i] = book;
                break;
            }
        }
    }
    public void removebook(int i){
        booklist[i] = null;
    }
    public Book getBook(int i){
        return booklist[i];
    } 

}
