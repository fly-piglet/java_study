package DesignMode.behaviour.command;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 15:16
 * @Description: 命令模式，将命令和职责分离，对应的命令执行不同的处理，逻辑解除耦合
 * 首先要有命令接口，以及一个具体的命令，还有命令的发起者，以及命令的接受者，通过命令里面含有具体执行者对象的引用实现调用
 *
 */
public class CommandTest {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new OneCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}

// 命令接口
interface Command {
    void exec();
}

class OneCommand implements Command {

    private Receiver receiver;

    public OneCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exec() {
        System.out.println("执行命令");
        receiver.operation();
    }
}

class Receiver {

    // 具体的执行命令
    void operation() {
        System.out.println("真是对象执行命令");
    }
}

class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }
    // 执行命令
    void action() {
        command.exec();
    }
}