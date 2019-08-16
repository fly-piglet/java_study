package DesignMode.creational.factorymethod;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-10 21:36
 * @Description:
 * 优点：增加产品客户端代码修改就好，不需要改后台代码
 * 1. 创建一个工厂，创建一个产品实现类
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Factory factory1 = new FactoryA();
        Product product1 = factory1.getProduct();
        product1.show();

        Factory factory2 = new FactoryB();
        Product product2 = factory2.getProduct();
        product2.show();
    }

}

interface Factory {
    Product getProduct();
}

class FactoryA implements Factory {
    @Override
    public Product getProduct() {
        System.out.println("工厂A生产");
        return new ProductA();
    }
}

class FactoryB implements Factory {
    @Override
    public Product getProduct() {
        System.out.println("工厂B生产");
        return new ProductB();
    }
}

interface Product {
    void show();
}

class ProductA implements Product {
    @Override
    public void show() {
        System.out.println("产品A");
    }
}

class ProductB implements Product {
    @Override
    public void show() {
        System.out.println("产品B");
    }
}
