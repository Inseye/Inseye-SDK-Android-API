/*
 * Last edit: 28.02.2025, 10:14 by Mateusz Chojnowski mateusz.chjojnowski@inseye.com
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared;

import com.inseye.shared.communication.Version;

public final class ApiVersion {
    private ApiVersion() {}

    /**
     * Version of the SDK API.
     */
    public static Version ApiVersion = new Version(1, 0, 0, "rc1dupa");
}
