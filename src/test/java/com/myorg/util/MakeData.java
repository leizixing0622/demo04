package com.myorg.util;

import com.github.javafaker.Faker;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class MakeData {

    public void test() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String streetAddress = faker.address().streetAddress();
        System.out.println(name);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(streetAddress);
    }

    public void connectMySQL() {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/spider";
        String user = "root";
        String password = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            for(int i = 0; i < 100; i ++) {
                Faker faker = new Faker();
                PreparedStatement statement = con.prepareStatement("insert " +
                        "into users (name,password,realname,address,status," +
                        "role_id,register_time,register_ip,last_login_time," +
                        "last_login_ip) values (?,?,?,?,?,?,?,?,?,?)");
                statement.setString(1, faker.name().lastName());
                statement.setString(2, "123456");
                statement.setString(3, faker.name().fullName());
                statement.setString(4, faker.address().streetAddress());
                statement.setInt(5, 0);
                statement.setInt(6, 1);
                Date today = new Date();
                statement.setTimestamp(7, new Timestamp(today.getTime()));
                statement.setString(8, "127.0.0.1");
                statement.setTimestamp(9, new Timestamp(today.getTime()));
                statement.setString(10, "127.0.0.1");
                statement.executeUpdate();
            }
            con.close();
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }


    public static void main(String[] args) {
        MakeData makeData = new MakeData();
        makeData.connectMySQL();
    }
}
