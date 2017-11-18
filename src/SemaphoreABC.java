import java.util.concurrent.Semaphore;

public class SemaphoreABC {

  private Semaphore sa = new Semaphore(1);
  private Semaphore sb = new Semaphore(0);
  private Semaphore sc = new Semaphore(0);

  public static void main(String[] args) {
    System.out.println("Hello World!");
    new SemaphoreABC().printABC();
  }


  /**
   * 信号量协调线程
   */
  public void printABC() {
    new Thread() {
      @Override
      public void run() {
        while (true) {
          try {
            sa.acquire();
            System.out.println("A");
            sb.release();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();

    new Thread() {
      @Override
      public void run() {
        while (true) {
          try {
            sb.acquire();
            System.out.println("B");
            sc.release();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();

    new Thread() {
      @Override
      public void run() {
        while (true) {
          try {
            sc.acquire();
            System.out.println("C");
            sa.release();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();


  }

}
