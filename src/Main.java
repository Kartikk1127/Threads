public class Main {


    public static void main(String[] args) {

        // create runnable and create and start a virtual thread
        Runnable runnable = ()->{
          for (int i=0;i<10;i++){
              System.out.println("Index: " + i);
          }
        };

        Thread vThread1 = Thread.ofVirtual().start(runnable);

        //create but do not start virtual thread
        Thread vThreadUnstarted = Thread.ofVirtual().unstarted(runnable);

        vThreadUnstarted.start();

        //how to join a virtual thread
        try {
            vThreadUnstarted.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}