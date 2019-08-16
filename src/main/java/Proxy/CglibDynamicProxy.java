package Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 描述：cglib动态代理
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE             PERSON          REASON
 *  1    2018/11/11         wulonghuai      Create
 * ****************************************************************************
 * </pre>
 * @author wulonghuai
 * @since 1.0
 */
public class CglibDynamicProxy {

    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        CglibBookFacadeImpl cglibBookFacade = (CglibBookFacadeImpl)cglib.getInstance(new CglibBookFacadeImpl());
        cglibBookFacade.addBook();
    }

}

interface CglibBookFacade {
    public void addBook();
}

class CglibBookFacadeImpl implements CglibBookFacade {
    @Override
    public void addBook() {
        System.out.println("添加图书。。。。");
    }
}

class BookFacadeCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始");
        methodProxy.invokeSuper(o, objects);
        System.out.println("事务结束");
        return null;
    }
}



