package IceCreamShop;

public class IceCreamOrder {
    private String container;
    private String flavor;
    private String scoops;
    private String toppings;
    private double cost;
    public IceCreamOrder(String container, String flavor, String scoops, String toppings, double cost) {
        this.container = container;
        this.flavor = flavor;
        this.scoops = scoops;
        this.toppings = toppings;
        this.cost = cost;
    }

    public String getContainer() {
        return container;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getScoops() {
        return scoops;
    }

    public String getToppings() {
        return toppings;
    }

    public double getCost() {
        return cost;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setScoops(String scoops) {
        this.scoops = scoops;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}