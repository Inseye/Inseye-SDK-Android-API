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

import java.util.Arrays;

public enum TrackerAvailability implements Parcelable {
    // when adding new values to this enum always add them just before Unknown
    // old events should never be removed but marked as obsolete instead
    /**
     * Eye tracker is fully functional - gaze data can be provided, new calibration can be started.
     */
    Available(0),
    /**
     * Eye tracker is physically disconnected from the headset.
     */
    Disconnected(1),
    /**
     * Eye tracker cannot provide gaze data because calibration is in progress.
     */
    Calibrating(2),
    /**
     * Eye tracker is connected but is not yet available.
     */
    Unavailable(3),
    /**
     * Eye tracker is connected but not calibrated and gaze data is not available.
     * Gaze data can be provided after calibration procedure.
     */
    NotCalibrated(4),
    /**
     * The eyetracker is connected but unavailable for unknown reason.
     * This flag should should only appear if client library is behind service library and new flags were added.
     */
    Unknown(5); // this flag should always be the last flag in this enum, that's important for CREATOR implementation
    TrackerAvailability(int intValue)
    {
        value = intValue;
    }
    public final int value;
    private static final TrackerAvailability[] valueArray = new TrackerAvailability[Unknown.value+1];
    static {
        Arrays.fill(valueArray, Unknown);
        for(TrackerAvailability trackerAvailability : TrackerAvailability.values()) {
            valueArray[trackerAvailability.value] = trackerAvailability; // values is shorter than valueArray
        }
    }
    public static final Creator<TrackerAvailability> CREATOR = new Creator<TrackerAvailability>() {
        @Override
        public TrackerAvailability createFromParcel(Parcel in) {
            int ord = in.readInt();
            if (ord >= Unknown.value) // check if over last element or deprecated value
                return TrackerAvailability.Unknown;
            return valueArray[ord];
        }

        @Override
        public TrackerAvailability[] newArray(int size) {
            return new TrackerAvailability[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
