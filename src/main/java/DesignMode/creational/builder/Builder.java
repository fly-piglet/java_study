package DesignMode.creational.builder;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-10 22:21
 * @Description:
 * 建造者模式主要包含内容：
 * 1. 监督者：监督建造者的组装顺序
 * 2. 抽象建造者：抽象组装流程出来，以及返回具体对象，让监督者可以选择进行建造
 * 3. 建造者：一种具体的按照建造流程的实现
 * 4. 产品：最终建造的产品
 */
public class Builder {
    public static void main(String[] args) {
        Director director1 = new Director(new BuilderAImpl());
        Product product = director1.getProduct();
        System.out.println(product.toString());
        Director directorB = new Director(new BuilderBImpl());
        Product product1 = directorB.getProduct();
        System.out.println(product1.toString());

    }
}

// 监督者，指定创建过程
class Director {

    private AbstractBuilder builder;

    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }

    Product getProduct() {
        // 指定建造过程和顺序
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }
}

abstract class AbstractBuilder {
    Product product = new Product();

    abstract void buildPartA();
    abstract void buildPartB();
    abstract void buildPartC();
    Product getProduct() {
        return product;
    }
}


class BuilderAImpl extends AbstractBuilder {

    @Override
    void buildPartA() {
        product.setPartA("a部分组装方式");
    }

    @Override
    void buildPartB() {
        product.setPartB("a部分组装方式");
    }

    @Override
    void buildPartC() {
        product.setPartC("a部分组装方式");
    }
}

class BuilderBImpl extends AbstractBuilder {

    @Override
    void buildPartA() {
        product.setPartA("a部分，b种组装策略");
    }

    @Override
    void buildPartB() {
        product.setPartB("b部分，b种组装策略");
    }

    @Override
    void buildPartC() {
        product.setPartC("c部分，b种组装策略");
    }
}


class Product {
    String partA;
    String partB;
    String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}
