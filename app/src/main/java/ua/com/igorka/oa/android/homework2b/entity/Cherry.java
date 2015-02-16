package ua.com.igorka.oa.android.homework2b.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Cherry extends Fruit implements Parcelable {

    private String type;

    public Cherry(String name, String type, int price) {
        super(name, price);
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getName());
        dest.writeString(this.getType());
        dest.writeInt(this.getPrice());
    }

    public static final Parcelable.Creator<Cherry> CREATOR
            = new Parcelable.Creator<Cherry>() {
        public Cherry createFromParcel(Parcel in) {
            return new Cherry(in);
        }

        public Cherry[] newArray(int size) {
            return new Cherry[size];
        }
    };

    private Cherry(Parcel in) {
        this.setName(in.readString());
        this.setType(in.readString());
        this.setPrice(in.readInt());
    }

    @Override
    public String toString() {
        return "Cherry {" +
                "Name: " + this.getName() +
                ", Type: " + type +
                ", Price: " + this.getPrice() +
                '}';
    }
}
