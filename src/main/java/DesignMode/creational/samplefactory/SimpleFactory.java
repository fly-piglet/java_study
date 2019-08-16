package DesignMode.creational.samplefactory;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-10 21:16
 * @Description:
 * 总体来说，工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
 * 在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，
 * 第三种相对于第二种，不需要实例化工厂类，
 * 所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
 * 静态方法 -》 方法 -》 类型
 * 缺点：增加新产品需要修改代码或者代码创建类型
 */
public class SimpleFactory {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        simpleTypeFactoryTest();
        simpleMethodFactoryTest();
        simpleStaticFacotryTest();
        simpleTypeRefactFactoryTest();
    }

    public static void simpleStaticFacotryTest() {
        System.out.println("简单静态工厂测试");
        Product productA = SimpleStaticFactory.getProductA();
        productA.show();
        Product productB = SimpleStaticFactory.getProductB();
        productB.show();
    }

    public static void simpleMethodFactoryTest() {
        System.out.println("简单方法工厂测试");
        SimpleMethodFacoty factory = new SimpleMethodFacoty();
        Product productA = factory.getProductA();
        productA.show();
        Product productB = factory.getProductB();
        productB.show();
    }

    public static void simpleTypeFactoryTest() {
        System.out.println("简单类型工厂测试");
        SimpleTypeFactory factory = new SimpleTypeFactory();
        Product a = factory.getProduct("A");
        a.show();
        Product b = factory.getProduct("B");
        b.show();
    }

    public static void simpleTypeRefactFactoryTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        System.out.println("反射分支优化测试");
        SimpleTypeRefactFactory factory = new SimpleTypeRefactFactory("A");
        Product product = factory.getProduct();
        product.show();

        SimpleTypeRefactFactory factory2 = new SimpleTypeRefactFactory("B");
        Product product2 = factory2.getProduct();
        product2.show();

        SimpleTypeRefactFactory factory3 = new SimpleTypeRefactFactory("C");
        Product product3 = factory3.getProduct();
        product3.show();
    }
}

class SimpleTypeFactory {
    Product getProduct(String type){
        switch (type) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                return null;
        }
    }
}

class SimpleMethodFacoty {
    Product getProductA(){
        return new ProductA();
    }

    Product getProductB(){
        return new ProductB();
    }
}

class SimpleStaticFactory {
    static Product getProductA(){
        return new ProductA();
    }

    static Product getProductB(){
        return new ProductB();
    }
}

class SimpleTypeRefactFactory {

    private String type;

    public SimpleTypeRefactFactory(String type) {
        this.type = type;
    }

    Product getProduct() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String ClassName = "creational.samplefactory.Product" + type;
        Class<?> clazz = Class.forName(ClassName);
        Product product= (Product)clazz.newInstance();
        return product;
    }
}

interface Product {
    void show();
}

class ProductA implements Product {
    @Override
    public void show() {
        System.out.println("我是A产品");
    }
}

class ProductB implements Product {
    @Override
    public void show() {
        System.out.println("我是B产品");
    }
}

class ProductC implements Product {
    @Override
    public void show() {
        System.out.println("我是C产品");
    }
}
