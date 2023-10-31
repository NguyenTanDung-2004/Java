/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import ui_custom_titlebar.View_TileBar;

/**
 *
 * @author user
 */
public class controll implements MouseListener{

    private JLabel obj;
    private View_TileBar obj1;
    private JPanel obj2;
    private int x =0;
    public controll(JPanel obj)
    {
        this.obj2 = obj;
    }
    public controll(JLabel obj, View_TileBar obj1)
    {
        this.obj = obj;
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (obj == this.obj1.getjLabel18())
        {
            this.obj1.setState(JFrame.ICONIFIED); // thu nhỏ
        }
         if (obj == this.obj1.getjLabel19())
        {
            if (x % 2 == 0)
            {
                 this.obj1.setExtendedState(Frame.MAXIMIZED_BOTH); // PHÓNG TO HẾT CỠ.
            }
            else
            {
                this.obj1.setSize(800, 550);
                this.obj1.setLocationRelativeTo(null);
            }
            x++;
        }
          if (obj == this.obj1.getjLabel20())
        {
            this.obj1.dispose();
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
        
       this.obj.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }

    @Override
    public void mouseExited(MouseEvent es) {
        this.obj.setBorder(null);
    }
    
}
