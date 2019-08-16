package Collection;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.Iterator;

public class IterableStudy {

    @Test
    public void iterableStudy() {

        System.out.println("初始化");
        MyIteratorList mylist = new MyIteratorList(10);
        for (int i = 0; i < 10; i++) {
            mylist.add(i);
        }

        System.out.println("foreach语法模式");
        for (Integer item: mylist) {
            System.out.println(item);
        }
        
        System.out.println(".foreach模式");
        mylist.forEach(item -> {
            System.out.println(item);
        });

        System.out.println("传统模式");
        Iterator<Integer> iterator = mylist.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }
}

// 自己实现一个迭代器
@Getter
@Setter
class MyIteratorList implements Iterable<Integer> {

    private Integer[] values;

    public MyIteratorList(Integer size) {
        values = new Integer[size];
    }

    public void add(Integer value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                values[i] = value;
                return;
            }
        }
    }

    // public void forEach(Consumer<? super Integer> action) {} 使用默认实现
    // public Spliterator<Integer> spliterator() {} 使用默认实现，jdk8 stream中的并行流才使用的

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    // 初始化的时候，就有在内部的实现类了
    class MyIterator implements Iterator<Integer> {

        /**相当于索引*/
        private int index =0;

        @Override
        public boolean hasNext() {
            return index!=values.length;
        }

        @Override
        public Integer next() {
            return values[index++];
        }

        // public void remove() {} 默认实现不重写
        // public void forEachRemaining(Consumer<? super Integer> action) {} 默认实现不重写
    }


}