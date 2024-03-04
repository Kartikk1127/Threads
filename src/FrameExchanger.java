
/*
when the hasNewFrame variable is set to true, the frame and frameStoredCount
will also be synchronized to main memory. Additionally, every time the drawing
thread reads the hasNewFrame variable in the while-loop inside the takeFrame() method,
the frame and framesStoredCount will also be refreshed from main memory.
Even framesTakenCount will get updated from main memory at this point.
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
