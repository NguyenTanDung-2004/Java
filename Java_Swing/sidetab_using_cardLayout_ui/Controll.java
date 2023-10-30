/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Side_Tab_Using_CardLayout;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import Side_Tab_Using_CardLayout.NewJFrame;
import java.awt.CardLayout;
/**
 *
 * @author user
 */
public class Controll implements MouseListener {

    private NewJFrame obj1;
    public Controll(JLabel obj, NewJFrame obj1)
    {
        this.obj1 = obj1;
        this.obj = obj;
    }
    private JLabel obj;
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.obj == this.obj1.getjLabel1())
        {
            this.obj1.show_cardLayout("card2");
        }
        if (this.obj == this.obj1.getjLabel2())
        {
            this.obj1.show_cardLayout("card3");
        }
        if (this.obj == this.obj1.getjLabel3())
        {
            this.obj1.show_cardLayout("card4");
        }
        if (this.obj == this.obj1.getjLabel4())
        {
            this.obj1.show_cardLayout("card5");
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
        this.obj.setBackground(Color.GRAY);
        this.obj.setOpaque(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.obj.setBackground(Color.BLACK);
        this.obj.setOpaque(true);
    }

 
}
