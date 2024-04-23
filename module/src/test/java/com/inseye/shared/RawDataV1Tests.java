/*
 * Last edit: 13.02.2024, 14:49 by Mateusz Chojnowski mateusz.chojnowski@inseye.com
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared;

import com.inseye.shared.communication.data.RawDataV1;
import static org.junit.Assert.*;
import org.junit.Test;

import java.nio.ByteBuffer;

public class RawDataV1Tests {

    @Test
    public void TestRawDataV1WrittenSize() {
        RawDataV1 data = new RawDataV1();
        ByteBuffer buffer = ByteBuffer.allocate(80);
        int sizeFromType = RawDataV1.SERIALIZER.getSizeInBytes();
        RawDataV1.SERIALIZER.writeToBuffer(data, buffer);
        assertEquals(sizeFromType, buffer.position());
    }
}
