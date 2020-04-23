package GiftShop;

import GiftShop.giftview.GiftShop;

public class Books {
    private int id;
    private String name;
    private String author;
    private int qty;
    private double price;

    public Books(int id, String name, String author,  double price, int qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
