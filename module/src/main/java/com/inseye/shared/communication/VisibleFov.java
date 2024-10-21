package com.inseye.shared.communication;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class VisibleFov implements Parcelable {
    /**
     * Device horizontal field of view in degrees.
     */
    public float horizontal;
    /**
     * Device vertical field of view in degrees.
     */
    public float vertical;

    protected VisibleFov(Parcel in) {
        horizontal = in.readFloat();
        vertical = in.readFloat();
    }

    public VisibleFov(float vfovH, float vFovV) {
        horizontal = vfovH;
        vertical = vFovV;
    }

    public static final Creator<VisibleFov> CREATOR = new Creator<VisibleFov>() {
        @Override
        public VisibleFov createFromParcel(Parcel in) {

            return new VisibleFov(in);
        }

        @Override
        public VisibleFov[] newArray(int size) {
            return new VisibleFov[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeFloat(horizontal);
        parcel.writeFloat(vertical);
    }

    @NonNull
    @Override
    public String toString() {
        return "hFov=" + horizontal + ", vFov=" + vertical;
    }
}
