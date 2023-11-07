/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package School_Management;

import School_Management.Student.Add_Student_View;
import School_Management.Teacher.Add_Teacher_View;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import School_Management.Class.Add_Class_View;
import School_Management.Subject.Add_Subject_View;

/**
 *
 * @author user
 */
public class Controll_School_View_1 implements MouseListener{
    private JPanel obj;
    private School_View obj1;
    public static int x = 0;
    public Controll_School_View_1(JPanel obj, School_View obj1)
    {
        this.obj1 = obj1;
        this.obj = obj;
    }
    public Controll_School_View_1(School_View obj1)
    {
        this.obj1 = obj1;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.obj1.getjButton11())
        {
            if (x == 0)
            {
                x = 1;
                Add_Student_View obj2 = new Add_Student_View();
                obj2.show();
            }
            
        }
        if (e.getSource() == this.obj1.getjPanel4())
        {
            this.obj1.show_cardLayout("card2");
        }
        if (e.getSource() == this.obj1.getjPanel5())
        {
            this.obj1.show_cardLayout("card4");
        }
        if (e.getSource() == this.obj1.getjButton12())
        {
            if (x == 0)
            {
                Add_Teacher_View obj2 = new Add_Teacher_View();
                obj2.show();
            }
            x = 1;
        }
        if (e.getSource() == this.obj1.getJPanel6())
        {
            this.obj1.show_cardLayout("card5");
        }
        if (e.getSource() == this.obj1.getjButton13() && Add_Class_View.Flag == 0)
        {
            Add_Class_View.Flag = 1;
            Add_Class_View obj_class = new Add_Class_View();
            obj_class.show();
        }
        if (e.getSource() == this.obj1.getjPanel7())
        {
            this.obj1.show_cardLayout("card3");
        }
        if (e.getSource() == this.obj1.getjButton14() && Add_Subject_View.Flag == 0)
        {
            Add_Subject_View.Flag = 1;
            Add_Subject_View obj_Add_Subject_View = new Add_Subject_View();
            obj_Add_Subject_View.show();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() != this.obj1.getjButton11() && e.getSource() != this.obj1.getjButton12() && e.getSource() != this.obj1.getjButton13() && e.getSource() != this.obj1.getjButton14())
        {
            Cursor cusor = new Cursor(Cursor.HAND_CURSOR) ;
        this.obj1.setCursor(cusor);
        this.obj.setBackground(new Color (114, 9, 183));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
       if (e.getSource() != this.obj1.getjButton11() && e.getSource() != this.obj1.getjButton12() && e.getSource() != this.obj1.getjButton13() && e.getSource() != this.obj1.getjButton14())
       {
            Cursor cusor = new Cursor(Cursor.DEFAULT_CURSOR) ;
        this.obj1.setCursor(cusor);
        this.obj.setBackground(new Color (58, 12, 163));
       }
    }
    
}
