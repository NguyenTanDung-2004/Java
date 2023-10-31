/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account_Register;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class controll1 implements MouseListener{
    private JTextField tf;
    private Account_View obj;
    public controll1(JTextField tf, Account_View obj)
    {
        this.tf = tf;
        this.obj = obj;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.tf.getText().equals("Name*"))
        {
            tf.setText("");
        }
         if (this.tf.getText().equals("LastName*"))
        {
            tf.setText("");
        }
          if (this.tf.getText().equals("YourAge*"))
        {
            tf.setText("");
        }
           if (this.tf.getText().equals("User*"))
        {
            tf.setText("");
        }
            if (this.tf.getText().equals("CardNumber*"))
        {
            tf.setText("");
        }
             if (this.tf.getText().equals("Address*"))
        {
            tf.setText("");
        }
              if (this.tf.getText().equals("CompanyName*"))
        {
            tf.setText("");
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
       if (this.tf.getText().equals("") && this.tf == obj.getjTextField1())
       {
           tf.setText("Name*");
       }
       if (this.tf.getText().equals("") && this.tf == obj.getjTextField2())
       {
           tf.setText("LastName*");
       }
       if (this.tf.getText().equals("") && this.tf == obj.getjTextField3())
       {
           tf.setText("YourAge*");
       }
       if (this.tf.getText().equals("") && this.tf == obj.getjTextField4())
       {
           tf.setText("CompanyName*");
       }
       if (this.tf.getText().equals("") && this.tf == obj.getjTextField5())
       {
           tf.setText("User*");
       }
       if (this.tf.getText().equals("") && this.tf == obj.getjTextField7())
       {
           tf.setText("CardNumber*");
       }
       if (this.tf.getText().equals("") && this.tf == obj.getjTextField8())
       {
           tf.setText("Address*");
       }

    }
    
}
