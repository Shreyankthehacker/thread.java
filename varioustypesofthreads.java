public class varioustypesofthreads{
  public static void main(String[] args){
    
     // Always jvm creates a main thread then rest of thread counted
     singleTask();
     multipleTask();

  }
 public static void singleTask(){
  SingleTask first = new SingleTask();
  first.start(); // SingleTask
  SingleTask second = new SingleTask();
  second.start(); 
  // Single task multiple thread

  // NOT NECCESSARY FOR first THREAD TO EXECUTE BEFORE secpond ITS ALL LEFT TO JVM
 }
 public static void multipleTask(){
  SingleTask first = new SingleTask();
  first.start(); 
  Doubletask second = new Doubletask();
  second.start();
// Multiple task from multiple thread
 }

}
class SingleTask extends Thread{
    @Override
    public void run(){
      for(int i = 0;i<10000;i++){
      System.out.println("Thread 1");
    }}
}
class Doubletask extends Thread{
  @Override
  public void run(){
    for(int i = 0;i<10000;i++){
      System.out.println("Thread 2 ");
    }
  }
}
// Multiple task from single thread is meaningless