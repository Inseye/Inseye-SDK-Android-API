/*
 * Last edit: 13.02.2024, 14:49 by Mateusz Chojnowski mateusz.chojnowski@inseye.com
 * Copyright (c) Inseye Inc. - All rights reserved.
 *
 * All information contained herein is, and remains the property of
 * Inseye Inc. The intellectual and technical concepts contained herein are
 * proprietary to Inseye Inc. and may be covered by U.S. and Foreign Patents, patents
 * in process, and are protected by trade secret or copyright law. Dissemination
 * of this information or reproduction of this material is strictly forbidden
 * unless prior written permission is obtained from Inseye Inc. Access to the source
 * code contained herein is hereby forbidden to anyone except current Inseye Inc.
 * employees, managers or contractors who have executed Confidentiality and
 * Non-disclosure agreements explicitly covering such access.
 */

package com.inseye.shared;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.inseye.shared", appContext.getPackageName());
    }
}