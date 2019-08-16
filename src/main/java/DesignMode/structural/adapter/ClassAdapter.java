package DesignMode.structural.adapter;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-17 21:14
 * @Description:
 * 类适配器：通过继承的方式进行接口适配
 * 有一个source类的一个方法需要适配，有一个目标接口，使用adapter类，将source方法扩展到目标接口实现类中。
 * 这样targetTable的实现类就有了source的方法，这种方式前提的是类方法相同的时候
 */
public class ClassAdapter {

    public static void main(String[] args) {
        TargetTable targetTable = new Adapter();
        targetTable.method1();
        targetTable.method2();
    }
}


class Adapter extends Source implements TargetTable {

    @Override
    public void method2() {
        System.out.println("适配另外一个方法的实现");
    }
}

class Source {

    public void method1() {
        System.out.println("source 方法1");
    }

}

interface TargetTable {

    void method1();

    void method2();

}

// 当类不相同的时候
class Source2 {

    void method3() {
        System.out.println("其他的来源方法");
    }
}

// 一样是用类适配器
class Adapter2 extends Source2 implements TargetTable {

    @Override
    public void method1() {
        method3();
    }

    @Override
    public void method2() {
        System.out.println("新的实现");
    }
}
