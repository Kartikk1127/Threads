/*
* In case a class contains more than one static synchronized method, only one thread
* can execute inside any of these methods at the same time.
*
* Only one thread can execute inside any of the two add() and subtract() methods at
* any given time. If Thread A is executing add() then Thread B cannot execute neither
* add() nor subtract() until Thread A has exited add().

If the static synchronized methods are located in different classes, then one thread can
* execute inside the static synchronized methods of each class. One thread per class regardless
* of which static synchronized method it calls.*/

public class MyStaticCounter {

    private static int count = 0;

    public static synchronized void add(int value){
        count+=value;
    }

    public static synchronized void subtract(int value){
        count-=value;
    }
}
