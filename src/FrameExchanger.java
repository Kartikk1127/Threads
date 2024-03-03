
/*
To fix this issue, we need to ensure that the update to hasNewFrame and the
assignment of the new frame are treated as an atomic operation, meaning they
should not be reordered. We can use synchronization mechanisms like synchronized
blocks or the volatile keyword.

In this corrected version, the hasNewFrame variable is marked as volatile, ensuring that
changes to it are visible to other threads. Additionally, synchronized blocks are used to
ensure atomicity when updating both frame and hasNewFrame. This prevents the potential
issue of instruction reordering and ensures proper synchronization between the producing
and drawing threads.
*  */

public class FrameExchanger {

    private long framesStoredCount = 0;
    private long framesTakenCount = 0;


    private volatile boolean hasNewFrame = false;

    private Frame frame = null;

    public void storeFrame(){
        synchronized (this){
            this.frame=frame;
            this.framesStoredCount++;
            this.hasNewFrame = true;
        }
    }

    public Frame takeFrame(){
        while (!hasNewFrame){
            //busy wait until new frame arrives
        }
        synchronized (this){
            Frame newFrame = this.frame;
            this.framesTakenCount++;
            this.hasNewFrame= false;
            return newFrame;
        }
    }
}
