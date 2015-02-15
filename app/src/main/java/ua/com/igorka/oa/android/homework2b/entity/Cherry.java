package ua.com.igorka.oa.android.homework2b.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Cherry extends Fruit implements Parcelable {

    public Cherry(String name, int price) {
        super(name, price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getName());
        dest.writeInt(this.getPrice());

    }

    public static final Parcelable.Creator<Cherry> CREATOR
            = new Parcelable.Creator<Cherry>() {
        public Cherry createFromParcel(Parcel in) {
            return new Cherry(in) {
            };
        }

        public Cherry[] newArray(int size) {
            return new Cherry[size];
        }
    };

    private Cherry(Parcel in) {
        this.setName(in.readString());
        this.setPrice(in.readInt());
    }}
