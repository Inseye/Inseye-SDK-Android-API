# Getting started
*created by [Mateusz Chojnowski](mailto:mateusz.chojnowski@inseye.com)*

This document contains solution some common scenarios during development of Inseye eye tracker client applications.

# Binding to service

```java
Activity currentActivity = ... // code that returns current Android Activity
android.content.ServiceConnection connection = ... // implementation of service connection object
Resources res = activity.getResources();
Intent serviceIntent = new Intent();
ComponentName component = new ComponentName(res.getString(R.string.service_package_name), res.getString(R.string.service_class_name)); // service_package_name and service_class_name are defined in this package res/values/strings.xml
serviceIntent.setComponent(component);
boolean connectedSuccessfully = currentActivity.getApplicationContext().bindService(createBindToServiceIntent(currentActivity), connection, Context.BIND_AUTO_CREATE);
if (!connectedSuccessfully)
    throw new Exception("Failed to bind to service");
```