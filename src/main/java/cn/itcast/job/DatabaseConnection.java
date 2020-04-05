package cn.itcast.job;

import java.sql.*;

public class DatabaseConnection {
    private static String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DBURL = "jdbc:mysql://localhost:3306/webspider?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static String DBUSER = "root";
    private static String DBPASSWORD = "123456";


    private Connection connection;

    public DatabaseConnection() throws Exception {
        try {
            Class.forName(DBDRIVER);
            connection = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (Exception e) {
            throw e;
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static void close(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
