/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import ui_custom_titlebar.View_TileBar;

/**
 *
 * @author user
 */
public class Controll2 implements MouseMotionListener, MouseListener {

    JPanel obj;
    View_TileBar obj1;
    private int x, y;
    public Controll2(JPanel obj, View_TileBar obj1)
    {
        this.obj = obj;
        this.obj1 = obj1;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
         
         this.obj1.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
          x = e.getX();
          y = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    public void updatexy(MouseEvent e)
    {
         x = e.getX();
        y = e.getY();
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
