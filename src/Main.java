public class Main {

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("My Runnable thread started");
            System.out.println("My Runnable thread finished");
        }
    }
    public static void main(String[] args) {

        Thread thread = new Thread(new MyRunnable());

        thread.start();
    }
}