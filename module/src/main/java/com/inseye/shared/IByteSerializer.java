/*
 * Last edit: 28.02.2025, 10:14 by Mateusz Chojnowski mateusz.chjojnowski@inseye.com
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared;

import java.nio.ByteBuffer;

public interface IByteSerializer<T> {
    /**
     * Must return constant value.
     * @return size of serialized struct in number of bytes
     */
    int getSizeInBytes();

    /**
     * Reads data from buffer and writes deserialized value to provided object.
     * @param object writable object
     * @param buffer source buffer
     */
    void readFromBuffer(T object, ByteBuffer buffer);

    /**
     * Serializes object and writes to buffer.
     * @param object readable object
     * @param buffer target buffer
     */
    void writeToBuffer(T object, ByteBuffer buffer);
}
