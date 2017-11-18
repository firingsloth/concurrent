import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionABC {
  ReentrantLock lock = new ReentrantLock();
  Condition conditionA = lock.newCondition();
  Condition conditionB = lock.newCondition();
  Condition conditionC = lock.newCondition();
  private char currentThreadName = 'A';

  public static void main(String[] args) {
    System.out.println("Hello World!");
    new SemaphoreABC().printABC();
  }

  public void printABC() {
    new Thread() {
      public void run() {
        while (true) {
          lock.lock();

          while (true) {
            if (currentThreadName != 'A') {
              try {
                conditionA.await();
              } catch (Exception e) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    }.start();

    new Thread() {
      public void run() {
        while (true) {
          lock.lock();

          while (true) {
            if (currentThreadName != 'B') {
              try {
                conditionA.await();
              } catch (Exception e) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    }.start();

  }
  }
