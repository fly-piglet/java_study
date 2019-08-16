package DesignMode.creational.singleton;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-10 22:56
 * @Description: 懒汉，恶汉，双重校验锁，枚举和静态内部类。
 */
public class Singleton {

    // 私有构造函数
    private Singleton() {
    }

    // 1. 懒汉式（非线程安全）
    private static Singleton instance;
    public Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    // 2. 懒汉式(线程安全，锁方法：调用第一次需要后面都不需要)
    public synchronized Singleton getInstanceSync() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // 3. 静态饿汉式
    private static Singleton instance2 = new Singleton();
    public static Singleton getInstance2() {
        return instance2;
    }

    // 4. 饿汉式：静态方法段
    private static Singleton instance3 = null;
    static {
        instance3 = new Singleton();
    }
    public static Singleton getInstance3() {
        return instance3;
    }

    // 5. 静态内部类
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance4() {
        // classloder的机制来保证初始化instance时只有一个线程
        // 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance。
        // 想象一下，如果实例化instance很消耗资源，我想让他延迟加载。
        // 另外一方面，我不希望在Singleton类加载时就实例化，因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化instance显然是不合适的。
        return SingletonHolder.INSTANCE;
    }

    // 6. 枚举
    public Singleton2 getInstance5() {
        // 可以调用静态方法
        Singleton2.INSTANCE.whateverMethod();
        return Singleton2.INSTANCE;
    }

    // 7. 双重检查: 利用内存可见性，和加锁机制来实现
    private static volatile Singleton instance7 = null;
    public Singleton getInstance7() {
        if (instance7 == null) {
            synchronized (Singleton.class) {
                if (instance7 == null) {
                    instance7 = new Singleton();
                }
            }
        }
        return instance7;
    }



}

enum Singleton2 {
    INSTANCE;
    public void whateverMethod() {

    }
}