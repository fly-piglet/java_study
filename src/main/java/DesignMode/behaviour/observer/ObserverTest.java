package DesignMode.behaviour.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 14:18
 * @Description: 观察者模式
 * 都是类与类之间的关系，不涉及到继承，需要归纳。观察者模式很好理解。类似于邮件订阅和RSS订阅，当对象变化后，会及时通知你，是一对多的关系
 */
public class ObserverTest {

    public static void main(String[] args) {
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();
        Subject subject = new MySubject();
        subject.add(observer1);
        subject.add(observer2);
        // 调用通知
        subject.operation();
        // 得到通知反馈
    }

}

interface Observer {
    void update();
}

class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("recevice 1");
    }
}

class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("recevice 2");
    }
}

interface Subject {
    // 添加观察者
    void add(Observer observer);
    // 删除观察者
    void del(Observer observer);
    // 通知观察者
    void notifyObservers();
    // 自身的操作
    void operation();
}

abstract class AbstractSubject implements Subject {
    // 模板方法，定义通用的方法
    // 观察者列表
    private Vector<Observer> vector = new Vector<>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while (enumo.hasMoreElements()) {
            enumo.nextElement().update();
        }
    }
}

class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update fail！");
        notifyObservers();
    }
}