/*
 * Last edit: 23.04.2024, 11:09 by Mateusz Chojnowski mateusz.chojnowski@inseye.com
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared.communication.data;

import com.inseye.shared.ByteBufferExtensions;
import com.inseye.shared.IByteSerializer;

import java.nio.ByteBuffer;

/**
 * Raw data format sent from Inseye eye tracker.
 */
public final class RawDataV1 {
    public static final int VERSION = 1;
    public static final IByteSerializer<RawDataV1> SERIALIZER = new Serializer();
    public long timeMilli;
    public long tickTime; // uint
    public int temperatureLeft; // ushort
    public int temperatureRight; // ushort
    public int photoSensorLeft1; // ushort
    public int photoSensorLeft2; // ushort
    public int photoSensorLeft3; // ushort
    public int photoSensorLeft4; // ushort
    public int photoSensorLeft5; // ushort
    public int photoSensorLeft6; // ushort
    public int photoSensorRight1; // ushort
    public int photoSensorRight2; // ushort
    public int photoSensorRight3; // ushort
    public int photoSensorRight4; // ushort
    public int photoSensorRight5; // ushort
    public int photoSensorRight6; // ushort
    public byte event;

    private static class Serializer implements IByteSerializer<RawDataV1>
    {

        @Override
        public int getSizeInBytes() {
            // long (8 bytes), uint (4 bytes), 14 ushor (2 bytes each), 1 byte
            return 41;
        }

        @Override
        public void readFromBuffer(RawDataV1 object, ByteBuffer buffer) {
            object.timeMilli = buffer.getLong();
            object.tickTime = ByteBufferExtensions.getUInt(buffer);
            object.temperatureLeft = ByteBufferExtensions.getUShort(buffer);
            object.temperatureRight = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorLeft1 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorLeft2 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorLeft3 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorLeft4 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorLeft5 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorLeft6 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorRight1 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorRight2 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorRight3 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorRight4 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorRight5 = ByteBufferExtensions.getUShort(buffer);
            object.photoSensorRight6 = ByteBufferExtensions.getUShort(buffer);
            object.event = buffer.get();
        }

        @Override
        public void writeToBuffer(RawDataV1 object, ByteBuffer buffer) {
            buffer.putLong(object.timeMilli);
            ByteBufferExtensions.putUInt(buffer, object.tickTime);
            ByteBufferExtensions.putUShort(buffer, object.temperatureLeft);
            ByteBufferExtensions.putUShort(buffer, object.temperatureRight);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorLeft1);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorLeft2);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorLeft3);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorLeft4);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorLeft5);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorLeft6);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorRight1);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorRight2);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorRight3);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorRight4);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorRight5);
            ByteBufferExtensions.putUShort(buffer, object.photoSensorRight6);
            buffer.put(object.event);
        }
    }
}
