package DesignMode.behaviour.iterator;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 14:35
 * @Description: 迭代器模式就是讲循环不依赖与具体的实现类，将循环和获取的逻辑抽象出来，目标类实现对应的接口，就实现了循环功能。
 */
public class IteratorTest {

    public static void main(String[] args) {
        MyCollection collection = new MyCollection();
        Interator itreator = collection.itreator();
        System.out.println(itreator.next());
        System.out.println(itreator.next());
        System.out.println(itreator.first());
        System.out.println(itreator.next());
        while (itreator.hasNext()) {
            System.out.println(itreator.next());
        }
    }
}

interface Collection {
    Interator itreator();
   // 取得集合元素
    Object get(int i);
    // 获取集合的大小
    int size();
}

interface Interator {
    Object previous();
    Object next();
    boolean hasNext();
    Object first();
}

class MyInterator implements Interator {

    private Collection collection;
    private int pos = -1;

    public MyInterator(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if (pos > 0) {
            pos --;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if (pos < collection.size() -1 ) {
            pos ++;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if (pos < collection.size() -1 ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object first() {
        pos = 0;
        return collection.get(pos);
    }
}

class MyCollection implements Collection {

    String string[] = {"A", "B", "C", "D", "E"};

    @Override
    public Interator itreator() {
        return new MyInterator(this);
    }

    @Override
    public Object get(int i) {
        return string[i];
    }

    @Override
    public int size() {
        return string.length;
    }
}