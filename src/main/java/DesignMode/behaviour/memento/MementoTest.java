package DesignMode.behaviour.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-25 15:25
 * @Description: 备忘录模式，将一个对象的所有数据，做一个数据备份，能够还原，以及重置
 * 三个对象： 1. 具体对象 2. 备忘录数据 3. 备忘录存储
 * // 1. 具体对象中有备忘录的引用创建和还原方法
 */
public class MementoTest {

    public static void main(String[] args) {
        Original original = new Original();
        original.setName("nihao");
        System.out.println(original.getName());
        Memento memento = original.createMemento();
        original.setName("23ho");
        System.out.println(original.getName());
        Storage storage = new Storage(memento);
        original.restoreMemento(storage.getMemento());
        System.out.println(original.getName());
    }
}


class Original {
    @Getter@Setter
    private String name;
    Memento createMemento() {
        return new Memento(name);
    }
    void restoreMemento(Memento memento) {
        this.name = memento.getName();
    }
}


class Memento {
    private String name;
    public Memento(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class Storage {
    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
