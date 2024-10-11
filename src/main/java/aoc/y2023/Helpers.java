package aoc.y2023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public interface Helpers {
    static Connection connectDB() throws Exception {
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var props = new Properties();

        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");

        return DriverManager.getConnection(url, props);
    }
}
