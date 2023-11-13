/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package School_Management.Custom_Table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class HeaderRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Set the background color and other attributes for the header here
        this.setBackground(new Color(x, y, z)); // Set the header background color to yellow
        this.setForeground(Color.WHITE);
        

        return this;
    }
    private int x = 0;
    private int y = 0;
    private int z = 0;
    public HeaderRenderer(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
