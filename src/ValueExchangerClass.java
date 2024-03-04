
/*
* Java synchronized blocks provide visibility guarantees that are similar to those
* of Java volatile variables.
* When a thread enters a synchronized block, all variables visible to the thread are refreshed from main memory.
* When a thread exits a synchronized block, all variables visible to the thread are written back to main memory.
 *  */

public class ValueExchangerClass {

    private int valA;
    private int valB;
    private int valC;

    public void set(Values v){
        this.valA=v.valA;
        this.valB=v.valB;

        synchronized (this){
            this.valC=v.valC;
        }
    }

    public void get(Values v){
        synchronized (this){
            this.valC=v.valC;
        }
        this.valB=v.valB;
        this.valA=v.valA;
    }
}

/*
* Notice the two synchronized blocks inside the set() and get() method. Notice how
*  the blocks are placed last and first in the two methods.
* In the set() method the synchronized block at the end of the method will
* force all the variables to be synchronized to main memory after being updated.
* This flushing of the variable values to main memory happens when the thread exits
* the synchronized block. That is the reason it has been placed last in the method -
* to guarantee that all updated variable values are flushed to main memory.
*
*
*
*
*
*
*
*
*
* In the get() method the synchronized block is placed at the beginning of the method.
* When the thread calling get() enters the synchronized block, all variables are re-read
* in from main memory. That is why this synchronized block is placed at the beginning of the method - to guarantee that all variables are refreshed from main memory before they are read.*/
