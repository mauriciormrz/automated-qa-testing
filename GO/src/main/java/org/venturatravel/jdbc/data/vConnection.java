package org.venturatravel.jdbc.data;

import java.sql.*;

class VConnection {

    private static final String JDBC_STAGING_URL = "jdbc:mysql://35.246.236.153:3306/ventura_staging?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_STAGING_USER = "ventura_staging_user";
    private static final String JDB_STAGING_PASS = "P9g1q$04CiVv";

    private static final String JDBC_TEST_URL = "jdbc:mysql://35.246.236.153:3306/ventura_test?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_TEST_USER = "ventura_test_user";
    private static final String JDB_TEST_PASS = "kyFy4iNW0LS2";

    public static Connection getStagingConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_STAGING_URL, JDBC_STAGING_USER, JDB_STAGING_PASS);
    }

    public static Connection getTestConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_TEST_URL, JDBC_TEST_USER, JDB_TEST_PASS);
    }

    public static void close(ResultSet rs){
        try {
            rs.close();
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn){
        try {
            conn.close();
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
