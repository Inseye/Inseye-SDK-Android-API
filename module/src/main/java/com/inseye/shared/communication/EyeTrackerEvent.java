/*
 * Last edit: 23.04.2024, 11:09 by Mateusz Chojnowski mateusz.chojnowski@inseye.com
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared.communication;

public enum EyeTrackerEvent {
    // when adding new values to this enum always add them just before Unavailable
    // old events should never be removed but marked as obsolete instead
    /**
     * Nothing particular happened
     */
    NONE,
    /**
     * Left eye is closed or blinked
     */
    BLINK_LEFT,
    /**
     * Right eye is closed or blinked
     */
    BLINK_RIGHT,
    /**
     * Both eye are closed or both eye performed blink
     */
    BLINK_BOTH,
    /**
     * Saccade occurred
     */
    SACCADE,
    /**
     * Headset was put on by the user
     */
    HEADSET_MOUNT,
    /**
     * Headset was put off by the user
     */
    HEADSET_DISMOUNT,
    /**
     * Unknown event that was introduced in later version of service
     */
    UNKNOWN; // this flag should always be the last flag in this enum
    public static EyeTrackerEvent fromInt(int value) {
        if (value >= UNKNOWN.ordinal())
            return UNKNOWN;
        return EyeTrackerEvent.values()[value];
    }
}
