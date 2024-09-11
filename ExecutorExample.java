import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* REMEMBER EXECUTOR WORKS IN JAVA COMPILER OF VERSION>=8 ONLY */
public class ExecutorExample {
    public static void main(String[] args) {
        // creating an executor inside a try-with-resources
        try (ExecutorService service = Executors.newCachedThreadPool()) { 
            for (int i = 0; i < 5; i++) {
                service.execute(new Task(i));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle any potential exceptions
        }
    }
}

class Task implements Runnable {
    int taskId;

    Task(int i) {
        taskId = i;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is running successfully in " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the interruption more gracefully
            Thread.currentThread().interrupt();
            System.out.println("Task " + taskId + " was interrupted.");
        }
    }
}
