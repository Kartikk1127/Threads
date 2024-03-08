import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new CounterThread(counter);
        Thread thread2 = new CounterThread(counter);

        thread1.start();
        thread2.start();
    }
}