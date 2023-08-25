package com.inseye.shared;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;

public final class IntentLogger {
    private IntentLogger() {}
    public static void LogIntent(String tag, Intent intent)
    {
        if (intent.getAction() != null)
            Log.i(tag, "Action: " +  intent.getAction());
        ComponentName componentName = intent.getComponent();
        if (componentName != null)
        {
            String className = componentName.getClassName() != null ? componentName.getClassName() : "";
            String packageName = componentName.getPackageName() != null ? componentName.getPackageName() : "";
            Log.i(tag, "Component class: " + className + ", package name: " + packageName);
        }
        if (null != intent.getPackage())
            Log.i(tag, "Package: " + intent.getPackage());
    }
}
