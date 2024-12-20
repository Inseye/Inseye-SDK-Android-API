/*
 * Last edit: 23.04.2024, 11:09 by Mateusz Chojnowski mateusz.chojnowski@inseye.com
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;

/**
 * @deprecated
 * This class is not mandatory part of the library and will be removed.
 */
@Deprecated(forRemoval = true)
public final class IntentLogger {
    private IntentLogger() {}
    /**
     Logs intent into standard android logger.
     */
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
