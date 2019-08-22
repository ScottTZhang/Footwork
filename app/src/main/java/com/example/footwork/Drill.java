package com.example.footwork;

import android.os.Parcel;
import android.os.Parcelable;

public class Drill implements Parcelable {
    String title, description;
    Integer imageId;

    public Drill(String t, String d, Integer id) {
        title = t;
        description = d;
        imageId = id;
    }

    protected Drill(Parcel in) {
        title = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            imageId = null;
        } else {
            imageId = in.readInt();
        }
    }

    public static final Creator<Drill> CREATOR = new Creator<Drill>() {
        @Override
        public Drill createFromParcel(Parcel in) {
            return new Drill(in);
        }

        @Override
        public Drill[] newArray(int size) {
            return new Drill[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        if (imageId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageId);
        }
    }
}
