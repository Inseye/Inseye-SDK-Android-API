/*
 * Last edit: 02.10.2023, 13:40
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared.communication;

import android.os.Parcel;
import android.os.Parcelable;

public class IntActionResult implements Parcelable {
    public final String errorMessage;
    public final boolean success;
    public final int value;

    private IntActionResult(boolean success, String errorMessage, int value) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.value = value;
    }

    private IntActionResult(Parcel in) {
        errorMessage = in.readString();
        success = in.readByte() != 0;
        value = in.readInt();
    }

    public static final Creator<IntActionResult> CREATOR = new Creator<IntActionResult>() {
        @Override
        public IntActionResult createFromParcel(Parcel in) {
            return new IntActionResult(in);
        }

        @Override
        public IntActionResult[] newArray(int size) {
            return new IntActionResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(errorMessage);
        dest.writeByte((byte) (success ? 1 : 0));
        dest.writeInt(value);
    }

    public static IntActionResult success(int value) {
        return new IntActionResult(true, "", value);
    }

    public static IntActionResult error(String errorMessage) {
        return new IntActionResult(false, errorMessage, 0);
    }
}
