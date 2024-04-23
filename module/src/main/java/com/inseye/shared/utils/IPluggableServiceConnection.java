/*
 * Last edit: 23.04.2024, 11:09 by Mateusz Chojnowski mateusz.chojnowski@inseye.com
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared.utils;
import android.content.ServiceConnection;
import androidx.annotation.Nullable;

public interface IPluggableServiceConnection extends ServiceConnection {
    void setServiceConnectedDelegate(@Nullable ServiceConnectedDelegate delegate);
    void setServiceDisconnectedDelegate(@Nullable ServiceDisconnectedDelegate delegate);
    void setBindingDiedDelegate(@Nullable BindingDiedDelegate delegate);
    void setNullBindingDelegate(@Nullable NullBindingDelegate delegate);

}
