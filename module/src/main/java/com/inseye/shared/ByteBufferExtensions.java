package com.inseye.shared;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferExtensions {

    public static void putUShort(ByteBuffer buffer, int value)
    {
        byte firstByte, secondByte;
        if (buffer.order() == ByteOrder.LITTLE_ENDIAN) {
            firstByte = (byte) value;
            secondByte = (byte) (value >> 8);
        }
        else {
            firstByte = (byte) (value >> 8);
            secondByte = (byte) value;
        }
        buffer.put(firstByte);
        buffer.put(secondByte);
    }

    public static int getUShort(ByteBuffer buffer)
    {
        byte firstByte, secondByte;
        if (buffer.order() == ByteOrder.LITTLE_ENDIAN) {
            firstByte = buffer.get();
            secondByte = buffer.get();
        }
        else {
            secondByte = buffer.get();
            firstByte = buffer.get();
        }
        return ((int) firstByte) | (((int) secondByte) << 8);
    }

    public static long getUInt(ByteBuffer buffer)
    {
        byte firstByte, secondByte, thirdByte, fourthByte;
        if(buffer.order() == ByteOrder.LITTLE_ENDIAN) {
            firstByte = buffer.get();
            secondByte = buffer.get();
            thirdByte = buffer.get();
            fourthByte = buffer.get();
        }
        else {
            fourthByte = buffer.get();
            thirdByte = buffer.get();
            secondByte = buffer.get();
            firstByte = buffer.get();
        }
        return ((long) firstByte) | (((long) secondByte) << 8) | (((long) thirdByte) << 16) | (((long) fourthByte) << 24);
    }

    public static void putUInt(ByteBuffer buffer, long value) {
        byte firstByte, secondByte, thirdByte, fourthByte;
        if (buffer.order() == ByteOrder.LITTLE_ENDIAN) {
            firstByte = (byte) value;
            secondByte = (byte) (value >> 8);
            thirdByte = (byte) (value >> 16);
            fourthByte = (byte) (value >> 24);
        }
        else {
            firstByte = (byte) (value >> 24);
            secondByte = (byte) (value >> 16);
            thirdByte = (byte) (value >> 8);
            fourthByte = (byte) (value);
        }
        buffer.put(firstByte);
        buffer.put(secondByte);
        buffer.put(thirdByte);
        buffer.put(fourthByte);
    }
}
