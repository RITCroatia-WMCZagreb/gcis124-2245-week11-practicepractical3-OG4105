/*
@ASSESSME.USERID: og3150
@ASSESSME.AUTHOR: Omar Gradascevic
@ASSESSME.DESCRIPTION: PRACTICE PRACTICAL 3
@ASSESSME.ANALYZE: YES
*/

public class FunWithThreads3 {

//ON COOMMON COUNTER, TWO THREADS ARE ADDING 1 40,000 times
//The FINAL RESULT SHOULD BE 80,000
// Figure this out on your own Omarr
    private int counter;

    //Constructor of FunWithThreads
    public FunWithThreads3(){


        System.out.println("MAIN START");
        
        Thread t1= new Thread("Thread 1");
        Thread t2= new Thread("Thread 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("COUNTER:" + counter);

        System.out.println("MAIN END");
    }

    public static void main(String[] args) throws Exception {
        
        new FunWithThreads3();

    }

    class MyThread implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<1;i++){
                
            }
        }
        
    }
}
/*  SOLUTION
public class FunWithThreads3 {


    private int counter;
    private Object lock;


    //Constructor of FunWithThreads
    public FunWithThreads3(){
        System.out.println("MAIN START");
        counter=0;
        this.lock = new Object();

        //Creating threads
        Thread t1 = new Thread(new MyThread("1"));
        Thread t2 = new Thread(new MyThread("2"));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("COUNTER:" + this.counter);
        
        System.out.println("MAIN END");
    }

    public static void main(String[] args) throws Exception {
        
        new FunWithThreads3();

    }

    //Inner Thread
    class MyThread implements Runnable{

        private String name="";

        public MyThread(String name){
            this.name = name;
        }

        @Override
        public void run() {

            System.out.println("Thread " + this.name + " starts looping 40000");
            for(int i=0;i<40000;i++){
               synchronized(lock){
                 counter++;//counter = counter + 1;//RACE CONDITION
               }
            }
            System.out.println("Thread " + this.name + " ends");

          
        }

    }

}
    */