package ua.com.igorka.oa.android.homework2b.entity;

public abstract class Fruit implements IFruit{

    private String name;
    private int price;

    protected Fruit() {
        this("unknown", 0);
    }

    protected Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit {" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
