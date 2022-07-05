public class Member extends User {
    public final int overduefine = 1;

    public Member(String account, String password, String name){
        super(account, password, name);
    }
}