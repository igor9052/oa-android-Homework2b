package ua.com.igorka.oa.android.homework2b.entity;

import java.io.Serializable;

public interface IFruit extends Serializable{
    String getName();
    void setName(String name);
    int getPrice();
    void setPrice(int price);
}
