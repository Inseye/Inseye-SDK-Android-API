/*
 * Last edit: 28.02.2025, 10:14 by Mateusz Chojnowski mateusz.chjojnowski@inseye.com
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

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Version implements Parcelable {

    private int major, minor, patch;
    @NotNull
    private String extra;
    public Version() {
        major = 0;
        minor = 0;
        patch = 0;
        extra = "";
    }

    public Version(int major, int minor, int patch, String extra) {
        if (major < 0)
            throw new IllegalArgumentException("Major version must be greater or equal to zero");
        if (minor < 0)
            throw new IllegalArgumentException("Minor version must be greater or equal to zero");
        if (patch < 0)
            throw new IllegalArgumentException("Patch version must be greater or equal to zero");
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        if (null == extra)
            extra = "";
        this.extra = extra;
    }

    public Version(int major, int minor, int patch) {
        this(major, minor, patch, null);
    }

    /**
     * @return Major version number.
     */
    public int getMajor() {
        return major;
    }

    /**
     * @return Minor version number.
     */
    public int getMinor() {
        return minor;
    }

    /**
     * @return Patch version number.
     */
    public int getPatch() {
        return patch;
    }

    /**
     * @return Version suffix.
     */
    @NotNull
    public String getExtra() {
        return extra;
    }

    public void setMajor(int major) { this.major = major;}
    public void setMinor(int minor) { this.minor = minor;}
    public void setPatch(int patch) { this.patch = patch;}
    public void setExtra(@NonNull String extra) {this.extra = extra;}

    protected Version(Parcel in) {
        major = in.readInt();
        minor = in.readInt();
        patch = in.readInt();
        extra = in.readString();
    }

    public static final Creator<Version> CREATOR = new Creator<Version>() {
        @Override
        public Version createFromParcel(Parcel in) {
            return new Version(in);
        }

        @Override
        public Version[] newArray(int size) {
            return new Version[size];
        }
    };

    /**
     * @return Formated version in form: {major}.{minor}.{path}-{extra}
     */
    @NonNull
    public String toString() {
        String str = major + "." + minor + "." + patch;
        if (!Objects.equals(extra, ""))
            str += "-" + extra;
        return str;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(major);
        dest.writeInt(minor);
        dest.writeInt(patch);
        dest.writeString(extra);
    }

    public void readFromParcel(Parcel in) {
        major = in.readInt();
        minor = in.readInt();
        patch = in.readInt();
        String extraString = in.readString();
        if (null == extraString)
            extraString = "";
        extra = extraString;
    }
}
