public class CounterThread extends Thread {

    protected Counter counter = null;

    public CounterThread(Counter counter){
        this.counter = counter;
    }

    public void run(){
        synchronized (Counter.class){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
                counter.add(i);
            }
        }
    }
}
