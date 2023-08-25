// IEyetrackerEventListener.aidl
package com.inseye.shared.communication;
parcelable TrackerAvailability;

interface IEyetrackerEventListener {
    /**
    * Event raised when eyetracker availability changes.
    */
    void handleTrackerAvailabilityChanged(in TrackerAvailability availability) = 0;
}