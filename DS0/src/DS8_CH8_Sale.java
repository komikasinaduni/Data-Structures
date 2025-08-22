import java.util.ArrayList;
public class DS8_CH8_Sale {
    public static void sale(ArrayList<DS8_CH8_Item> inventory){
        for(int i = inventory.size()-1; i>=0; i--){
            if(inventory.get(i).getStatus()==DS8_CH8_Item.NORMAL){
                inventory.get(i).setStatus(DS8_CH8_Item.DISCOUNTED);
                inventory.get(i).setPrice(inventory.get(i).getPrice() - inventory.get(i).getPrice()*.3);
            } else if(inventory.get(i).getStatus()==DS8_CH8_Item.DISCOUNTED){
                inventory.get(i).setStatus(DS8_CH8_Item.CLEARANCE);
                inventory.get(i).setPrice(inventory.get(i).getPrice()-inventory.get(i).getPrice()*.5);
            } else if(inventory.get(i).getStatus()==DS8_CH8_Item.CLEARANCE){
                inventory.remove(i);
            }
        }
    }
}
