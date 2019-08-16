package DesignMode.structural.proxy;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-17 21:52
 * @Description: 静态代理方法
 * 通过实现同样的接口，在接口中持有目标对象的引用，实现在调用方法的时候的上层下层方法调用
 * 代理模式有两种实现方式：
 * 1. jdk动态代理：只有接口才能进行代理，代理的原理是对此接口进行实现类生成，实现类中含有具体目标实现类进行调用
 * 2. cglib动态代理：不管接口，都能进行代理，代理的原理是对类进行子类实现，子类含有具体目标对象，在目标对象前后加入方法进行处理
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        TargetInterfaceImpl impl = new TargetInterfaceImpl();
        TargetInterface targetInterface = new TargetInterfaceProxy(impl);
        targetInterface.method();
    }
}

interface TargetInterface {
    void method();
}

class TargetInterfaceProxy implements TargetInterface {
    private TargetInterfaceImpl impl;

    public TargetInterfaceProxy(TargetInterfaceImpl impl) {
        this.impl = impl;
    }

    @Override
    public void method() {
        before();
        impl.method();
        after();
    }

    private void after() {
        System.out.println("after 方法");
    }

    private void before() {
        System.out.println("before 方法");
    }


}

class TargetInterfaceImpl implements TargetInterface {

    @Override
    public void method() {
        System.out.println("目标对象");
    }
}
