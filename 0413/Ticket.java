public class Ticket {
    private int price;
    private String date;
    private String name;
    
    public Ticket(String date, int price){
        setDate(date);
        setPrice(price);
	price = 10;
    }

    public Ticket(String date, String name){
        setDate(date);
        setName(name);
        
    }

    //////

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
    //
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    //
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    //////
    
    public String toString(){
        return getDate() + ((price != 0)? "售出" : "送出") + "一張票。" +  ((price != 0)? "票價:"+getPrice() : "貴賓:"+getName());
    }


}
