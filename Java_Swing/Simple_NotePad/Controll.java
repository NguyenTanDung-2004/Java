/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JFrame_UI_UX;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.filechooser.FileSystemView;
import test.test_class;

/**
 *
 * @author user
 */
public class Controll implements ActionListener{
    private NewJFrame obj;
    public ArrayList<JScrollPane> obj_ScrollPane_List = new ArrayList<>();
    private int Max_Tab = 1;
    public Controll(NewJFrame obj)
    {
        this.obj = obj;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == this.obj.getAdd())
        {
            obj_ScrollPane_List.add(new JScrollPane());
            
            JTextArea obj_TextArea = new JTextArea();
            obj_TextArea.setColumns(20);
            obj_TextArea.setRows(5);
            obj_ScrollPane_List.get(obj_ScrollPane_List.size() - 1).setViewportView(obj_TextArea);
            Max_Tab++;
            this.obj.getjTabbedPane1().addTab("tab" + Max_Tab, obj_ScrollPane_List.get(obj_ScrollPane_List.size() - 1));
           
        }
        else if (obj == this.obj.getClose_current_tab())
        {
            int a  = JOptionPane.showConfirmDialog(null, "Do you want to save this file?");
            if (a == JOptionPane.YES_OPTION)
            {
                
            }
            else if (a == JOptionPane.CANCEL_OPTION)
            {
                
            }
            else if (a == JOptionPane.NO_OPTION)
            {
                Component obj_Compo = this.obj.getjTabbedPane1().getSelectedComponent();
                this.obj.getjTabbedPane1().remove(obj_Compo);
                if (this.obj.getjTabbedPane1().getTabCount() == 0)
                {
                    Max_Tab = 0;
                }
            }
        }
        else if (obj == this.obj.getClose_all_tab())
        {
            for (int i = this.obj.getjTabbedPane1().getTabCount() - 1; i >= 0; i--)
            {
                this.obj.getjTabbedPane1().remove(i);
            }
        }
        else if (obj == this.obj.getSave())
        {
            Component obj_Compo = this.obj.getjTabbedPane1().getSelectedComponent();
            JScrollPane obj_Scroll = (JScrollPane)obj_Compo;
            JViewport viewport = obj_Scroll.getViewport();
            Component obj_Compo1 = viewport.getView();
            JTextArea obj_text = (JTextArea)obj_Compo1;
            process_ShowSaveDialog(obj_text);
        }
        else if (obj == this.obj.getOpen())
        {
            obj_ScrollPane_List.add(new JScrollPane());
            String content = "";
            JTextArea obj_TextArea = new JTextArea();
            obj_TextArea.setColumns(20);
            obj_TextArea.setRows(5);
            obj_ScrollPane_List.get(obj_ScrollPane_List.size() - 1).setViewportView(obj_TextArea);
            JFileChooser jf = new JFileChooser(FileSystemView.getFileSystemView());
            int r = jf.showOpenDialog(jf); // hiển thị lên cửa sổ của jf.
            String name = "";
            if (r == JFileChooser.APPROVE_OPTION)
            {
                File f = jf.getSelectedFile();
                name = f.getName();
                String Path = f.getAbsolutePath();
                String Modified_Path = Path.replace("\\", "\\\\");
                try {
                    FileReader input  = new FileReader(Modified_Path);
                    BufferedReader reader = new BufferedReader(input);
                    int i = 0;
                    while (true)
                    {
                        String s = reader.readLine();
                        if (s == null)
                        {
                            break;
                        }
                        if (i == 0)
                        {
                            content = content + s;
                            i++;
                        }
                        else 
                        {
                            content = content + "\n" + s;
                        }
                        
                    }
                    obj_TextArea.setText(content);
                    
                } 
                catch(Exception e1) {
                    System.out.println(e1);
                }
            }
            this.obj.getjTabbedPane1().addTab(name, obj_ScrollPane_List.get(obj_ScrollPane_List.size() - 1));
        }
    }
    public void write_into_File(String Modified_Path, String s)
    {
        
        try {
            FileWriter output = new FileWriter(Modified_Path);
            output.write(s);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(test_class.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void process_ShowSaveDialog(JTextArea obj)
    {
        String s = obj.getText();
        JFileChooser jf = new JFileChooser(FileSystemView.getFileSystemView());  
        int r = jf.showSaveDialog(jf); // hiển thị lên cửa sổ của jf.
  
            // if the user selects a file  
            if (r == JFileChooser.APPROVE_OPTION) // kiểm tra rằng chúng ta đã chọn mở file không hay là cancel
  
            {  
                // setting the label as the path of the selected file  
                File f = jf.getSelectedFile();
                // kiểm tra xem file đã tồn tại hay không
                if (f.exists())
                {
                    int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn ghi đè lên không?");
                    if (a == JOptionPane.YES_OPTION)
                    {
                        
                        String Path = f.getAbsolutePath();// lây ra đường dẫn tuyệt đối của file muốn lưu..
                        String Modified_Path = Path.replace("\\", "\\\\");
                        try {
                            FileWriter output = new FileWriter(Modified_Path);
                            output.write("");
                            output.close();
                        } catch (IOException ex) {
                            Logger.getLogger(test_class.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
                       write_into_File(Modified_Path, s);
                    }
                    else
                    {
                        
                    }
                }
                else
                {
                    String Path = f.getAbsolutePath();// lây ra đường dẫn tuyệt đối của file muốn lưu..
                     String Modified_Path = Path.replace("\\", "\\\\");
                    try {
                        boolean value = f.createNewFile(); // tạo file.
                        write_into_File(Modified_Path, s);
                    } catch (IOException ex) {
                        Logger.getLogger(test_class.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               
            } 
    }

    



    
}
