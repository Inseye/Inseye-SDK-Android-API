// ISharedService.aidl
package com.inseye.shared.communication;

import com.inseye.shared.communication.ActionResult;
import com.inseye.shared.communication.StringActionResult;
import com.inseye.shared.communication.IntActionResult;
import com.inseye.shared.communication.ICalibrationCallback;
import com.inseye.shared.communication.IEyetrackerEventListener;
import com.inseye.shared.communication.IServiceCalibrationCallback;
import com.inseye.shared.communication.Version;
import com.inseye.shared.communication.Eye;
import com.inseye.shared.communication.TrackerAvailability;
import com.inseye.shared.communication.IServiceBuiltInCalibrationCallback;
import com.inseye.shared.communication.IBuiltInCalibrationCallback;
import com.inseye.shared.communication.VisibleFov;

parcelable StringActionResult;
parcelable IntActionResult;
parcelable Eye;
parcelable BinaryStreamActionResult;
parcelable VisibleFov;

interface ISharedService {
    /**
    * Starts streaming gaze data.
    * If operation is succesful returns address of UDP boradcast port.
    * Multiple calls of this method may return the same address.
    */
    IntActionResult startStreamingGazeData() = 1;
    /**
    * Informs service that client no longer needs gaze data position.
    */
    void stopStreamingGazeData() = 2;
    /**
    * Returns positive value if service is streaming gaze positions at returned UDP port number otherwise returns -1.
    */
    int isStreamingGazeData() = 3;
    /**
    * Informs service that client is willing to perform calibration procedure.
    * Client can perform calibration if this method returns succesful action result.
    * IServiceCalibrationCallback field should not be null if ActionResult is successful.
    */
    IServiceCalibrationCallback startCalibrationProcedure(out ActionResult result, in ICalibrationCallback clientInterface) = 4;
    /**
    * Subscribes to eyetracker events by providing event handler.
    */
    ActionResult subscribeToEyetrackerEvents(in IEyetrackerEventListener listener) = 5;
    /**
    * Unsubscribes from eyetracking events.
    * IEyetrackerEventListener provided in subscription can be disposed after this call.
    */
    void unsubscribeFromEyetrackerEvents() = 6;
    /**
    * Returns current tracker availability.
    */
    TrackerAvailability getTrackerAvailability() = 7;
    /**
    * Returns service and firmware version.
    * If no eye tracker is connected to service is should return 0.0.0-Unknown.
    */
    void getVersions(out Version serviceVersion, out Version firmwareVersion) = 8;
    /**
    * Returns dominant eye or both if service was unable to determine which user eye is dominant.
    */
    Eye getDominantEye() = 9;
    /**
    * @deprecated check tracker availability to get information if gaze data can be provided at given moment, will be removed in Service ver 1.x.x.
    */
    boolean isCalibrated() = 10;

    // Internal API for streaming raw data.
    // Methods from this region may not be implemented in all versions of service and thus, may throw exceptions.

    /**
    * @deprecated use startStreamingRawData, will be removed in Service ver 1.x.x
    * Begins recording raw data.
    */
    ActionResult beginRecordingRawData() = 11;
    /**
    * @deprecated use stopStreamingRawData, will be removed in Service ver 1.x.x
    * Ends recording raw data.
    * If data recording was finished succesfully then path to data file set in dataPath, otherwise dataPath is empty string.
    */
    StringActionResult endRecordingRawData() = 12; // string cannot be out because AIDL says so
    /**
    * Starts streaming raw data.
    * The caller specifies binary format of streamed data.
    * The binary format is one of com.inseye.shared.communication.data.RawDataV{n} where n is data
    * version.
    * If operation is succesful returns address of the UDP boradcast port, data edianess and version
    * of binary data fromat streamed by callee.
    * This method may return stream with binary data format that is different from requested, it's
    * up to the client to decide if it will consume the stream or disconnect from it
    * (by calling stopStreamingRawData).
    * After data stream was started structure of sent data (data structure version and byte order)
    * must not change in the stream until the stream is closed.
    * Multiple calls  of this method by the same caller are considered as valid and may return the
    * same stream port, if the callee returns different port then previously then the caller must
    * asume that previously provided port is invalid.
    *
    * This endpoint may not be implemented in all versions of Inseye Service.
    */
    BinaryStreamActionResult startStreamingRawData(int requestedBinaryDataVersion) = 13;
    /**
    * Signals callee that caller no longer reads streamed data.
    *
    * This endpoint may not be implemented in all versions of Inseye Service.
    */
    void stopStreamingRawData() = 14;
    /**
    * Informs caller if any raw data streaming is already ongoing.
    *
    * This endpoint may not be implemented in all versions of Inseye Service.
    */
    boolean isStreamingRawData() = 15;
    // End of internal API for streaming gaze data.

    /**
    * Informs service that client requires eye tracker calibration using built-in calibration procedure.
    * Client can perform calibration if this method returns successful action result.
    * IServiceBuiltInCalibrationCallback field should not be null if ActionResult is successful.
    */
    IServiceBuiltInCalibrationCallback startBuiltInCalibrationProcedure(out ActionResult result, in IBuiltInCalibrationCallback clientInterface) = 16;

    VisibleFov getVisibleFov() = 17;

}