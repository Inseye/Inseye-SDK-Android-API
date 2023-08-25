package com.inseye.shared.communication;

import com.inseye.shared.IByteSerializer;

import java.nio.ByteBuffer;

public class GazeData {

    public static final IByteSerializer<GazeData> SERIALIZER = new Serializer();
    private static class Serializer implements IByteSerializer<GazeData> {

        @Override
        public int getSizeInBytes() {
            // long (8 bytes), 4 floats (4 bytes each), 1 int (4 bytes)
            return 28;
        }

        @Override
        public void readFromBuffer(GazeData object, ByteBuffer buffer) {
            object.timeMilli = buffer.getLong();
            object.left_x = buffer.getFloat();
            object.left_y = buffer.getFloat();
            object.right_x = buffer.getFloat();
            object.right_y = buffer.getFloat();
            object.event = EyeTrackerEvent.fromInt(buffer.getInt());
        }

        @Override
        public void writeToBuffer(GazeData object, ByteBuffer buffer) {
            buffer.putLong(object.timeMilli);
            buffer.putFloat(object.left_x);
            buffer.putFloat(object.left_y);
            buffer.putFloat(object.right_x);
            buffer.putFloat(object.right_y);
            buffer.putInt(object.event.ordinal());
        }
    }
    /**
     * Data creation timestamp in milliseconds.
     */
    public long timeMilli;
    /**
     * Left eye horizontal angle position in radians.
     * Angle is measurement of rotation between vector parallel to user left eye gaze direction and normal vector of device (headset) field of view and formed on plane horizontal to device (head) orientation.
     * Value must be in range of (-half of device horizontal field of view, half of device horizontal field of view) where positive value represent rotation of user gaze to the right and negative value correspond to the gaze rotation to the left (from user PoV).
     */
    public float left_x;
    /**
     * Left eye vertical angle position in radians.
     * Angle is measurement of rotation between vector parallel to user left eye gaze direction and normal vector of device (headset) field of view and formed on plane vertical to device (head) orientation.
     * Value must be in range of (-half of device vertical field of view, half of device vertical field of view) where positive value represent rotation of user gaze up and negative value correspond to the gaze down (from user PoV).
     */
    public float left_y;
    /**
     * Right eye horizontal angle position in radians.
     * Angle is measurement of rotation between vector parallel to user right eye gaze direction and normal vector of device (headset) field of view and formed on plane horizontal to device (head) orientation.
     * Value must be in range of (-half of device horizontal field of view, half of device horizontal field of view) where positive value represent rotation of user gaze to the right and negative value correspond to the gaze rotation to the left (from user PoV).
     */
    public float right_x;
    /**
     * Right eye vertical angle position in radians.
     * Angle is measurement of rotation between vector parallel to user left eye gaze direction and normal vector of device (headset) field of view and formed on plane vertical to device (head) orientation.
     * Value must be in range of (-half of device vertical field of view, half of device vertical field of view) where positive value represent rotation of user gaze up and negative value correspond to the gaze down (from user PoV).
     */
    public float right_y;
    public EyeTrackerEvent event;
}
