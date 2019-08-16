package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述：jdk动态代理实现
 *
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE             PERSON          REASON
 *  1    2018/11/11         wulonghuai      Create
 * ****************************************************************************
 * </pre>
 * @author wulonghuai
 * @since 1.0
 */
public class JDKDynamicProxy {

    // 场景主函数流程
    public static void main(String[] args) {
        // 创建一个jdk动态代理
        JDKProxy proxy = new JDKProxy();
        // 进行代理绑定
        BookFacade bookProxy = (BookFacade)proxy.bind(new BookFacadeImpl());
        //
        bookProxy.addBook();
    }
}

// 定义一个接口
interface BookFacade {
    void addBook();
}

// 定义接口实现类
class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加图书的方法~");
    }
}

// 定义一个jdk动态代理类：对方法进行增强
class JDKProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("事务开始");
        result = method.invoke(target, args);
        System.out.println("事务结束");
        return result;
    }
}