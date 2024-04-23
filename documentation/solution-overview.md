# Solution overview
*created by [Mateusz Chojnowski](mailto:mateusz.chojnowski@inseye.com)*

On Android, Inseye SDK communicates with the eye tracker trough another application, called service, working as a middleman between electronics and user application installed on Android OS.
The service application must be installed on the headset and can be downloaded from the [App Center](https://install.appcenter.ms/orgs/remmed/apps/inseye-service-1/distribution_groups/public).

Client application binds to the Android service on demand.

Communication between the service and client application is done through [ISharedService](./shared-service-interface.md) interface.

Most of the communication is done through synchronous or asynchronous (callback based) RPC calls with the exception of sending gaze and raw data from service to client applications which is made through [UDP sockets](./udp-sockets.md).

Communication flow flowchart.
```mermaid
flowchart TD
subgraph eye_tracker_board ["Inseye hardware"]
firmware["Firmware"]
end

subgraph android_device ["Android Device"]
subgraph android_service ["Android Service (closed source)"]
api_lib_service["Inseye-SDK-Android-API"]
end
aidl(["AIDL</br>(rpc calls)"])
udp(["UDP</br>(gaze data)"])
subgraph client_application ["Client Application"]
api_lib_client["Inseye-SDK-Android-API"]
end
end

firmware --- proprietary_protocol(["Proprietary</br>protocol"]) --> android_service
aidl --> api_lib_client
aidl --> api_lib_service
udp --- api_lib_service
udp --> api_lib_client

classDef red fill:#f6546a
class android_device red
class eye_tracker_board red
```