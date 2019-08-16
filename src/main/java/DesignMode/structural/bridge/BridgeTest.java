package DesignMode.structural.bridge;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-17 22:21
 * @Description: 桥接就是在具体实现和调用方之间设定一个桥接对象来进行实现调用，可以灵活替换。
 */
public class BridgeTest {

    public static void main(String[] args) {
        TargetInterface targetInterface1 = new TargetInterfaceImpl1();
        Bridge bridge = new Bridge();
        bridge.setSource(targetInterface1);
        bridge.method();

        TargetInterface targetInterface2 = new TargetInterfaceImpl2();
        bridge.setSource(targetInterface2);
        bridge.method();
    }
}

class Bridge {

    private TargetInterface targetInterface;

    public void setSource(TargetInterface targetInterface) {
        this.targetInterface = targetInterface;
    }

    void method() {
        targetInterface.method();
    }
}

interface TargetInterface {
    void method();
}

class TargetInterfaceImpl1 implements TargetInterface {
    @Override
    public void method() {
        System.out.println("实现1");
    }
}

class TargetInterfaceImpl2 implements TargetInterface {
    @Override
    public void method() {
        System.out.println("实现2");
    }
}
