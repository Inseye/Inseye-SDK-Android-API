package com.inseye.shared.communication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Locale;

/**
 * Datastructures for calibration point
 */
public class CalibrationPoint implements Parcelable {

    /**
     * Gaze horizontal angle position in radians.
     * Angle is measurement of rotation between vector parallel to user gaze direction and normal vector of device (headset) field of view and formed on plane horizontal to device (head) orientation.
     * Value must be in range of (-half of device horizontal field of view, half of device horizontal field of view) where positive value represent rotation of user gaze to the right and negative value correspond to the gaze rotation to the left (from user PoV).
     */
    public float x;
    /**
     * Gaze vertical angle position in radians.
     * Angle is measurement of rotation between vector parallel to user gaze direction and normal vector of device (headset) field of view and formed on plane vertical to device (head) orientation.
     * Value must be in range of (-half of device vertical field of view, half of device vertical field of view) where positive value represent rotation of user gaze up and negative value correspond to the gaze down (from user PoV).
     */
    public float y;

    public CalibrationPoint() {
        x = 0.0f;
        y = 0.0f;
    }
    /**
     * Creates calibration point.
     * @param x horizontal position
     * @param y horizontal position
     */
    public CalibrationPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }


    protected CalibrationPoint(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
    }


    public void readFromParcel(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(x);
        dest.writeFloat(y);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CalibrationPoint> CREATOR = new Creator<CalibrationPoint>() {
        @Override
        public CalibrationPoint createFromParcel(Parcel in) {
            return new CalibrationPoint(in);
        }

        @Override
        public CalibrationPoint[] newArray(int size) {
            return new CalibrationPoint[size];
        }
    };

    @NonNull
    @Override
    public String toString()
    {
        return String.format(Locale.US,"(%.2f, %.2f)",x,y);
    }
}
