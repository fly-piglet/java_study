package DesignMode.structural.adapter;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-17 21:14
 * @Description: 接口适配器
 *
 *
 */
public class InterfaceAdapter extends SourceWarper {

    @Override
    public void method1() {
        System.out.println("实现方法1");
    }

    public static void main(String[] args) {
        SourceInterface sourceInterface = new InterfaceAdapter();
        sourceInterface.method1();
        sourceInterface.method2();
    }
}

interface SourceInterface {
    void method1();
    void method2();
}

abstract class SourceWarper implements SourceInterface {
    @Override
    public void method1() {
        System.out.println("默认方法2实现");
    }

    @Override
    public void method2() {
        System.out.println("默认方法2实现");
    }
}
