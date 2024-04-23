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
import org.jetbrains.annotations.NotNull;
import java.nio.ByteOrder;

/**
 * Carries information about data stream opened by service.
 * Object returned from AIDL call.
 */
public class BinaryStreamActionResult implements Parcelable {

    /**
     * Descriptive error message in case of failure.
     */
    public final String errorMessage;

    /**
     * Information if action result carries information about data stream.
     */
    public final boolean success;

    /**
     * Data stream port.
     */
    public final int port;

    /**
     * Version of data structure serialized in stream.
     */
    public final int binaryFormatDataVersion;

    /**
     * Byte order of fields in stream.
     */
    public final ByteOrder byteOrder;

    private BinaryStreamActionResult(boolean success, String errorMessage, int streamPort, int binaryFormatVersion, ByteOrder byteOrder)
    {
        this.success = success;
        this.errorMessage = errorMessage;
        this.port = streamPort;
        this.binaryFormatDataVersion = binaryFormatVersion;
        this.byteOrder = byteOrder;
    }

    private BinaryStreamActionResult(Parcel in) {
        errorMessage = in.readString();
        success = in.readByte() != 0;
        port = in.readInt();
        binaryFormatDataVersion = in.readInt();
        byteOrder = in.readByte() == 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
    }

    public static final Creator<BinaryStreamActionResult> CREATOR = new Creator<BinaryStreamActionResult>() {
        @Override
        public BinaryStreamActionResult createFromParcel(Parcel in) {
            return new BinaryStreamActionResult(in);
        }

        @Override
        public BinaryStreamActionResult[] newArray(int size) {
            return new BinaryStreamActionResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(errorMessage);
        dest.writeByte((byte) (success ? 1 : 0));
        dest.writeInt(port);
        dest.writeInt(binaryFormatDataVersion);
        dest.writeByte((byte) (byteOrder == ByteOrder.LITTLE_ENDIAN ? 0 : 1));
    }

    /**
     * Creates successfully result as BinaryStreamActionResult.
     * @param streamPort data stream port
     * @param binaryFormatDataVersion version of data structure sent in stream
     * @param byteOrder byte order of data in stream
     * @return new instance of BinaryStreamActionResult
     */
    @NotNull
    public static BinaryStreamActionResult success(int streamPort, int binaryFormatDataVersion, ByteOrder byteOrder) {
        return new BinaryStreamActionResult(true, "", streamPort, binaryFormatDataVersion, byteOrder);
    }

    /**
     * Creates failed result as BinaryStreamActionResult.
     * @param errorMessage descriptive error message
     * @return new instance of BinaryStreamActionResult
     */
    @NotNull
    public static BinaryStreamActionResult error(String errorMessage) {
        if (errorMessage == null)
            errorMessage = "";
        return new BinaryStreamActionResult(false, errorMessage, -1, -1, ByteOrder.LITTLE_ENDIAN);
    }
}
