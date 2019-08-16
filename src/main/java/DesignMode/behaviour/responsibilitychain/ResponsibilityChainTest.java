package DesignMode.behaviour.responsibilitychain;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 15:07
 * @Description: 居右一个handler接口，有一个操作方法，一个抽象类，一个抽象类含有一个handler，
 * 进行引用，对应使用引用关系来拼接责任链，调用的时候，通过判断上层的handler是否有类，有的话就进行处理
 */
public class ResponsibilityChainTest {

    public static void main(String[] args) {

        MyHandler handler1 = new MyHandler("1");
        MyHandler handler2 = new MyHandler("2");
        MyHandler handler3 = new MyHandler("3");
        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler1.operator();
    }
}

interface Handler2 {
    void operator();
}

abstract class AbstractHandler {

    private Handler2 handler;

    public Handler2 getHandler() {
        return handler;
    }

    public void setHandler(Handler2 handler) {
        this.handler = handler;
    }
}

class MyHandler extends AbstractHandler implements Handler2 {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + "detail");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
