// IServiceCalibrationCallback.aidl
package com.inseye.shared.communication;

import com.inseye.shared.communication.ActionResult;
import com.inseye.shared.communication.CalibrationPoint;

/**
* Interface implemented by calibration service.
* Methods definded here are invoked the client that is performing calibration procedure.
*/
interface IServiceCalibrationCallback {
    /**
    * Informs service that client is ready to start recieving calibration points.
    * Retuns success if service is willing to continue calibration.
    */
    ActionResult readyToRecieveCalibrationPoint(out CalibrationPoint initialCalibrationPoint) = 0;
    /**
    * Informs service that client is aborting calibration procedure and invalidates ICalibrationCallback provided in startCalibration.
    * Retuns success if calibration was aborted.
    */
    ActionResult abortCalibrationProcedure() = 1;
}