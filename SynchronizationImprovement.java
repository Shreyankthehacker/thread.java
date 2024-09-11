public class  SynchronizationImprovement implements Runnable  {

 static int ctr1 = 0 , ctr2 = 0;
 static Object lock1 = new Object();
 static Object lock2 = new Object();
 // if i want to save time i lock the objects individually so that one thread need not wait until it has no relation with the thread which made it to wait


  public static void main (String args[])throws InterruptedException {
   
    Thread one = new Thread(()-> {
      for(int i = 0;i<10000;i++){
        increment1();
      }
    });
    Thread two = new Thread(()-> {
      for(int i = 0;i<10000;i++){
        increment2();
      }
    });

    one.start();
    two.start();
    one.join();
    two.join();
    System.out.println("Final count of ctr1 and ctr2 is "+ctr1 + " " +ctr2);

  }
  public synchronized  static void increment1(){
    synchronized (lock1) {
        ctr1++;
    }
  } 

  public synchronized static void increment2(){
   synchronized (lock2) {
        ctr2++;
   }
  }

  @Override 
  public void run() {

  }

}

