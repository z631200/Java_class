public class Regular_Ticket {
    private int price;
    private int quantity;

    public Regular_Ticket(int p, int q){
        setPrice(p);
        setQuantity(q);
    }

    public void sales(int q){
        quantity += q;
    }

    public void setPrice(int p){price = p;}
    public int getPrice(){return price;}

    public void setQuantity(int q){quantity = q;}
    public int getQuantity(){return quantity;}

    

    public String toString(){
        return "Regular ticket 累計銷售金額達 " + getPrice()*getQuantity() + "元";
    }
}
