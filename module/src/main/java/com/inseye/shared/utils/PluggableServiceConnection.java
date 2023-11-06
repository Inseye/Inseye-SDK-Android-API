/*
 * Last edit: 27.10.2023, 16:02
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class PluggableServiceConnection implements ServiceConnection {

    private ServiceConnectedDelegate _serviceConnectedDelegate;
    private ServiceDisconnectedDelegate _serviceDisconnectedDelegate;
    private BindingDiedDelegate _bindingDiedDelegate;
    private NullBindingDelegate _nullBindingDelegate;

    public void setServiceConnectedDelegate(@Nullable ServiceConnectedDelegate delegate)
    {
        _serviceConnectedDelegate = delegate;
    }

    public void setServiceDisconnectedDelegate(@Nullable ServiceDisconnectedDelegate delegate)
    {
        _serviceDisconnectedDelegate = delegate;
    }

    public void setBindingDiedDelegate(@Nullable BindingDiedDelegate delegate)
    {
        _bindingDiedDelegate = delegate;
    }

    public void setNullBindingDelegate(@Nullable NullBindingDelegate delegate)
    {
        _nullBindingDelegate = delegate;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        if (null != _serviceConnectedDelegate)
            _serviceConnectedDelegate.onServiceConnected(name, service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        if (null != _serviceDisconnectedDelegate)
            _serviceDisconnectedDelegate.onServiceDisconnected(name);
    }

    @Override
    public void onBindingDied(ComponentName name) {
        if (null != _bindingDiedDelegate)
            _bindingDiedDelegate.onBindingDied(name);
    }

    @Override
    public void onNullBinding(ComponentName name) {
        if (null != _nullBindingDelegate)
            _nullBindingDelegate.onNullBinding(name);
    }
}
