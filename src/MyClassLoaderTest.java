public class MyClassLoaderTest {
  public static void main(String[] args)throws ClassNotFoundException{
    MyClassLoader loader1 = new MyClassLoader("loader1","D:temp/");
    loader1.loadClass("Demo");
  }
}
