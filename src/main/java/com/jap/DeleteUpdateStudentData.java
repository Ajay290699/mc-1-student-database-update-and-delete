package com.jap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 */
public class DeleteUpdateStudentData {

    public static void main(String[] args) {
        DeleteUpdateStudentData salesDataDemo = new DeleteUpdateStudentData();
        try {
            salesDataDemo.deleteStudentData();
            salesDataDemo.updateStudentData();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String pass = "Savita@123";
        connection = DriverManager.getConnection(url, user, pass);

        return connection;

    }

    public void deleteStudentData() throws SQLException, ClassNotFoundException {
        // call getConnection() method
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        //execute delete query
        String sql = "delete from student1 where rollNo = 4";
        int rows = statement.executeUpdate(sql);
        System.out.println("rows = " + rows);
    }

    public void updateStudentData() throws SQLException, ClassNotFoundException {
        // call getConnection() method
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        //execute update query
        String sql = "update student1 set Name = 'Bala' where rollNo = 5 and marks = 90";
        int rows = statement.executeUpdate(sql);
        System.out.println("rows = " + rows);
    }
}
