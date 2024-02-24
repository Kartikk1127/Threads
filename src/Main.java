public class Main {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("lambda running");
            System.out.println("lambda finished");
        };

        Thread thread = new Thread(runnable);

        thread.start();

    }
}