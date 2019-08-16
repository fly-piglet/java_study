package DesignMode.creational.abstractfactory;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-10 21:42
 * @Description: 抽象工厂方法
 *
 *
 */
public class AbstractFactory {

    public static void main(String[] args) {
        Factory factory1 = new FactoryA();
        ProductA productA = factory1.getProductA();
        productA.show();
        ProductB productB = factory1.getProductB();
        productB.show();
        
        Factory factory2 = new FactoryB();
        ProductA productA2 = factory2.getProductA();
        productA2.show();
        ProductB productB2 = factory2.getProductB();
        productB2.show();
    }
}


interface Factory {
    ProductA getProductA();
    ProductB getProductB();
}

class FactoryA implements Factory {

    @Override
    public ProductA getProductA() {
        return new FactoryAProductA();
    }

    @Override
    public ProductB getProductB() {
        return new FacotryAProductB();
    }
}

class FactoryB implements Factory {

    @Override
    public ProductA getProductA() {
        return new FacotryBProductA();
    }

    @Override
    public ProductB getProductB() {
        return new FacotryBProductB();
    }
}


interface ProductA {
    void show();
}

class FactoryAProductA implements ProductA {
    @Override
    public void show() {
        System.out.println("工厂A产品A");
    }
}

class FacotryBProductA implements ProductA {
    @Override
    public void show() {
        System.out.println("工厂B产品A");
    }
}

interface ProductB {
    void show();
}

class FacotryAProductB implements ProductB {
    @Override
    public void show() {
        System.out.println("工厂A产品B");
    }
}

class FacotryBProductB implements ProductB {
    @Override
    public void show() {
        System.out.println("工厂B产品B");
    }

}


