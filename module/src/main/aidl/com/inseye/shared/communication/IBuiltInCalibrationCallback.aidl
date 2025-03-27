// IBuiltInCalibrationCallback.aidl
package com.inseye.shared.communication;

// Declare any non-default types here with import statements

interface IBuiltInCalibrationCallback {
    /**
    * Informs client that calibration procedure has finished.
    */
    oneway void finishCalibration(boolean success, String errorMessage) = 0;
}