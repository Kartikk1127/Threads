
/*
* In the given example, the synchronized keyword in the add and subtract methods means
* that only one thread can execute either of these methods at a time for a specific instance
* of the MyCounter class. This ensures that the shared data (in this case, the count variable)
* is accessed and modified in a thread-safe manner.*/

public class MyCounter {

    private int count=0;

    public synchronized void add(int value){
        this.count+=value;
    }

    public synchronized void subtract(int value){
        this.count-=value;
    }
}

/*
* When a thread enters a synchronized method, it automatically locks the object
* on which the method is called. In this case, each instance of the MyCounter class
* has its own lock. This ensures that if one thread is executing the add method for
* a particular instance, another thread cannot simultaneously execute the add or subtract
* method for the same instance. The synchronization is at the instance level, meaning each
* instance has its own lock.*/

/*
* This mechanism helps prevent data corruption and ensures consistency when multiple threads are
* working with shared resources. It's a way to avoid race conditions and maintain the integrity
* of data in a concurrent programming scenario.*/