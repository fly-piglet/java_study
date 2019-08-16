package DesignMode.structural.facade;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-17 22:00
 * @Description:
 * 外观模式没有涉及到接口，只涉及到类，和类之间的互相管理关系
 * 外观模式门面模式，就是公开一个类，这个类来对外进行处理，而内部具体引用了什么东西，在内部进行处理
 */
public class FacadeTest {

    public static void main(String[] args) {
        Cpu cpu = new Cpu();
        Memory memory = new Memory();
        Disk disk = new Disk();
        Computer computer = new Computer(cpu, memory, disk);
        computer.start();
        computer.shutdown();

    }
}

class Computer {

    private Cpu cpu;
    private Memory memory;
    private Disk disk;

    public Computer(Cpu cpu, Memory memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    void start() {
        System.out.println("电脑开机");
        cpu.start();
        disk.shutdown();
        memory.shutdown();
    }
    void shutdown() {
        System.out.println("电脑关机");
        cpu.shutdown();
        disk.shutdown();
        memory.shutdown();
    }
}

class Disk {

    void start() {
        System.out.println("Disk start");
    }
    void shutdown() {
        System.out.println("Disk stop");
    }
}

class Cpu {

    void start() {
        System.out.println("cpu start");
    }
    void shutdown() {
        System.out.println("cpu stop");
    }
}

class Memory {

    void start() {
        System.out.println("Memory start");
    }
    void shutdown() {
        System.out.println("Memory stop");
    }
}
