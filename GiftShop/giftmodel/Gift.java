package GiftShop.giftmodel;

public class Gift {
    private int ID;
    private int Qty;
    private double Price;
    private String Name;

    public Gift() {
        this.ID = 0;
        this.Name = "";
        this.Price = 0;
        this.Qty = 0;
    }
    public Gift(int ID, int qty, double price, String name) {
        this.ID = ID;
        this.Qty = qty;
        this.Price = price;
        this.Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "GiftController{" +
                "ID=" + ID +
                ", Qty=" + Qty +
                ", Price=" + Price +
                ", Name='" + Name + '\'' +
                '}';
    }
}
