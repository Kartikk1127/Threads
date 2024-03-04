
/*
Only one thread can execute inside any of these two methods at the same time.

Had the second synchronized block been synchronized on a different object than MyClass.class,
then one thread could execute inside each method at the same time.*/

public class MySecondClass {

    public static synchronized void log1(String msg1, String msg2){
        System.out.println(msg1);
        System.out.println(msg2);
    }


    public static void log2(String msg1, String msg2){
        synchronized(MySecondClass.class){
            System.out.println(msg1);
            System.out.println(msg2);
        }
    }
}
