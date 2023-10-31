/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account_Register;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class controll implements MouseListener{
    private JLabel lb;
    private Account_View obj;
    public controll(JLabel lb, Account_View obj)
    {
        this.lb = lb;
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
        this.lb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 102, 65)));
        this.obj.setCursor(Cursor.HAND_CURSOR);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.lb.setBorder(null);
        this.obj.setCursor(Cursor.getDefaultCursor());
    }
    
    
}
