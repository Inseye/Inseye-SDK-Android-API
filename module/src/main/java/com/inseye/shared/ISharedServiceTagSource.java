/*
 * Last edit: 02.10.2023, 13:24
 * Copyright (c) Inseye Inc.
 *
 * This file is part of Inseye Software Development Kit subject to Inseye SDK License
 * See  https://github.com/Inseye/Licenses/blob/master/SDKLicense.txt.
 * All other rights reserved.
 */

package com.inseye.shared;

public class ISharedServiceTagSource {
    public final String startStreamingGazeData;
    public final String stopStreamingGazeData;
    public final String isStreamingGazeData;
    public ISharedServiceTagSource(String tagPrefix) {
        startStreamingGazeData = tagPrefix + "_startStreamingGazeData";
        stopStreamingGazeData = tagPrefix + "_stopStreamingGazeData";
        isStreamingGazeData = tagPrefix + "_isStreamingGazeData";
    }

}
