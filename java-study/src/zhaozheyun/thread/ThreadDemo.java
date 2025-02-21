import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
 
public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("ThreadDemo");
        ThreadDemo demo = new ThreadDemo();
        demo.runDemo1();
        demo.runDemo2();
        demo.runDemo3();
    }

    private void runDemo1() {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();
    }

    private void runDemo2() {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> fTask = new FutureTask<>(callableDemo);
        Thread thread = new Thread(fTask);
        thread.start();
        try {
            System.out.println(fTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    private void runDemo3(){
        ThreadDemo3 threadDemo3 = new ThreadDemo3();    
        threadDemo3.start();
    }
    // 线程1
    class RunnableDemo implements Runnable {
        public void run() {
            System.out.println("I am RunnableDemo");
        }
    }

    // 线程2
    class CallableDemo implements Callable<Integer> {
        public Integer call() {
            return 100;
        }
    }
    // 线程3
    class ThreadDemo3 extends Thread {
        public void run (){
            System.out.println("ThreadDemo3");
        }
    }
}
