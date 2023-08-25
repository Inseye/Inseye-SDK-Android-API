package com.inseye.shared.communication;

import android.os.Parcel;
import android.os.Parcelable;

import com.inseye.shared.IByteSerializer;

public class CalibrationPointResponse implements Parcelable {

    public float x;
    public float y;
    public long displayStartMs;
    public long displayStopMs;

    public CalibrationPointResponse(float x, float y, long displayStartMs, long displayStopMs) {
        this.x = x;
        this.y = y;
        this.displayStartMs = displayStartMs;
        this.displayStopMs = displayStopMs;
    }

    protected CalibrationPointResponse(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
        displayStartMs = in.readLong();
        displayStopMs = in.readLong();
    }

    public static final Creator<CalibrationPointResponse> CREATOR = new Creator<CalibrationPointResponse>() {
        @Override
        public CalibrationPointResponse createFromParcel(Parcel in) {
            return new CalibrationPointResponse(in);
        }

        @Override
        public CalibrationPointResponse[] newArray(int size) {
            return new CalibrationPointResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(x);
        dest.writeFloat(y);
        dest.writeLong(displayStartMs);
        dest.writeLong(displayStopMs);
    }
}
