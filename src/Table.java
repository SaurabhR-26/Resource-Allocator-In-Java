package src;

import java.sql.*;
import java.util.jar.Attributes.Name;

public class Table {
    public static void main(String args[]) throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "saur");

        Statement st = con.createStatement();

        // st.updateQuery(
                // "CREATE TABLE RESOURCES(NAME VARCHAR2(20) , TYPE VARCHAR2(20) , LOCATION VARCHAR2(20) , ID NUMBER(10, 0) , SIZE NUMBER(10,0) , IS_APPROVED CHAR(1), IS_AVAILABLE CHAR(1) ,YEAR NUMBER(4,0) , MONTH NUMBER(2,0) , DATE NUMBER(2,0))");

        st.executeQuery("CREATE TABLE RESOURCES(NAME VARCHAR2(20))");
        
        st.close();
        con.close();
    }
}
