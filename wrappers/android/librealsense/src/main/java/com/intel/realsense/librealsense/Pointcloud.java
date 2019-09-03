package com.intel.realsense.librealsense;


public class Pointcloud extends Filter {

    public Pointcloud(){
        mHandle = nCreate(mQueue.getHandle());
    }

    public Pointcloud(StreamType texture){
        mHandle = nCreate(mQueue.getHandle());
        setValue(Option.STREAM_FILTER, texture.value());
    }

    public Pointcloud(StreamType texture, int index){
        mHandle = nCreate(mQueue.getHandle());
        setValue(Option.STREAM_FILTER, texture.value());
        setValue(Option.STREAM_INDEX_FILTER, index);
    }

    public void mapTo(Frame frame) {
        nMapTo(mHandle, frame.mHandle);
    }

    public void calculate(Frame frame, float[] data) {
        nCalculate(getHandle(), frame.mHandle, data);
    }

    private static native long nCreate(long queueHandle);
    private static native void nMapTo(long handle, long mappedHandle);
    private static native void nCalculate(long handle, long frameHandle, float[] data);
}
