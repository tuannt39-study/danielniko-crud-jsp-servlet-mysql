package com.daniel.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                final String driver = "oracle.jdbc.driver.OracleDriver";
				final String user_name = "TUAN";
				final String password = "1234";
				final String server_name = "localhost";
				final String port_number = "1521";
				final String sid_number = "xe";
                Class.forName(driver);
                final String db_url = "jdbc:oracle:thin:@" + server_name + ":" + port_number + ":" + sid_number;
                connection = DriverManager.getConnection(db_url, user_name, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
