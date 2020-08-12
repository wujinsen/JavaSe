package cn.wjs.designmodel;
/**
单例对象能保证在一个JVM中，该对象只有一个实例存在
 * @author 吴锦森
 * @date 2016年4月9日
 */
public class SingletonDemo {
	public static void main(String[] args) {

	}
}

class Singleton {
	private  static Singleton s = null;
	//核心是构造方法私有化
	private Singleton(){}
/** 这样的用法，在性能上会有所下降，因为每次调用getInstance()，都要对对象上锁
	public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
 */

	public static Singleton getInstance() {
		if (s == null) {
			synchronized (Singleton.class) {// 加锁，线程安全
				if (s == null) {
					s = new Singleton();
				}
			}
		}
		return s;
	}
/**
 *
	public class Singleton {
    //私有构造方法，防止被实例化
    private Singleton() {}
  	//此处使用一个内部类来维护单例
    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }
    //如果该对象被用于序列化，可以保证对象在序列化前后保持一致
    public Object readResolve() {
        return getInstance();
    }

    其实说它完美，也不一定，如果在构造函数中抛出异常，实例将永远得不到创建，也会出错
}
 */
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return s;
	}
	/**
	 * 第三种实现方法,静态内部类
	 */
	private static class LazyHolder{
		private static final Singleton INSTANCE = new Singleton();
	}
	public static final Singleton getInstance2(){
		return LazyHolder.INSTANCE;
	}
}

/**
 * 也有人这样实现：因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，
 * 单独为创建加synchronized关键字，也是可以的 public class SingletonTest {
public class SingletonTest {

    private static SingletonTest instance = null;

    private SingletonTest() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new SingletonTest();
        }
    }

    public static SingletonTest getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }
}
 */

