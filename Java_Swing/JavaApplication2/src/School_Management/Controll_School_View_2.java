/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package School_Management;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class Controll_School_View_2 implements MouseListener, MouseMotionListener{

    private JLabel lb;
    private School_View obj;
    private int x = 0;
    private int y;
    private int z;
    public Controll_School_View_2(School_View obj)
    {
        this.obj = obj;
    }
    public Controll_School_View_2(JLabel lb, School_View obj)
    {
        this.lb = lb;
        this.obj = obj;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (lb == this.obj.getjLabel21())
        {
             this.obj.setState(JFrame.ICONIFIED); // thu nhỏ
        }
         if (lb == this.obj.getjLabel22())
        {
             if (x % 2 == 0)
            {
                 this.obj.setExtendedState(JFrame.MAXIMIZED_BOTH); // PHÓNG TO HẾT CỠ.
            }
            else
            {
                this.obj.setSize(1250, 500);
                this.obj.setLocationRelativeTo(null);
            }
            x++;
        }
          if (lb == this.obj.getjLabel23())
        {
            this.obj.dispose();
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
        if (lb != this.obj.getjLabel24())
        {
            this.lb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
            Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
            this.obj.setCursor(cursor);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.lb.setBorder(null);
        this.obj.setCursor(Cursor.DEFAULT_CURSOR);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (lb == this.obj.getjLabel24())
        {
            this.obj.setLocation(e.getXOnScreen() - y, e.getYOnScreen() - z);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        y = e.getX();
        z = e.getY();
    }
    
}
