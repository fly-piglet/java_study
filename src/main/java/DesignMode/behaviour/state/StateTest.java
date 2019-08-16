package DesignMode.behaviour.state;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 15:41
 * @Description: 当对象状态改变的时候同时改变行为，但是如何做到呢？
 * 首先要有状态，然后还有对应状态不同的行为，行为有一个接口，针对不同的状态有不同的实现。状态的切换，有一个上下文引用一个状态。
 */
public class StateTest {

    public static void main(String[] args) {
        StateContext stateContext = new StateContext("1");
        stateContext.method1();
        stateContext.method2();

        stateContext.setState("2");
        stateContext.method1();
        stateContext.method2();

    }
}

interface StateAction {
    void method1();
    void method2();
}

class StateOneActionImpl implements StateAction {

    @Override
    public void method1() {
        System.out.println("状态1的实现");
    }

    @Override
    public void method2() {
        System.out.println("状态1的实现");
    }
}

class StateTwoActionImpl implements StateAction {

    @Override
    public void method1() {
        System.out.println("状态2的实现");
    }

    @Override
    public void method2() {
        System.out.println("状态2的实现");
    }
}

class StateContext implements StateAction {
    private StateAction one = new StateOneActionImpl();
    private StateAction two = new StateTwoActionImpl();

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public StateContext(String state) {
        this.state = state;
    }

    private StateAction getImpl() {
        if ("1".equals(state)) {
            return one;
        } else if ("2".equals(state)) {
            return two;
        } else {
            throw new RuntimeException("传入对应的类型");
        }
    }

    @Override
    public void method1() {
        getImpl().method1();
    }

    @Override
    public void method2() {
        getImpl().method2();
    }
}
