package Restaurant;

public class OrderItem {

    private String name;
    private String description;
    private double price;
    private int quantity;

    public OrderItem(String name, String desc, double price){
        this.name = name;
        this.description = desc;
        this.price = price;
        this.quantity = 0;
    }

    public String getName(){ return name; }
    public String getDescription(){ return description; }
    public double getPrice(){ return price; }
    public int getQuantity(){ return quantity; }

    public void addQuantity(){ quantity++; }
    public void removeQuantity(){ if(quantity>0) quantity--; }

}