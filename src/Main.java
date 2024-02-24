public class Main {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
        };

        Thread thread = new Thread(runnable, "The Thread");

        thread.start();

    }
}