package DesignMode.behaviour.mediator;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 16:27
 * @Description: 中介者模式用来降低类与类之间的耦合，只关心目标类和中介者类对象的关系就好，具体类类之间的关系及调度交给Mediator就行。有点像spring容器的作用。
 * 也有点想门面模式，具体实现和具体实现由一个层次的引用关系，通过中间层次来解耦
 */
public class MediatorTest {

    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workALl();
    }
}

interface Mediator {

    void createMediator();
    void workALl();
}

class MyMediator implements Mediator {
    private User user1;
    private User user2;

    @Override
    public void createMediator() {
        this.user1 = new User1(this);
        this.user2 = new User2(this);
    }

    @Override
    public void workALl() {
        user1.work();
        user2.work();
    }
}

abstract class User {

    private Mediator mediator;

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void work();
}

class User1 extends User {

    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    void work() {
        System.out.println("user1 exe!");
    }
}

class User2 extends User {
    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    void work() {
        System.out.println("user2 exe!");
    }
}

