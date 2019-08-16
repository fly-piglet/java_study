package DesignMode.behaviour.templatemethod;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 13:56
 * @Description: 模板方法模式，通过一个抽象类定义了主要流程，将一些次要流程交给子类来进行模板扩展
 */
public class TemplateMethodTest {

    public static void main(String[] args) {
        AbstractMainClass clazz = new SonMainClassOne();
        clazz.sonProcess();
    }
}

// 抽象类
abstract class AbstractMainClass {

    public final void mainProcess() {
        sonProcess();
    }

    abstract void sonProcess();
}

// 子类1
class SonMainClassOne extends AbstractMainClass {
    @Override
    void sonProcess() {
        System.out.println("子流程1");
    }
}

// 子类2
class SonMainClassTwo extends AbstractMainClass {
    @Override
    void sonProcess() {
        System.out.println("子流程2");
    }
}

