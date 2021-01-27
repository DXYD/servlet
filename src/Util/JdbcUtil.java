package Util;

import bean.Question;

import java.sql.*;
import java.util.List;
import java.util.Queue;

/**
 * @author 28182
 * 数据库工具类，封装jdbc操作的常用功能
 *
 * 在jdbc规范中
 * 1.注册驱动
 *  java.sql.DriverManager接口
 *  Driver
 * 2.连接驱动
 *  java.sql.Connection接口
 * 3.获取sql语句的操作对象/获取交通工具
 *  java.sql.PreparedStatement接口
 * 4.执行sql
 * 5.返回并处理sql结果
 *  java.sql.ResultSet接口
 * 接口的实现类在不同数据库的架包/驱动中
 */
public class JdbcUtil {
    private static String user = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/blog";
    private static String className = "com.mysql.cj.jdbc.Driver";
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * 注册驱动
     * 两种方法
     * 静态语句块
     */
    static {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver 接口实现类被注册了");
    }


    /**
     * 注册驱动获取链接的方法
     * 封装Connection对象创建细节
     */
    public Connection creatConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * 封装PreparedStatement对象创建细节
     */
    public PreparedStatement creatPreparedStatement(String sql) throws SQLException {
        connection = creatConnection();
        ps = connection.prepareStatement(sql);
        return ps;
    }

    /**
     * 封装PreparedStatement对象创建细节
     */
    public ResultSet executeQ(String sql) throws SQLException {
        connection = creatConnection();
        ps = creatPreparedStatement(sql);
        rs = ps.executeQuery();
        return rs;
    }

    /**
     * 销毁conn和ps
     */
    public void close() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
