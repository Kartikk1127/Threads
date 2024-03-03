
/*
* hasNewFrame is set to true before updating the frame. This could lead to a problem when
* the drawing thread is waiting in the while loop of the takeFrame() method. The drawing
* thread might exit the loop, taking the old frame (if hasNewFrame is true) before the
* new frame is assigned. This could result in a situation where the drawing thread draws
* an outdated frame.
*  */

public class FrameExchanger {

    private long framesStoredCount = 0;
    private long framesTakenCount = 0;


    private boolean hasNewFrame = false;

    private Frame frame = null;

    public void storeFrame(){
        this.hasNewFrame = true;
        this.framesStoredCount++;
        this.frame=frame;
    }

    public Frame takeFrame(){
        while (!hasNewFrame){
            //busy wait until new frame arrives
        }
        Frame newFrame = this.frame;
        this.hasNewFrame= false;
        return newFrame;
    }
}
