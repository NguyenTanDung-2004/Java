/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package School_Management.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Load_First_Data {

  public ArrayList<String[]> student_card_data;
  public ArrayList<String[]> teacher_card_data;
   public ArrayList<String[]> class_card_data;
   public ArrayList<String[]> subject_card_data;
  public ResultSet resultSet;
  public ResultSet resultSet1;
  public ResultSet resultSet2;
  public ResultSet resultSet3;
   public Load_First_Data()
   {
       student_card_data = new ArrayList<>();
       teacher_card_data = new ArrayList<>();
       class_card_data = new ArrayList<>();
       subject_card_data = new ArrayList<>();
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
            String load_student_data = load_student_data();
            resultSet = statement.executeQuery(load_student_data);
            while (resultSet.next())
            {
               String st_id = resultSet.getString("st_id");
               String st_name = resultSet.getString("st_name");
               String cl_name = resultSet.getString("cl_name");
               String[] row= {st_id, st_name, cl_name};
               student_card_data.add(row);
            }
            
            String load_teacher_data = load_teacher_data();
            resultSet1 = statement.executeQuery(load_teacher_data);
            while (resultSet1.next())
            {
                String te_id = resultSet1.getString("te_id");
                String te_name = resultSet1.getString("te_name");
                String sub_name = resultSet1.getString("sub_name");
                String[] row = {te_id, te_name, sub_name};
                teacher_card_data.add(row);
            }
            String load_class_data = load_class_data();
            resultSet2 = statement.executeQuery(load_class_data);
            while (resultSet2.next())
            {
               
                String cl_id = resultSet2.getString("cl_id");
                String cl_name = resultSet2.getString("cl_name");
                String cl_number = resultSet2.getString("cl_number");
                String[] row = {cl_id, cl_name, cl_number};
                class_card_data.add(row);
            }
            String load_subject_data = load_subject_data();           
            resultSet3 = statement.executeQuery(load_subject_data);
            while (resultSet3.next())
            {
                String sub_id = resultSet3.getString("sub_id");
                String sub_name = resultSet3.getString("Sub_name");
                String sub_faculty = resultSet3.getString("sub_faculty");
                String[] row = {sub_id, sub_name, sub_faculty};
                subject_card_data.add(row);
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
   public String load_teacher_data()
   {
       return "select  * from teacher inner join subject on teacher.sub_id = subject.sub_id;";
   }
   public String load_class_data()
   {
       return "select * from class;";
   }
   public String load_subject_data()
   {
       return "select * from subject;";
   }
}
