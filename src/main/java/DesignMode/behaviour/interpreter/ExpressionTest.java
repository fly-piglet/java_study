package DesignMode.behaviour.interpreter;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 16:45
 * @Description: 解释器模式： 主要在oop开发编译器的时候，适用面比较窄, 用来做各种各样的解释器，正则表达式等解释器
 *
 */
public class ExpressionTest {

    public static void main(String[] args) {
        int interpret = new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8));
        System.out.println(interpret);
    }
}

interface Expression {
    public int interpret(Context context);
}

class Plus implements Expression {
    @Override
    public int interpret(Context context) {
        return context.getNum1() + context.getNum2();
    }
}

class Minus implements  Expression {
    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}

class Context {
    private int num1;
    private int num2;

    public Context(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }
}

