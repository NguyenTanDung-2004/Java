/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dark_ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class handler_mouse_event_for_LabelSide implements MouseListener {
    private JPanel obj;
    public handler_mouse_event_for_LabelSide(JPanel obj)
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
        this.obj.setBackground(Color.GRAY);
        this.obj.setOpaque(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.obj.setBackground(new Color(0, 0, 0));
        this.obj.setOpaque(true);
    }
    
    
}
