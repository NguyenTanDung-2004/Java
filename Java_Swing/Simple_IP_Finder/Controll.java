/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IP_Finder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Controll implements KeyListener{


    private NewJFrame obj_View;
    public Controll(NewJFrame obj)
    {
        this.obj_View = obj;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER)
        {
            String s = this.obj_View.getjTextField1().getText();
            InetAddress ia = null;
            try {
                ia = InetAddress.getByName(s);
                 String ip=ia.getHostAddress();  
                this.obj_View.getjLabel3().setText(ip);
            } catch (UnknownHostException ex) {
                this.obj_View.getjLabel3().setText("Something went wrong, so let check your url - Domain.");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
}
