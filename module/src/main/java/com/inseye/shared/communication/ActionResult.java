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

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Simple information about success of performed operation
 */
public class ActionResult implements Parcelable {

    /**
     * True if remote operation was successful
     */
    public boolean successful;
    /**
     * Optional with reason behind failure
     */
    @NotNull
    public String errorMessage;

    public ActionResult() {
        this(false, "");
    }

    private ActionResult(boolean successful, @NonNull String error) {
        this.successful = successful;
        errorMessage = error;
    }

    protected ActionResult(Parcel in) {
        successful = in.readByte() != 0;
        String message = in.readString();
        if (null == message)
            message = "";
        errorMessage = message;
    }

    public static final Creator<ActionResult> CREATOR = new Creator<ActionResult>() {
        @Override
        public ActionResult createFromParcel(Parcel in) {
            return new ActionResult(in);
        }

        @Override
        public ActionResult[] newArray(int size) {
            return new ActionResult[size];
        }
    };

    public void setSuccessful() {
        this.successful = true;
        this.errorMessage = "";
    }

    public void setError(String errorMessage) {
        if (null == errorMessage)
            errorMessage = "";
        this.successful = false;
        this.errorMessage = errorMessage;
    }

    @NonNull
    @Contract(value = " -> new", pure = true)
    public static ActionResult success() {
        return new ActionResult(true, "");
    }

    @NonNull
    @Contract(pure = true)
    public static ActionResult error(String message) {
        if (message == null)
            message = "";
        return new ActionResult(false, message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (successful ? 1 : 0));
        dest.writeString(errorMessage);
    }

    public void readFromParcel(Parcel reply) {
        successful = reply.readByte() != 0;
        String message = reply.readString();
        if(null == message)
            message = "";
        errorMessage = message;
    }
}
