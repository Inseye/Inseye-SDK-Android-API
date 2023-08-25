package com.inseye.shared;

import org.junit.Test;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ByteBufferExtensionsTests {
    @Test
    public void testUShortPutBigEndian() {
        byte[] expected = {0x1A, 0x2B};
        int number = 6699;
        byte[] arr = new byte[2];
        ByteBuffer buffer = ByteBuffer.wrap(arr);
        buffer.order(ByteOrder.BIG_ENDIAN);
        ByteBufferExtensions.putUShort(buffer, number);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testUShortPutLittleEndian() {
        byte[] expected = {0x2B, 0x1A};
        int number = 6699;
        byte[] arr = new byte[2];
        ByteBuffer buffer = ByteBuffer.wrap(arr);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        ByteBufferExtensions.putUShort(buffer, number);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testUShortGetBigEndian() {

        byte[] arr = {0x1A, 0x2B};
        int expected = 6699;
        ByteBuffer buffer = ByteBuffer.wrap(arr);
        buffer.order(ByteOrder.BIG_ENDIAN);
        int number = ByteBufferExtensions.getUShort(buffer);
        assertEquals(expected, number);
    }

    @Test
    public void testUShortGetLittleEndian() {
        byte[] arr = {0x2B, 0x1A};
        int expected = 6699;
        ByteBuffer buffer = ByteBuffer.wrap(arr);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        int number = ByteBufferExtensions.getUShort(buffer);
        assertEquals(expected, number);
    }

    @Test
    public void testUIntPutBigEndian() {
        byte[] expected = {0x1A, 0x2B, 0x3C, 0x4D};
        int number = 439041101;
        byte[] arr = new byte[4];
        ByteBuffer buffer = ByteBuffer.wrap(arr);
        buffer.order(ByteOrder.BIG_ENDIAN);
        ByteBufferExtensions.putUInt(buffer, number);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testUIntPutLittleEndian() {
        byte[] expected = {0x4d, 0x3C, 0x2B, 0x1A};
        int number = 439041101;
        byte[] arr = new byte[4];
        ByteBuffer buffer = ByteBuffer.wrap(arr);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        ByteBufferExtensions.putUInt(buffer, number);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testUIntGetBigEndian() {

        byte[] arr = {0x1A, 0x2B, 0x3C, 0x4D};
        long expected = 439041101;
        ByteBuffer buffer = ByteBuffer.wrap(arr);
        buffer.order(ByteOrder.BIG_ENDIAN);
        long number = ByteBufferExtensions.getUInt(buffer);
        assertEquals(expected, number);
    }

    @Test
    public void testUIntGetLittleEndian() {
        byte[] arr = {0x4D, 0x3C, 0x2B, 0x1A};
        long expected = 439041101;
        ByteBuffer buffer = ByteBuffer.wrap(arr);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        long number = ByteBufferExtensions.getUInt(buffer);
        assertEquals(expected, number);
    }
}