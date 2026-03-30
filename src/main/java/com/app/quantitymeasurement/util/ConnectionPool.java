package com.app.quantitymeasurement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static List<Connection> pool = new ArrayList<>();

    static {

        try {

            String url =
                    ApplicationConfig.getProperty("db.url");

            String username =
                    ApplicationConfig.getProperty("db.username");

            String password =
                    ApplicationConfig.getProperty("db.password");

            int size =
                    Integer.parseInt(
                            ApplicationConfig.getProperty("db.pool.size")
                    );

            for(int i = 0 ; i < size ; i++){

                Connection connection =
                        DriverManager.getConnection(
                                url, username, password
                        );

                pool.add(connection);
            }

            //  TABLE CREATE LOGIC ADD
            Connection connection = pool.get(0);

            Statement stmt = connection.createStatement();

            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS quantity_measurement_entity (

                        id INT AUTO_INCREMENT PRIMARY KEY,
                        operand1 VARCHAR(50),
                        operand2 VARCHAR(50),
                        measurement_type VARCHAR(30),
                        operation_type VARCHAR(30),
                        result_value VARCHAR(50),
                        error_flag BOOLEAN,
                        message VARCHAR(255),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    )
                    """);

        }
        catch (Exception e){
            throw new RuntimeException("DB Pool creation failed");
        }

    }

    public static Connection getConnection(){

        if(pool.isEmpty())
            throw new RuntimeException("No DB connections");

        return pool.remove(0);
    }

    public static void releaseConnection(Connection connection){
        pool.add(connection);
    }
}