/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
<<<<<<< HEAD
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3300/tccGuilhermeGustavo", "root", "1234");
=======
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/futcamps", "root", "");
>>>>>>> da5724c839ee6f7ccbf65b8ba8d34749b71494bf
        } catch (SQLException ex) {
            return null;
        }
    }
}
