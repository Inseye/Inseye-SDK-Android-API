package com.inseye.shared.communication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public enum TrackerAvailability implements Parcelable {
    // when adding new values to this enum always add them just before Unavailable
    // old events should never be removed but marked as obsolete instead
    /**
     * Eyetracker is fully functional - gaze data can be provided, new calibration can be started.
     */
    Available,
    /**
     * Eyetracker is physically disconnected from the headset.
     */
    Disconnected,
    /**
     * Eyetracker cannot provide gaze data because calibration is in progress.
     */
    Calibrating,
    /**
     * @deprecated
     * Eyetracker cannot provide gaze data because raw data is read.
     */
    RawData,
    /**
     * @deprecated
     * Eyetracker is unavailable because eyetracker board firmware is being updated.
     */
    FirmwareUpdate,
    /**
     * Eye tracker is connected but is not yet available.
     */
    Unavailable,
    /**
     * Eye tracker is connected but not calibrated and gaze data is not available.
     * Gaze data can be provided after calibration procedure.
     */
    NotCalibrated,
    /**
     * The eyetracker is connected but unavailable for unknown reason.
     * This flag should should only appear if client library is behind service library and new flags were added.
     */
    Unknown; // this flag should always be the last flag in this enum, that's important for CREATOR implementation

    public static final Creator<TrackerAvailability> CREATOR = new Creator<TrackerAvailability>() {
        @Override
        public TrackerAvailability createFromParcel(Parcel in) {
            int ord = in.readInt();
            if (ord >= Unknown.ordinal()) // last element
                return TrackerAvailability.Unknown;
            return TrackerAvailability.values()[ord];
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
