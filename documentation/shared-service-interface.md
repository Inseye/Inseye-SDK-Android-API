# Shared service interface
*created by [Mateusz Chojnowski](mailto:mateusz.chojnowski@inseye.com)*

[ISharedService](../module/src/main/aidl/com/inseye/shared/communication/ISharedService.aidl) defines interface used to bind client application to shared service application.

The main purpose of the interface is to expose information about eye tracker state, give access to eye tracking data to client applications and perform other actions with eye tracker such as calibration.

`ISharedService` implementation in Inseye Service should not throw exceptions, instead all errors are passed explicitly wrapped in return objects such as [ActionResult](../module/src/main/java/com/inseye/shared/communication/ActionResult.java), [IntActionResult](../module/src/main/java/com/inseye/shared/communication/IntActionResult.java) or [StringActionResult](../module/src/main/java/com/inseye/shared/communication/StringActionResult.java).

## Eye tracker state

Eye tracker state can be either queried on demand or client can subscribe to eye tracker state changes.

`getTrackerAvailability` returns current eye tracker state.
Eye tracker can be in one of six states:
- `Available` - eye tracker is connected and ready to start new calibration or streaming gaze data
- `Disconnected` - eye tracker is disconnected from device
- `Calibrating` - eye tracker is in the process of calibration
- `Unavailable` - eye tracker is connected to device but not yet available for use
- `NotCalibrated` - eye tracker is not calibrated. Device must be calibrated before serving gaze data
- `Unknown` - the eyetracker is connected but unavailable for unknown reason. his flag should should only appear if client library is behind service library and new flags were added.

## Calibrating the eye tracker

Eye tracker can be calibrated in two ways.

First (recommended) client application can request service to perform calibration on it's own.

Second (advanced) client can participate in the calibration process by displaying calibration points in areas requested by the service (this case will not be developed further).

`startBuiltInCalibrationProcedure` starts calibration process.
Client can use object returned from this function to cancel calibration procedure.
Service can use object provided by the client as function argument to inform it about calibration result.

## Obtaining gaze data

`startStreamingGazeData` when returns successfully contains broadcast UDP socket port from which gaze data datagrams will be sent.
More about data sent trough UDP socket is in [UDP sockets article](./udp-sockets.md).

`stopStreamingGazeData` informs service that this client doesn't need gaze data port anymore. UPD socket is closed if no more clients request gaze data.

`isStreamingGazeData` gives client information if any application is requesting gaze data and returns gaze data UDP socket port number if gaze data stream is open.



