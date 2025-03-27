// ISharedService.aidl
package com.inseye.shared.communication;

import com.inseye.shared.communication.ICalibrationCallback;
import com.inseye.shared.communication.IEyetrackerEventListener;
import com.inseye.shared.communication.IServiceCalibrationCallback;
import com.inseye.shared.communication.Version;
import com.inseye.shared.communication.Eye;
import com.inseye.shared.communication.TrackerAvailability;
import com.inseye.shared.communication.IServiceBuiltInCalibrationCallback;
import com.inseye.shared.communication.IBuiltInCalibrationCallback;
import com.inseye.shared.communication.VisibleFov;

parcelable Eye;
parcelable BinaryStreamActionResult;
parcelable VisibleFov;
/**
* Interface for Inseye Android service.
* Intent used to connect to Android service must be created with factory method.
* @see com.inseye.shared.utils.ServiceConnectionIntentFactor
*/
interface ISharedService {
    /**
    * Returns api version
    */
    Version getApiVersion() = 0;
    /**
    * Generic method that returns binder to requested remote object if available.
    * Service may decide to not return any remote object depending on implementation or metadata stored in bundle,
    * and doesn't depend of internal service version.
    * Lifetime of returned remote object is bound to the lifetime of service binding.
    */
    IBinder getRemoteObject(String className, in Bundle metadata) = 1;
    /**
    * Starts streaming gaze data.
    * If operation is succesful returns address of UDP boradcast port.
    * Multiple calls of this method may return the same address.
    */
    int startStreamingGazeData() = 2;
    /**
    * Informs service that client no longer needs gaze data position.
    */
    oneway void stopStreamingGazeData() = 3;
    /**
    * Returns positive value if service is streaming gaze positions.
    */
    boolean isStreamingGazeData() = 4;
    /**
    * Informs service that client is willing to perform calibration procedure.
    * Client can perform calibration if this method returns succesful action result.
    */
    IServiceCalibrationCallback startCalibrationProcedure(in ICalibrationCallback clientInterface) = 5;
    /**
    * Subscribes to eyetracker events by providing event handler.
    */
    void subscribeToEyetrackerEvents(in IEyetrackerEventListener listener) = 6;
    /**
    * Unsubscribes from eyetracking events.
    * IEyetrackerEventListener provided in subscription can be disposed after this call.
    */
    oneway void unsubscribeFromEyetrackerEvents() = 7;
    /**
    * Returns current tracker availability.
    */
    TrackerAvailability getTrackerAvailability() = 8;
    /**
    * Returns service, calibration and firmware version.
    * If no eye tracker is connected to service is should return 0.0.0-Unknown.
    */
    void getVersions(out Version serviceVersion, out Version firmwareVersion, out Version calibrationVersion) = 9;
    /**
    * Returns dominant eye or both if service was unable to determine which user eye is dominant.
    */
    Eye getDominantEye() = 10;
    /**
    * Informs service that client requires eye tracker calibration using built-in calibration procedure.
    * Client can perform calibration if this method returns successful action result.
    * IServiceBuiltInCalibrationCallback field should not be null if ActionResult is successful.
    */
    IServiceBuiltInCalibrationCallback startBuiltInCalibrationProcedure(in IBuiltInCalibrationCallback clientInterface) = 11;

    VisibleFov getVisibleFov() = 12;

}