/*
 * Last edit: 23.04.2024, 11:09 by Mateusz Chojnowski mateusz.chojnowski@inseye.com
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared.communication;

import android.os.Parcel;
import android.os.Parcelable;

public class StringActionResult implements Parcelable {
    public final String errorMessage;
    public final boolean success;
    public final String value;

    private StringActionResult(boolean success, String errorMessage, String value) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.value = value;
    }

    protected StringActionResult(Parcel in) {
        errorMessage = in.readString();
        success = in.readByte() != 0;
        value = in.readString();
    }

    public static final Creator<StringActionResult> CREATOR = new Creator<StringActionResult>() {
        @Override
        public StringActionResult createFromParcel(Parcel in) {
            return new StringActionResult(in);
        }

        @Override
        public StringActionResult[] newArray(int size) {
            return new StringActionResult[size];
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
        dest.writeString(value);
    }

    public static StringActionResult success(String value) {
        return new StringActionResult(true, "", value);
    }

    public static StringActionResult error(String errorMessage) {
        return new StringActionResult(false, errorMessage, "");
    }
}
