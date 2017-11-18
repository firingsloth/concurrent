
public class MyClassLoader extends ClassLoader {
  private String name;//类加载器名称
  private String path;//类加载路径

  public MyClassLoader(String name, String path) {
    /**
     * 设置系统默认父类加载器
     */
    super();
    this.name = name;
    this.path = path;
  }

  public MyClassLoader(ClassLoader parent, String name, String path) {
    /**
     * 设置系统默认父类加载器
     */
    super(parent);
    this.name = name;
    this.path = path;
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    return super.findClass(name);
  }

  @Override
  public Class<?> loadClass(String name) throws ClassNotFoundException {
    return super.loadClass(name);
  }
}
