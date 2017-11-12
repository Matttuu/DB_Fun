import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {
    // Declare a connection
   private static Connection con = null;
   // JDBC Driver
   private static final String DRIVER = "com.mysql.jdbc.Driver";
    // the url = jdbc:dbms://host name:port#/db name
    private static String url = "jdbc:mysql://localhost:3306/mattu_db";
    // user name
    private static String usr = "Mattu";
    // password
    private static String pswrd = "";
    public static Connection connect(){
        System.out.println("\n--Connecting to MySQL JDBC");
        // Locate MySQL JDBC Driver
        try{
            Class.forName(DRIVER);
        }
        // Catch exceptions if JDBC is not found
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
            System.out.println("\n--JDBC Driver is missing--");
        }

        System.out.println("\n--MySQL JDBC Driver found--");


        try {
            // Connect to MySQL DB = URL, usrName, pswrd
            con = DriverManager.getConnection(url, usr, pswrd);
        }

        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("\n--Did not connect try again--");

        }
        // if connecting successful
        if(con != null){
            System.out.println("\n--Connection successful--");
        }else{
            // If connection fails
            System.out.println("\n--Failed to connect--");
        }

        return con;

    }
}
