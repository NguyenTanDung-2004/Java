/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package School_Management.Events_Controlls;

import School_Management.Class.Add_Class_View;
import School_Management.School_View;
import School_Management.Student.Add_Student_View;
import School_Management.Teacher.Add_Teacher_View;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class Controll_JTextField implements MouseListener{

    private School_View obj_School_View;
    private Add_Student_View obj_Add_Student_View;
    private JTextField tf;
    private Add_Class_View obj_Add_Class_View;
    private int x = 0;
    private Add_Teacher_View obj_Add_Teacher_View;
    public Controll_JTextField(Add_Class_View obj, JTextField tf)
    {
        this.obj_Add_Class_View = obj;
        this.tf = tf;
        x = 3;
    }
    public Controll_JTextField(School_View obj_School_View, JTextField tf)
    {
        this.obj_School_View = obj_School_View;
        this.tf = tf;
        x = 0;
    }
    public Controll_JTextField(Add_Student_View obj_Add_Student_View, JTextField tf)
    {
        this.obj_Add_Student_View = obj_Add_Student_View;
        this.tf = tf;
        x = 1;
    }
    public Controll_JTextField(Add_Teacher_View obj_Add_Teacher_View, JTextField tf)
    {
        this.obj_Add_Teacher_View = obj_Add_Teacher_View;
        this.tf = tf;
        x = 2;
    }
     @Override
    public void mouseClicked(MouseEvent e) {
       
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         if (x == 1)
        {
            if (tf == this.obj_Add_Student_View.getjTextField2() && tf.getText().equals("ID*"))
            {
                 tf.setText("");
            }
            if (tf == this.obj_Add_Student_View.getjTextField1() && tf.getText().equals("Full Name*"))
            {
                 tf.setText("");
            }
            if (tf == this.obj_Add_Student_View.getjTextField3() && tf.getText().equals("Class*"))
            {
                 tf.setText("");
            }
           
        }
         if (x == 2)
         {
             if (tf == this.obj_Add_Teacher_View.getjTextField2() && tf.getText().equals("ID*"))
            {
                 tf.setText("");
            }
            if (tf == this.obj_Add_Teacher_View.getjTextField1() && tf.getText().equals("Full Name*"))
            {
                 tf.setText("");
            }
            if (tf == this.obj_Add_Teacher_View.getjTextField3() && tf.getText().equals("Subject*"))
            {
                 tf.setText("");
            }
         }
        if (x == 0)
        {
            if (tf == this.obj_School_View.getjTextField9() && tf.getText().equals("ID*"))
            {
                tf.setText("");
            }
            if (tf == this.obj_School_View.getjTextField1() && tf.getText().equals("Name*"))
            {
                tf.setText("");
            }
            if (tf == this.obj_School_View.getjTextField2() && tf.getText().equals("Class*"))
            {
                tf.setText("");
            }
            if (tf == this.obj_School_View.getjTextField10() && tf.getText().equals("ID*"))
            {
                tf.setText("");
            }
            if (tf == this.obj_School_View.getjTextField3() && tf.getText().equals("FullName*"))
            {
                tf.setText("");
            }
            if (tf == this.obj_School_View.getjTextField4() && tf.getText().equals("Subject*"))
            {
                tf.setText("");
            }
        }
        if (x == 3)
        {
             if (tf == this.obj_Add_Class_View.getjTextField2() && tf.getText().equals("ID*"))
            {
                 tf.setText("");
            }
            if (tf == this.obj_Add_Class_View.getjTextField1() && tf.getText().equals("Full Name*"))
            {
                 tf.setText("");
            }
            if (tf == this.obj_Add_Class_View.getjTextField4() && tf.getText().equals("Number*"))
            {
                 tf.setText("");
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
       if (x == 1)
       {
            if (tf == this.obj_Add_Student_View.getjTextField2() && tf.getText().equals(""))
            {
                 tf.setText("ID*");
            }
            if (tf == this.obj_Add_Student_View.getjTextField1() && tf.getText().equals(""))
            {
                 tf.setText("Full Name*");
            }
            if (tf == this.obj_Add_Student_View.getjTextField3() && tf.getText().equals(""))
            {
                 tf.setText("Class*");
            }
           
       }
       if (x == 0)
       {
            if (tf == this.obj_School_View.getjTextField9() && tf.getText().equals(""))
            {
                tf.setText("ID*");
            }
            if (tf == this.obj_School_View.getjTextField1() && tf.getText().equals(""))
            {
                tf.setText("Name*");
            }
            if (tf == this.obj_School_View.getjTextField2() && tf.getText().equals(""))
            {
                tf.setText("Class*");
            }
            if (tf == this.obj_School_View.getjTextField10() && tf.getText().equals(""))
            {
                tf.setText("ID*");
            }
            if (tf == this.obj_School_View.getjTextField3() && tf.getText().equals(""))
            {
                tf.setText("FullName*");
            }
            if (tf == this.obj_School_View.getjTextField4() && tf.getText().equals(""))
            {
                tf.setText("Subject*");
            }
       }
       if (x == 2)
       {
            if (tf == this.obj_Add_Teacher_View.getjTextField2() && tf.getText().equals(""))
            {
                 tf.setText("ID*");
            }
            if (tf == this.obj_Add_Teacher_View.getjTextField1() && tf.getText().equals(""))
            {
                 tf.setText("Full Name*");
            }
            if (tf == this.obj_Add_Teacher_View.getjTextField3() && tf.getText().equals(""))
            {
                 tf.setText("Subject*");
            }
       }
       if (x == 3)
        {
             if (tf == this.obj_Add_Class_View.getjTextField2() && tf.getText().equals(""))
            {
                 tf.setText("ID*");
            }
            if (tf == this.obj_Add_Class_View.getjTextField1() && tf.getText().equals(""))
            {
                 tf.setText("Full Name*");
            }
            if (tf == this.obj_Add_Class_View.getjTextField4() && tf.getText().equals(""))
            {
                 tf.setText("Number*");
            }
        }

    }

    private class obj_Add_Class_Views {

        public obj_Add_Class_Views() {
        }
    }
}
