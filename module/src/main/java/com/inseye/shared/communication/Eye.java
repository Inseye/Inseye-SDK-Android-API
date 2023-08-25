package com.inseye.shared.communication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public enum Eye implements Parcelable {
    BOTH(0),
    LEFT(1),
    RIGHT(2);

    public final int value;
    Eye(int intValue) {
        value = intValue;
    }
    public static final Creator<Eye> CREATOR = new Creator<Eye>() {
        @Override
        public Eye createFromParcel(Parcel in) {
            int readValue = in.readInt();
            return Eye.values()[readValue];
        }

        @Override
        public Eye[] newArray(int size) {
            return new Eye[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(value);
    }
}
