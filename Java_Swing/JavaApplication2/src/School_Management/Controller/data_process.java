/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package School_Management.Controller;

import java.beans.Statement;
import java.io.PrintWriter;
import java.lang.invoke.VarHandle;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class data_process {

   private ArrayList<String[]> student_card_data;
   public data_process()
   {
       student_card_data = new ArrayList<>();
   }
   public void connect_to_database()
   {
       
       String server = "LAPTOP-DungDepTrai";
       String user = "sa";
       String password = "123";
       String db = "School_Management";
       int port = 1433;
        String cadena = "jdbc:sqlserver://" + server + ":" + port+";" + "databaseName=" + db + ";trustServerCertificate = true;characterEncoding=UTF-8;useUnicode=true;";
        try(Connection conn = DriverManager.getConnection(cadena, user, password))
        {
            java.sql.Statement statement = conn.createStatement();
            String load_query = load_student_data();
            ResultSet resultSet = statement.executeQuery(load_query);
            while (resultSet.next())
            {
               String st_id = resultSet.getString("st_id");
               String st_name = resultSet.getString("st_name");
               String cl_name = resultSet.getString("cl_name");
               String[] row= {st_id, st_name, cl_name};
               student_card_data.add(row);
            }
        }
        catch (Exception e )
        {
            System.out.println(e);
        }
   }
   public String load_student_data()
   {
     
       return "select student.st_id, st_name, cl_name from student inner join belonging on student.st_id = belonging.st_id inner join class on class.cl_id = belonging.cl_id;";
   }
   public void add_data_into_table(DefaultTableModel model)
   {
       for (int i = 0; i < student_card_data.size(); i++)
       {
           model.addRow(student_card_data.get(i));
       }
   }
    public static void main(String args[]) {
  
           data_process obj = new data_process();
           obj.connect_to_database(); 
    }
}
