package com.inseye.shared.utils;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;

import com.inseye.shared.R;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Utility class for constructing intent used to connect to remote service.
 */
public final class ServiceConnectionIntentFactory {
    private ServiceConnectionIntentFactory() {}

    /**
     * Name of the filed in extra which holds intent identity.
     */
    public final static String INTENT_EXTRA_IDENTITY_NAME = "Identity";
    /**
     * Name of the filed in extra which holds intent client package name.
     */
    public final static String INTENT_EXTRA_PACKAGE_NAME = "client_package_name";

    /**
     * Name of the action which holds client type
     */
    public final static String LOCAL_CLIENT_BINDER = "local_client_binder";



    /**
     * Utility class that constructs intent that can be used to connect to Android Service.
     * Each intent has distinct unique identifier.
     * Objects returned from this function should not be cached and each bind attempt should
     * be made with new new intent returned from this factory method.
     *
     * @return valid intent that can be used to bind to Inseye Android Service
     */
    @NotNull
    public static Intent CreateServiceConnectIntent(@NotNull Context context)
    {
        Resources res = context.getResources();
        Intent intent = new Intent();
        ComponentName component = new ComponentName(res.getString(R.string.service_package_name), res.getString(R.string.service_class_name));
        intent.setComponent(component);
        UUID uuid = UUID.randomUUID();
        // TODO: Remove this 'if' when minimal client api is bumped to version above 29

        intent.setAction(LOCAL_CLIENT_BINDER);
        intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, context.getPackageName());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            intent.setIdentifier(uuid.toString());
        }
        else {
            intent.putExtra(INTENT_EXTRA_IDENTITY_NAME, uuid.toString());
         }
        return intent;
    }
}
