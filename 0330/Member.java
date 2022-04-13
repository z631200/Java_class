public class Member {
    private String name; //"private" = only use in this class
    private double income;

    public String getName(){ return name;}
    public double getIncome(){ return income;}
    public void setName(String n){name=n;}
    public void setIncome(double i){income=i;}

    public Member (String name, double income){
        setName(name);
        setIncome(income); 
    }
    //without void/string/int... , "Member" seem to be asked have same name as "class name(Member)"
   
  
    public String toString(){
        return "Name: "+getName()+"\tIncome: "+getIncome()+"\t   Membership fee: "+payFee();
    }

    public double payFee(){
        return getIncome()*0.05;
    }
}
