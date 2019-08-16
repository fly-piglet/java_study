package Proxy;

/**
 * 描述：静态代理
 * 类A实现接口B，则静态代理类C也实现接口B，并对类A中的方法进行增强
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE             PERSON          REASON
 *  1    2018/11/11         wulonghuai      Create
 * ****************************************************************************
 * </pre>
 * @author wulonghuai
 * @since 1.0
 */
public class StaticProxy {

    // 静态代理实现场景方法
    public static void main(String[] args) {
        // 创建目标对象
        CountImpl countImpl = new CountImpl();
        // 创建代理对象
        Count countProxy = new CountImplProxy(countImpl);
        // 通过代理对象调用目标对象
        countProxy.queryCount();
    }
}

interface Count {
    // 查看账户方法
    void queryCount();
}

class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("查询方法");
    }
}

class CountImplProxy implements Count {

    private CountImpl countImpl;

    public CountImplProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("代理前方法");
        countImpl.queryCount();
        System.out.println("代理后方法");
    }
}
