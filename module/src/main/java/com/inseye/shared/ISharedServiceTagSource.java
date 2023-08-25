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
