package DesignMode.structural.decorator;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-17 21:37
 * @Description: 装饰者模式
 * 装饰者模式顾名思义就是在给对象增加新功能的时候，而且是动态的
 * 要求装饰对象和被装饰对象实现同一个接口，装饰对象有被装饰对象的实例
 * 使用场景：
 * 1. 需要扩充一个类的功能
 * 2. 动态为类增加新功能的时候，而且还能动态撤销
 * 缺点：产生过多的相似对象，不易排错
 */
public class DoecoratorTest {

    public static void main(String[] args) {
        Source source = new Source(); // 元对象
        source.method1();
        // 但是要在接口部分使用装饰者模式
        Decorator decorator = new Decorator(source);
        decorator.method1();
        Decorator decorator2 = new Decorator(decorator);
        decorator2.method1();
    }
}

class Decorator implements DecoratorInterface {

    private DecoratorInterface decoratorInterface;

    public Decorator(DecoratorInterface decoratorInterface) {
        this.decoratorInterface = decoratorInterface;
    }

    @Override
    public void method1() {
        System.out.println("装饰方法");
        decoratorInterface.method1();
    }
}

// 非装饰对象
class Source implements DecoratorInterface {
    @Override
    public void method1() {
        System.out.println("原方法");
    }
}

// 装饰接口
interface DecoratorInterface {

    void method1();
}




