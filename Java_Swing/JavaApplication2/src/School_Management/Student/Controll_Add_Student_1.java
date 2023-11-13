/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package School_Management.Student;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Controll_Add_Student_1 implements MouseListener, MouseMotionListener{

    /**
     * @param args the command line arguments
     */
    private JPanel obj;
    public Controll_Add_Student_1(JPanel obj)
    {
        this.obj = obj;
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (this.obj.getBounds().contains(e.getX(), e.getY()) == false)
        {
             JOptionPane.showMessageDialog(null, "You only work at here!", "Error", JOptionPane.ERROR_MESSAGE, null);

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
        
    
}
