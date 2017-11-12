import java.sql.Connection;
import java.sql.SQLException;

public class RunMyShit {

    public static void main(String[] args) throws SQLException{

        // Connection con = DB_Connector.connect();

        //DB_Statements stmts = new DB_Statements();
        //stmts.createNewDB();
        //stmts.useDB("ThisDatabase");
        // stmts.createTable("MyTable");
        //stmts.insertData("MyTable");
        //stmts.selectFromTable("myTable");
        Login_GUI run = new Login_GUI();
    }
}
