package DesignMode.structural.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @Auther: wulonghuai
 * @Date: 2019-03-17 22:38
 * @Description: 享元模式，就是类似数据库连接池的模式，当内存中对象多的时候，又不是每个都使用到的时候，就可以创建对象池子
 * 抽取重复，节省空间，减少实例数量
 */
public class FilweightTest {
}

class MyConectionPool {

    private Vector<Connection> pool;

    // 公有属性
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "root";
    private String driverDriverName = "com.mysql.jdbc.Driver";

    private int poolSize = 100;
    private static MyConectionPool instance = null;
    Connection connection = null;

    private MyConectionPool() {
        pool = new Vector<>();

        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driverDriverName);
                connection = DriverManager.getConnection(url, username, password);
                pool.add(connection);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void release() {
        pool.add(connection);
    }

    public synchronized Connection getConnection() {
        if (poolSize > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        } else {
            return null;
        }
    }
}