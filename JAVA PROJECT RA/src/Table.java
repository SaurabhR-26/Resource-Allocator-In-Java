import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.jar.Attributes.Name;

public class Table {
    public static void main(String args[]) throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "saur");

        Statement st = con.createStatement();

        // st.executeQuery( "CREATE TABLE RESOURCES(NAME VARCHAR(20) , TYPE VARCHAR(20) , LOCATION VARCHAR(20) , ID NUMBER(10) , SIZE_NEW NUMBER(10) , IS_APPROVED CHAR, IS_AVAILABLE CHAR ,YEAR NUMBER(4) , MONTH NUMBER(2) , DAY NUMBER(2))");

        // st.executeQuery("CREATE TABLE S(ID INT)");

        // st.executeQuery("ALTER TABLE RESOURCES ADD SIZE_NEW NUMBER(10 , 0)");

        // st.executeQuery("DROP TABLE USERS");

        // st.executeQuery("CREATE TABLE USERS(USERNAME VARCHAR2(20), PASSWORD VARCHAR2(20), NAME VARCHAR2(20), CLUB VARCHAR2(20), PRN NUMBER(10))");

        // st.executeQuery("INSERT INTO USERS VALUES('aniket' , 'aniket@123' , 'ANIKET' , 'ACSES', 47)");

        // ResultSet rs = st.executeQuery("INSERT INTO RESOURCES VALUES('CLASSROOM 19', 'CLASSROOM', 'ACADEMIC COMPLEX', 19 , 100 , 'N' , 'Y', null, null , null)");
        // st.executeQuery("INSERT INTO RESOURCES VALUES('MINI CCF', 'LAB', 'CSE DEPT', 1 , 120 , 'N' , 'Y', null, null , null)");
        

        ResultSet rs = st.executeQuery("SELECT * FROM RESOURCES");
        if (rs !=null)
        {
            while(rs.next())
            {
                System.out.println(rs.getString("name")+"\t"+rs.getString("location")+"\t"+rs.getInt("id"));
            }
        }
        
        

        System.out.println("Query executed");
        st.close();
        con.close();
    }
}