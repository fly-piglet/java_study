package DesignMode.structural.adapter;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-17 21:14
 * @Description: 对象适配器
 * 基本思路和类适配器相同只是继承的方式改成组合的方式了，在当前对象中含有来源对象的引用
 */
public class ObjectAdapter implements ObjectAdapterInterface {

    private ObjectSource source;

    public ObjectAdapter(ObjectSource source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.adapterMethod();
    }

    @Override
    public void method2() {
        source.adapterMethod();
    }

    public static void main(String[] args) {
        ObjectSource objectSource = new ObjectSource();
        ObjectAdapterInterface objectAdapterInterface =  new ObjectAdapter(objectSource);
        objectAdapterInterface.method1();
        objectAdapterInterface.method2();
    }
}

class ObjectSource {
    void adapterMethod() {
        System.out.println("需要适配的方法");
    }
}

interface ObjectAdapterInterface {

    void method1();

    void method2();
}