import java.sql.*;

public class DB_Statements {

    // Declare a Statement
    private static Statement stmt = null;


    // Declare a connection
    private static Connection con = DB_Connector.connect();

    // Declare a result set
    private static ResultSet rs = null;

    // Declare a PreparedStatement
    private static PreparedStatement pst = null;


    // Create a method that creates a new Database
    public void createNewDB(String DB_Name) {

        // SQL statement
        String query = "create database if not exists" + DB_Name;


        try{
            // Connection
            stmt = con.createStatement();
            // Execute statement
            stmt.executeUpdate(query);
            System.out.println("\n--Database" + DB_Name +" Created--");
        }

        catch (SQLException ex){
            // Handle SQL exceptions
            System.out.println("\n--Statement did not execute--");
            ex.printStackTrace();
        }
    }
    // Method to use a Database
    public void useDB(String DB_Name){
        // Statement
        String query = "use " + DB_Name;
                try {
                    // Connection
                    stmt = con.createStatement();
                    stmt.executeUpdate(query);
                    System.out.println("\n--Using" + DB_Name +"--");
                }
                catch(SQLException ex){
            // Handle SQL exceptions
                    System.out.println("\n--Query did not execute--");
                    ex.printStackTrace();
                }
    }
    // Method to create a table
    public void createTable(String tableName) {
        String query = "create table if NOT EXISTS " + tableName +
                "(" +
                "id int not null auto_increment, " +
                "myName varchar (28), " +
                "address varchar(28), " +
                "primary key (id)" +
                ")";

        try {
            // Connection
            stmt = con.createStatement();
            // Execute query
            stmt.executeUpdate(query);
            System.out.println("\n--Table " + tableName + " created--");
        } catch (SQLException ex) {
            System.out.println("\n-- Query did not execute --");
            ex.printStackTrace();
        }
    }

        // Method to insert data
        public void insertData(String tableName){
        // SQL statement
            String query = "insert into " +tableName + "(" +
            "myName, address) " +
                    "values ('Douglas', 'My address'), " +
                    "('Bob ', 'His address'), " +
                    "('John', 'Their address') ";
            try {  // Connect
                stmt = con.createStatement();
                //Execute query
                stmt.executeUpdate(query);
                System.out.println("\n--Data inserted into table: " +tableName + "--");
            }
            catch (SQLException ex) {
                System.out.println("\n-- Query did not execute --");
                ex.printStackTrace();
            }



    }
    // Method to read data from table
    public void selectFromTable(String tableName) {
            // SQL Query
        String query = "select * from " +tableName;

        try {
            // Connection
            stmt = con.createStatement();
            // execute statement
            rs = stmt.executeQuery(query);
            System.out.println("\nid\t\tmyName\t\taddress\n_________________________________________");

            // get data

            while(rs.next()){
                int id = rs.getInt(1); // Returns the first column of id
                String myName = rs.getString("myName"); // returns myName info
                String address = rs.getString("address"); // returns address info
                System.out.println(id + "\t\t" + myName + "\t\t" + address);

            }
        }
        catch (SQLException ex){
            System.out.println("\n.- Query did not execute--");
            ex.printStackTrace();
        }
    }
            // Method to check for user credentials
    public Boolean checkLogin(String username, String password){
            boolean check = false;

            String query = "select * from ThisDataBase.user where userName = (?) and password = (?) ";
            try{

                pst = con.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();

               // stmt = con.createStatement();
               // rs = stmt.executeQuery(query);
                while(rs.next()){
                    check = true;
                    System.out.println("\n-- Yey! It works!!--");
                }
                if ( check == false) {
                    System.out.println("\n-- no good--");
                }
            }
            catch (SQLException e) {

                e.printStackTrace();
                return check;
            }

            return check;
    }

}
