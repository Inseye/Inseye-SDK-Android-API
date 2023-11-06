/*
 * Last edit: 27.10.2023, 16:14
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared.utils;

import android.content.ComponentName;

public interface BindingDiedDelegate {
    void onBindingDied(ComponentName name);
}
