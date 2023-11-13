/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package School_Management.Custom_Table;

import School_Management.Student.Add_Student_View;
import School_Management.Student.Detail_Student;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.CellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import School_Management.Teacher.Detail_Teacher;
import java.awt.event.MouseAdapter;
/**
 *
 * @author user
 */
public class ButtonEditor extends DefaultCellEditor{

    protected JButton button;
    private JTable jTable;
    int Row; int Column;
    public ButtonEditor(JCheckBox checkBox) { // xử lí các sự kiện trong Button này.
        
        super(checkBox);
        button = new JButton();
        button.addMouseListener(new MouseAdapter()
                {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jTable == School_Management.School_View.getjTable3() && Detail_Teacher.Flag == 0)
                {
                    Detail_Teacher.Flag = 1;
                    Detail_Teacher obj = new Detail_Teacher();
                    obj.show();
                    
                }
                if (jTable == School_Management.School_View.getjTable4() && Detail_Student.Flag == 0)
                {
                    Detail_Student.Flag = 1;
                    Detail_Student obj = new Detail_Student();
                    obj.show();
                }
            }
                    
                }
        );
    }

    // xử lí những thư liên quan giữa cell được chọn và các hàng,...
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        Row = row;
        Column = column;
        jTable = table;
        return button;
    }

    
}
