// IBuiltInCalibrationCallback.aidl
package com.inseye.shared.communication;

// Declare any non-default types here with import statements
import com.inseye.shared.communication.ActionResult;

interface IBuiltInCalibrationCallback {
    /**
    * Informs client that calibration procedure has finished.
    */
    void finishCalibration(in ActionResult calibrationResult) = 0;
}