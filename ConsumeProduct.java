import java.util.*;

public class ConsumeProduct {
  public static void main(String[] args) throws InterruptedException {
   Product prod = new Product(5,0);
   Thread worker = new Thread(() ->{
    try {
        prod.produce();
    } catch (Exception e) {
    }
   });
   Thread consumer = new Thread(() -> {
    try {
        prod.consume();
    } catch (Exception e) {
    }
   });
   worker.start();
   consumer.start();
   worker.join();
   consumer.join();
}
}
class Product {
  private  final  Integer max,min;
  Object lock = new Object();
  int product = 0;
    List<Integer> list = new ArrayList<Integer>();

   Product (int max , int min) {
        this.max = max;
        this.min = min;
    }

  public void produce() throws InterruptedException{ 
    while(true){
      synchronized(lock){
        if(product==max){
          System.out.println("Products stocked to full capacity");
          lock.wait();
        }
        else{
          product++;
          list.add(product);
          System.out.println(product + " is added to the stock");
          lock.notify();
        }
        Thread.sleep(500);
      }
       }   }
      

       public void consume() throws InterruptedException{
        synchronized (lock){
           while(true){
          {
              if(product==min){
                System.out.println("Products stocked to minimum capacity please wait for refill");
                lock.wait();
              }
              else{
                product--;
                System.out.println(list.remove(0)+" is sold Thanks for using our services");
                lock.notify();
              }
              Thread.sleep(500);
          }
        }}
       }


  
}

/*
 *  public void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (container.size() == bottom) {
                    System.out.println("Container empty, waiting for items to be added...");
                    lock.wait();
                } else {
                    System.out.println(container.removeFirst() + " Removed from the container");
                    lock.notify();
                }
                Thread.slee---p(500);
            }
        }
    
 */