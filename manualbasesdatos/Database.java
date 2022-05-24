package manualbasesdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Database {
    
    public static void crearTabla(){
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:basehotel.db");
         System.out.println("Abierta la DB ");

         stmt = c.createStatement();
         String sql = "CREATE TABLE USUARIOS " +
                        "(DNI TEXT PRIMARY KEY     NOT NULL," +
                        "NOMBRE           TEXT," + 
                        "APELLIDO         TEXT," + 
                        "SEGUNDOAPELLIDO        TEXT," + 
                        "TELEFONO         TEXT)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("La operación fue un exito");
    }
    
    public static void insertar(String dni, String nombre, String apellido, String segundoapellido, String telefono){
        Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:basehotel.db");
         c.setAutoCommit(false);
         System.out.println("Abierta la base de datos");

         stmt = c.createStatement();
         String sql = "INSERT INTO USUARIOS (DNI,NOMBRE,APELLIDO,SEGUNDOAPELLIDO,TELEFONO) " +
                        "VALUES (\'"+ dni + "\', \'" + nombre + "\', \'" + apellido +"\', \'" + segundoapellido +"\', \'" + telefono +"\');";
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("La operación fue un exito");
    }
    
    public static void consultar(){
        
        Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:basehotel.db");
      c.setAutoCommit(false);
      System.out.println("La operación fue un exito");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
      
      while ( rs.next() ) {
         String dni2 = rs.getString("dni");
         String  nombre = rs.getString("nombre");
         String apellido  = rs.getString("apellido");
         String  segundoapellido = rs.getString("segundoapellido");
         String telefono = rs.getString("telefono");         
         System.out.println( "DNI = " + dni2 );
         System.out.println( "NOMBRE = " + nombre );
         System.out.println( "APELLIDO = " + apellido );
         System.out.println( "SEGUNDOAPELLIDO = " + segundoapellido );
         System.out.println( "telefono = " + telefono );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   System.out.println("La operación fue un exito");
    }
    
    public static void eliminar (String dni){
        Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:basehotel.db");
         c.setAutoCommit(false);
         System.out.println("La operación fue un exito");

         stmt = c.createStatement();
         String sql = "DELETE from USUARIOS where DNI = \'" + dni + "\';";
         stmt.executeUpdate(sql);
         c.commit();
        
      stmt.close();
      c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("La operación fue un exito");
    } 
    
    public static void modificar (String datoModificar, String diferencia, String dni ){
        Connection c = null;
   Statement stmt = null;
   
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:basehotel.db");
      c.setAutoCommit(false);
      System.out.println("La operación fue un exito");

      stmt = c.createStatement();
      String sql = "UPDATE USUARIOS set " + datoModificar + "= \'" + diferencia + "\' where DNI=\'"+ dni +"\';";
      stmt.executeUpdate(sql);
      c.commit();
      stmt.close();
      c.close();
     } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
        }
        System.out.println("La operación fue un exito");
    }
    
    public static void consultarIndividualmente(String dni){
        
        Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:basehotel.db");
      c.setAutoCommit(false);
      System.out.println("La operación fue un exito");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS where DNI = \'" + dni + "\';");
      
      while ( rs.next() ) {
         String dni2 = rs.getString("dni");
         String  nombre = rs.getString("nombre");
         String apellido  = rs.getString("apellido");
         String  segundoapellido = rs.getString("segundoapellido");
         String telefono = rs.getString("telefono");
         
         System.out.println( "DNI = " + dni2 );
         System.out.println( "NOMBRE = " + nombre );
         System.out.println( "APELLIDO = " + apellido );
         System.out.println( "SEGUNDOAPELLIDO = " + segundoapellido );
         System.out.println( "telefono = " + telefono );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   System.out.println("La operación fue un exito");
    }
    
}
