import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.Statement;

 class Conn {

    Connection c;
    Statement s;
    public  Connection getC(){

        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:// /employeemanagementsystem","root","tushar@123");
            s=c.createStatement();
            return c;


        }catch (Exception e){
            e.printStackTrace();
        }
  return c;
    }
}
