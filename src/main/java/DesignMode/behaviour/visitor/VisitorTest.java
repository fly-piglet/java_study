package DesignMode.behaviour.visitor;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 16:09
 * @Description: 访问者模式把数据结构和用作于结构上的操作解耦，是的操作集合可以自由的演化。适用于数据结构相对稳定算法容易变化的系统。
 *
 */
public class VisitorTest {
    public static void main(String[] args) {
        // 访问者，含有目标数据结构的处理方式
        Visitor visitor = new MyVisitor();
        // 目标数据结构
        Subject subject = new MySubject();
        // 通过访问者来处理某些方法，实现内部算法的替换
        subject.accept(visitor);
    }
}

interface Visitor {
    void visit(Subject subject);
}

class MyVisitor implements Visitor {
    @Override
    public void visit(Subject subject) {
        System.out.println("visit the subject: " + subject.getSubject());
    }
}

interface Subject {
    void accept(Visitor visitor);
    String getSubject();
}

class MySubject implements Subject {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}