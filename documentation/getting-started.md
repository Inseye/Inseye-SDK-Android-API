# Getting started
*created by [Mateusz Chojnowski](mailto:mateusz.chojnowski@inseye.com)*

This document contains solution some common scenarios during development of Inseye eye tracker client applications.

# Binding to service

```java
android.content.ServiceConnection connection = ... // implementation of service connection object
Context context = currentActivity.getApplicationContext();
boolean connectedSuccessfully = context.bindService(ServiceConnectionIntentFactory.CreateServiceConnectIntent(context), connection, Context.BIND_AUTO_CREATE);
if (!connectedSuccessfully)
    throw new Exception("Failed to bind to service");
```