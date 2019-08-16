package DesignMode.behaviour.strategy;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 14:02
 * @Description: 定义不同的算法实现策略，在客户端调用的时候，指定对应的实现算法，进行调用
 * 定义了一系列的算法，并且将算法封装起来，使他们之间可以互相替换，设计一个接口，多个实现类实现接口算法，提供一个抽象类，提供辅助函数。
 */
public class StrategyTest {

    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        // 还有一种方式，就是讲接口传递进去，具体接口是实现类，实习类就可以自己指定不同的策略
        System.out.println(result);
    }
}

interface ICalculator {
    int calculate(String exp);
}

abstract class AbstractCalulator {

    int[] split(String exp, String opt) {
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[0] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}

class Plus extends AbstractCalulator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\+");
        return arrayInt[0]+arrayInt[1];
    }
}


