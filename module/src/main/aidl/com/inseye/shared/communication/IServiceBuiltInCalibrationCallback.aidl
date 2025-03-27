// IServiceBuiltInCalibrationCallback.aidl
package com.inseye.shared.communication;

// Declare any non-default types here with import statements

interface IServiceBuiltInCalibrationCallback {
    /**
    * Informs service that client is aborting calibration procedure and invalidates ICalibrationCallback provided in startCalibration.
    * Returns success if calibration was aborted.
    */
    oneway void abortCalibrationProcedure() = 0;
}