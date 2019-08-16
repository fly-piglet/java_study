package DesignMode.creational.prototype;

import java.io.*;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-10 22:35
 * @Description:
 * 浅拷贝：深拷贝
 *
 */
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        // 浅拷贝，不拷贝引用对象，实现方式继承clone接口
        Product product = new Product("a产品", new Son("孩子1"), new Student("学生2"));
        Product shallowCopyProduct = product.shallowCopy();
        Product deepCopyProduct = product.deepCopy();
        System.out.println("源对象：" + product);
        System.out.println("浅拷贝对象：" + shallowCopyProduct);
        System.out.println("深拷贝对象：" + deepCopyProduct);
        // 深拷贝，拷贝引用对象需要自己实现：
        // 实现方式1.自行遍历对象，并且都实现clone接口，递归克隆覆盖即可
        // 实现方式2.在所有内部对象都实现序列化接口的时候，可以直接先转化为流，在从流中获取对象
    }

}

class Product implements Cloneable,Serializable {
    private String name;
    private Son son;
    private Student student;

    public Product(String name, Son son, Student student) {
        this.name = name;
        this.son = son;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    Product shallowCopy() throws CloneNotSupportedException {
        return (Product)super.clone();
    }

    Product deepCopy() throws IOException, ClassNotFoundException {
        //通过序列化方法实现深拷贝
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(this);
        oos.flush();
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        return (Product)ois.readObject();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", son=" + son +
                ", student=" + student +
                '}';
    }
}

class Son implements Serializable {
    private String name;

    public Son(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student implements Serializable {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


