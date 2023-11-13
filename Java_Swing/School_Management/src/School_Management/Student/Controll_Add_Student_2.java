/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package School_Management.Student;

import School_Management.Controll_School_View_1;
import School_Management.Student.Add_Student_View;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Controll_Add_Student_2 implements MouseListener{

   /**
     * @param args the command line arguments
     */
    private Add_Student_View obj1;
    public Controll_Add_Student_2(Add_Student_View obj1)
    {
        this.obj1 = obj1;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Object object = e.getSource();
        JButton button = (JButton)object;
        if (button == this.obj1.getjButton3())
        {
            this.obj1.dispose();
            Controll_School_View_1.x = 0;
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    
}
