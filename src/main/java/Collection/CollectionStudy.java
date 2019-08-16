package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionStudy {

    @Test
    public void study() {

        // Collection 是一个抽象接口： AbstractCollection 对应抽象类、 AbstractList对应链表中的抽象类、ArrayList 实现类：所以我们拿实现类来演示对应的功能
        Collection<String> collections = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            collections.add(String.valueOf(i));
        }


        // Object对象操作
        Object object = (Object) collections;
        object.getClass(); // 获得类
        object.hashCode(); // 获得hashCode
        object.equals(object); // 相等
        object.toString(); // 转换为字符串
        object.notify(); // 通知
        object.notifyAll(); // 通知所有
        try {
            object.wait(); // 休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Iterator接口操作：循环
        collections.iterator();

        // collection操作: 长度、是否为空、包含、转换为数组、添加数据、删除数据、包含所有、添加所有、删除所有、清楚
        collections.size();
        collections.isEmpty();
        collections.contains(String.valueOf(1));
        collections.toArray();
        collections.toArray(new String[collections.size()]);
        collections.add(String.valueOf(1));
        collections.remove(String.valueOf(1));
        collections.containsAll(collections);
        collections.addAll(collections);
        collections.removeAll(collections);
        collections.clear();
        // jdk8新语法，流式计算、并行计算
        collections.spliterator();
        collections.stream();
        collections.parallelStream();
    }

    private void sout(String function, Object object) {
        System.out.println(function + " : " + object );
    }
}

interface MyCollection extends Collection<String> {
}
