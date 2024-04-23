# UDP Sockets

## Gaze data

`startStreamingGazeData` from [ISharedService](../module/src/main/aidl/com/inseye/shared/communication/ISharedService.aidl) returns broadcast UDP port number. Client can listen to provided port for new datagrams with [gaze data](#structure-gazedata).

All data sent through UDP port is serialized in **little-endian** format.

### Data structures

#### Structure `GazeData`

| Name              | Type    | Size (bytes) | Offset (bytes) |
| ----------------- | ------- | ------------ | -------------- |
| Time milliseconds | int64   | 8            | 0              |
| Left X            | float32 | 4            | 8              |
| Left Y            | float32 | 4            | 12             |
| Right X           | float32 | 4            | 16             |
| Right Y           | float32 | 4            | 20             |
| EventTrackerEvent | enum    | 4            | 24             |

Total size: 28 bytes 

Corresponding Java structure: [GazeData.java](../module/src/main/java/com/inseye/shared/communication/GazeData.java)

Enumeration `EyeTrackerEvent`

Serialized as int32.

| Name             | Value       |
| ---------------- | ----------- |
| None             | 0           |
| Blink Left       | 1           |
| Blink Right      | 2           |
| Blink Both       | 3           |
| Saccade          | 4           |
| Headset Mount    | 5           |
| Headset Dismount | 6           |
| Unknown          | 7 (or more) |

Total size: 4 bytes


## Raw data

`startStreamingRawData` from [ISharedService](../module/src/main/aidl/com/inseye/shared/communication/ISharedService.aidl) returns broadcast UDP port number and version of raw data sent through udp port. Client can listen to provided port for new datagrams with [gaze data](#structure-gazedata).


### Data structures

Type of structure depends on number stored in [BinaryStructureActionResult.binaryFormatDataVersion](../module/src/main/java/com/inseye/shared/communication/BinaryStreamActionResult.java).
Whether structure fields format is little-endian or big-endian depends on [BinaryStructureActionResult.byteOrder](../module/src/main/java/com/inseye/shared/communication/BinaryStreamActionResult.java).

#### Structure `RawDataV1`
Valid when `BinaryStructureActionResult.binaryFormatDataVersion` is equal to `1`.

| Name                 | Type   | Size (bytes) | Offset (bytes) |
| -------------------- | ------ | ------------ | -------------- |
| Time milliseconds    | int64  | 8            | 0              |
| Tick time            | uint32 | 4            | 8              |
| Temperature Left     | uint16 | 2            | 12             |
| Temperature Right    | uint16 | 2            | 14             |
| Photo Sensor Left 1  | uint16 | 2            | 16             |
| Photo Sensor Left 2  | uint16 | 2            | 18             |
| Photo Sensor Left 3  | uint16 | 2            | 20             |
| Photo Sensor Left 4  | uint16 | 2            | 22             |
| Photo Sensor Left 5  | uint16 | 2            | 24             |
| Photo Sensor Left 6  | uint16 | 2            | 26             |
| Photo Sensor Right 1 | uint16 | 2            | 28             |
| Photo Sensor Right 2 | uint16 | 2            | 30             |
| Photo Sensor Right 3 | uint16 | 2            | 32             |
| Photo Sensor Right 4 | uint16 | 2            | 34             |
| Photo Sensor Right 5 | uint16 | 2            | 36             |
| Photo Sensor Right 6 | uint16 | 2            | 38             |
| Event                | uint8  | 1            | 40             |

Total size: 41 bytes