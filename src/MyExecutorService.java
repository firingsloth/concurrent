import java.util.concurrent.*;

public class MyExecutorService {
  static BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(3);

  public static void main(String[] args) {

    ThreadA threadA = new ThreadA();
    ThreadB threadB = new ThreadB();
    ThreadC threadC = new ThreadC();

    blockingQueue.add(threadA);
    blockingQueue.add(threadB);
    blockingQueue.add(threadC);
    ExecutorService executorService = new ThreadPoolExecutor(5, 10, 2, TimeUnit.MINUTES, blockingQueue, new ThreadPoolExecutor.AbortPolicy());
    for (int i = 0; i < 100; i++) {
      System.out.println(blockingQueue.size());
      executorService.execute(threadA);
      executorService.execute(threadB);
      executorService.execute(threadC);
    }
  }

  public static class ThreadA extends Thread {
    @Override
    public void run() {
      super.run();
      System.out.println(Thread.currentThread().getName() + "A");
    }
  }


  public static class ThreadB extends Thread {
    @Override
    public void run() {
      super.run();
      System.out.println(Thread.currentThread().getName() + "B");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  public static class ThreadC extends Thread {
    @Override
    public void run() {
      super.run();
      System.out.println(Thread.currentThread().getName() + "C");
    }
  }

}
