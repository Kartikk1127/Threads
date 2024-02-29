import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class MyRunnable implements Runnable{

        private int count = 0;

        @Override
        public void run() {

            for(int i=0;i<1000000;i++){
                this.count++;
            }
            System.out.println(Thread.currentThread().getName()+": "+count);
        }
    }

    public static void main(String[] args) {

        MyRunnable runnable1 = new MyRunnable();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable1);

        thread1.start();
        thread2.start();
    }
}