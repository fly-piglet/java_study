package Collection;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ListStudy {

    @Test
    public void listStudy() {
        // Collection 是一个抽象接口： AbstractCollection 对应抽象类、 AbstractList对应链表中的抽象类、ArrayList 实现类：所以我们拿实现类来演示对应的功能
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        List<String> addList = new ArrayList<>();
        addList.add("12");
        list.addAll(1, addList);
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        });
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        list.get(0);
        list.set(0, "1");
        list.add(0, "");
        list.remove("");
        list.indexOf("");
        list.lastIndexOf("");
        list.listIterator();
        list.listIterator(0);
        list.subList(0, 1);

    }
}

interface MyList extends List<String> {
}

