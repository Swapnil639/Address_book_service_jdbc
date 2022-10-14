package com.bridgelabz;

import java.sql.*;

public class AddressBookService {
    public static void main(String[] args) throws SQLException {
        System.out.println("Status of connecting database to java code: ");
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service";
        String userName = "root";
        String password = "Swapnil123";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection done!!");
            Statement statement = connection.createStatement();
            statement.execute("UPDATE  address_book SET conatctType ='family' WHERE firstName='Swapnil'");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM address_book");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstName") + " | " + resultSet.getString("lastName") + " | " + resultSet.getString("address") + " | " + resultSet.getString("city") + " | " + resultSet.getString("state") + " | " + resultSet.getInt("zip") + " | " + resultSet.getInt("phone_Number") + " | " + resultSet.getString("email_id") + " | " + resultSet.getString("bookName") + " | " + resultSet.getString("conatctType"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}