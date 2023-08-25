// ICalibrationCallback.aidl
package com.inseye.shared.communication;

// Declare any non-default types here with import statements
import com.inseye.shared.communication.CalibrationPoint;
import com.inseye.shared.communication.CalibrationPointResponse;
import com.inseye.shared.communication.ActionResult;

parcelable CalibrationPointResponse;

/**
* Interface implemented by calibration client. Methods definded here are invoked by the service.
*/
interface ICalibrationCallback {
    /**
    * Informs client that next point should be displayed immedietly at given position.
    * Retunrs information about previous point display position and time window.
    */
    CalibrationPointResponse showNextCalibrationPoint(in CalibrationPoint nextPoint) = 0;
    /**
    * Informs client that calibration procedure has finished.
    */
    void finishCalibration(in ActionResult calibrationResult) = 1;
}