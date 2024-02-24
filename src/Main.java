public class Main {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable running");
                System.out.println("runnable finished");
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

    }
}