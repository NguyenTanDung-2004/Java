/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package School_Management;

import School_Management.Controller.Load_First_Data;
import School_Management.Custom_Table.ButtonEditor;
import School_Management.Custom_Table.ButtonRenderer;
import School_Management.Custom_Table.Dis_editable_table;
import School_Management.Events_Controlls.Controll_JTextField;
import School_Management.Custom_Table.HeaderRenderer;
import School_Management.Student.Detail_Student;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import School_Management.Teacher.Detail_Teacher;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author user
 */
public class School_View extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard_view
     */
    DefaultTableModel tablemode;
    DefaultTableModel teacher_model;
    DefaultTableModel class_model;
    DefaultTableModel subject_model;
    public School_View() {
        setup_tableMode();
        initComponents();
        setup_icon();
        setup_for_JFrame();
        setup_Title_bar();
        add_Events();
        setup_dis_editable_table();
        load_data();
    }
    private void setup_for_JFrame()
    {
        this.setLocationRelativeTo(null);
        String imagePath = "C:\\Users\\user\\Pictures\\icon\\title_icon_school.png";
        setup_sacle(imagePath, jLabel18, 30, 30);
        Image img = Toolkit.getDefaultToolkit().createImage(imagePath);
        this.setIconImage(img);
                
        this.setSize(1250, 500);
    }
    private void setup_dis_editable_table()
    {

         jTable4.setColumnSelectionAllowed(false); 
        jTable4.setDefaultEditor(Object.class, new Dis_editable_table());
        jTable3.setColumnSelectionAllowed(false);
        jTable3.setDefaultEditor(Object.class, new Dis_editable_table());
        jTable5.setColumnSelectionAllowed(false);
        jTable5.setDefaultEditor(Object.class, new Dis_editable_table());
        jTable6.setColumnSelectionAllowed(false);
        jTable6.setDefaultEditor(Object.class, new Dis_editable_table());
    }
    private void setup_tableMode()
    {
        tablemode = new DefaultTableModel();
        teacher_model = new DefaultTableModel();
        class_model = new DefaultTableModel();
        subject_model = new DefaultTableModel();
    }
    private void setup_Title_bar()
    {
        setup_sacle("C:\\Users\\user\\Pictures\\icon\\icons8-minimize-48.png", jLabel21, 30, 30);
        setup_sacle("C:\\Users\\user\\Pictures\\icon\\icons8-size-50.png", jLabel22, 30, 30);
        setup_sacle("C:\\Users\\user\\Pictures\\icon\\icons8-close-30.png", jLabel23, 30, 30);
        

    }
    private void setup_sacle(String Path, JLabel lb, int width, int Height)
    {
        ImageIcon img_icon = new ImageIcon(Path);
        Image x = img_icon.getImage();
        Image y = x.getScaledInstance(width, Height, Image.SCALE_SMOOTH);
        img_icon = new ImageIcon(y);
        lb.setIcon(img_icon);
    }
    private void setup_icon()
    {
        setup_sacle("C:\\Users\\user\\Pictures\\icon\\icons8-student-50.png", jLabel7, 20, 20);
        setup_sacle("C:\\Users\\user\\Pictures\\icon\\icons8-teacher-64.png", jLabel2, 20, 20);
        setup_sacle("C:\\Users\\user\\Pictures\\icon\\icons8-class-50.png", jLabel4, 20, 20);
        setup_sacle("C:\\Users\\user\\Pictures\\icon\\icons8-book-50.png", jLabel6, 20, 20);
        setup_sacle("C:\\Users\\user\\Pictures\\icon\\icons8-setting-50.png", jLabel10, 20, 20);

    }
    public void load_data()
    {
        Load_First_Data obj = new Load_First_Data();
        obj.connect_to_database();
        ArrayList<String[]> obj1 = new ArrayList<>();
        obj1 = obj.student_card_data;
        for (int i = 0; i < obj1.size(); i++)
        {
            tablemode.addRow(obj1.get(i));
        }
        ArrayList<String[]> obj2 = new ArrayList<>();
        obj2 = obj.teacher_card_data;
        for (int i = 0; i < obj2.size(); i++)
        {
            teacher_model.addRow(obj2.get(i));
        }
        ArrayList<String[]> obj3 = new ArrayList<>();
        obj3 = obj.class_card_data;
        for (int i = 0; i < obj3.size(); i++)
        {
            class_model.addRow(obj3.get(i));
        }
        ArrayList<String[]> obj4 = new ArrayList<>();
        obj4 = obj.subject_card_data;
        for (int i = 0; i < obj4.size(); i++)
        {
            subject_model.addRow(obj4.get(i));
        }
    }
    public JButton getjButton14() {
        return jButton14;
    }
    
    private void add_Events()
    {
        setup_background_Events();
        add_Events_for_Button();
        events_for_textfield();
        drag_JFrame_Event();
        setup_for_Header_Table();
    }
    private void setup_background_Events()
    {
        Controll_School_View_1 obj1 = new Controll_School_View_1(jPanel4, this);
        Controll_School_View_1 obj2 = new Controll_School_View_1(jPanel5, this);
        Controll_School_View_1 obj3 = new Controll_School_View_1(jPanel6, this);
        Controll_School_View_1 obj4 = new Controll_School_View_1(jPanel7, this);
        Controll_School_View_1 obj5 = new Controll_School_View_1(jPanel8, this);
        jPanel4.addMouseListener(obj1);
        jPanel5.addMouseListener(obj2);
        jPanel6.addMouseListener(obj3);
        jPanel7.addMouseListener(obj4);
        jPanel8.addMouseListener(obj5);
        Controll_School_View_2 o1 = new Controll_School_View_2(jLabel21, this);
        Controll_School_View_2 o2 = new Controll_School_View_2(jLabel22, this);
        Controll_School_View_2 o3 = new Controll_School_View_2(jLabel23, this);
        jLabel21.addMouseListener(o1);
        jLabel22.addMouseListener(o2);
        jLabel23.addMouseListener(o3);
    }
    public void drag_JFrame_Event()
    {
        Controll_School_View_2 obj = new Controll_School_View_2(jLabel24,this);
        this.jLabel24.addMouseMotionListener(obj);
    }
    public void events_for_textfield()
    {
        Controll_JTextField obj = new Controll_JTextField(this, jTextField9);
        Controll_JTextField obj1 = new Controll_JTextField(this, jTextField1);
        Controll_JTextField obj2 = new Controll_JTextField(this, jTextField2);
        this.jTextField1.addMouseListener(obj1);
        this.jTextField2.addMouseListener(obj2);
        this.jTextField9.addMouseListener(obj);  
        Controll_JTextField obj3 = new Controll_JTextField(this, jTextField10);
        Controll_JTextField obj4 = new Controll_JTextField(this, jTextField3);
        Controll_JTextField obj5 = new Controll_JTextField(this, jTextField4);
        this.jTextField10.addMouseListener(obj3);
        this.jTextField3.addMouseListener(obj4);
        this.jTextField4.addMouseListener(obj5);

    }
    
    public static  JTable getjTable3() {
        return jTable3;
    }

    public static JTable getjTable4() {
        return jTable4;
    }
    public void setup_for_Header_Table()
    {
        jTable4.getTableHeader().setDefaultRenderer(new HeaderRenderer(67, 97, 238));
        jTable3.getTableHeader().setDefaultRenderer(new HeaderRenderer(67, 97, 238));
    }
    public JLabel getjLabel21() {
        return jLabel21;
    }

    public JLabel getjLabel22() {
        return jLabel22;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public JPanel getTeacherCard() {
        return TeacherCard;
    }

    public JPanel getStudent_card() {
        return student_card;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public JButton getjButton12() {
        return jButton12;
    }
    
    public void show_cardLayout(String s) // s là tên của cardLayout để tham chiếu đến có thể xem trong card Name của properties.
    {
        CardLayout card = new CardLayout();
        card = (CardLayout)JFrameCenter.getLayout();
        card.show(JFrameCenter, s);// jPanel3 là jpanel chứa Layout này.
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public JPanel getSubject_Card() {
        return Subject_Card;
    }

    public JButton getjButton13() {
        return jButton13;
    }
    
    private void add_Events_for_Button()
    {
        Controll_School_View_1 obj = new Controll_School_View_1(this);
        this.jButton11.addMouseListener(obj);
        this.jButton12.addMouseListener(obj);
        this.jButton13.addMouseListener(obj);
        this.jButton14.addMouseListener(obj);
        
    }
    public JButton getjButton11() {
        return jButton11;
    }

    public JPanel getClassCard() {
        return ClassCard;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel28 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        JFrameCenter = new javax.swing.JPanel();
        student_card = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox9 = new javax.swing.JComboBox<>();
        jPanel59 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel63 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        TeacherCard = new javax.swing.JPanel();
        student_card1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox10 = new javax.swing.JComboBox<>();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        ClassCard = new javax.swing.JPanel();
        student_card2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jPanel72 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jComboBox11 = new javax.swing.JComboBox<>();
        jPanel73 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel50 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        Subject_Card = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jComboBox12 = new javax.swing.JComboBox<>();
        jPanel80 = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel85 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jPanel86 = new javax.swing.JPanel();
        JFrame_Weast = new javax.swing.JPanel();
        Top = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Label_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Center = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        jPanel28.setBackground(new java.awt.Color(67, 97, 238));
        jPanel28.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 5));

        jLabel15.setBackground(new java.awt.Color(67, 97, 238));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ID");
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel28.add(jLabel15);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Name");
        jLabel19.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel28.add(jLabel19);

        jLabel16.setBackground(new java.awt.Color(67, 97, 238));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("LastName");
        jLabel16.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel28.add(jLabel16);

        jLabel17.setBackground(new java.awt.Color(67, 97, 238));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Class");
        jLabel17.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel28.add(jLabel17);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Detail");
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 30));
        jPanel28.add(jLabel20);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 12, 163), 3));
        jPanel25.setLayout(new java.awt.BorderLayout());

        JFrameCenter.setPreferredSize(new java.awt.Dimension(200, 495));
        JFrameCenter.setLayout(new java.awt.CardLayout());

        student_card.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        student_card.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(67, 97, 238));
        jPanel16.setPreferredSize(new java.awt.Dimension(400, 106));
        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(67, 97, 238));
        jPanel18.setPreferredSize(new java.awt.Dimension(400, 113));
        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel22.setBackground(new java.awt.Color(67, 97, 238));
        jPanel22.setPreferredSize(new java.awt.Dimension(256, 100));

        jLabel13.setBackground(new java.awt.Color(67, 97, 238));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Students");
        jLabel13.setPreferredSize(new java.awt.Dimension(256, 32));
        jPanel22.add(jLabel13);

        jLabel12.setBackground(new java.awt.Color(67, 97, 238));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("/home/students");
        jLabel12.setPreferredSize(new java.awt.Dimension(256, 16));
        jPanel22.add(jLabel12);

        jPanel18.add(jPanel22, java.awt.BorderLayout.WEST);

        jPanel16.add(jPanel18, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel16, java.awt.BorderLayout.PAGE_START);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(1054, 80));
        jPanel19.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel19, java.awt.BorderLayout.PAGE_START);

        jPanel61.setBackground(new java.awt.Color(255, 204, 255));
        jPanel61.setLayout(new java.awt.CardLayout());

        jPanel23.setLayout(new java.awt.BorderLayout());

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setLayout(new java.awt.BorderLayout());

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));
        jPanel58.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel58.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        jTextField9.setText("ID*");
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField9.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel58.add(jTextField9);

        jTextField1.setText("Name*");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel58.add(jTextField1);

        jTextField2.setText("Class*");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel58.add(jTextField2);

        jButton2.setBackground(new java.awt.Color(2, 62, 138));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel58.add(jButton2);

        jComboBox9.setBackground(new java.awt.Color(2, 62, 138));
        jComboBox9.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sorted following point", "Both", "Sorted following ID", "Filter", " " }));
        jComboBox9.setSelectedIndex(3);
        jComboBox9.setBorder(null);
        jComboBox9.setPreferredSize(new java.awt.Dimension(160, 30));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9jComboBox1ActionPerformed(evt);
            }
        });
        jPanel58.add(jComboBox9);

        jPanel60.add(jPanel58, java.awt.BorderLayout.PAGE_START);

        jPanel59.setLayout(new java.awt.BorderLayout());

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setPreferredSize(new java.awt.Dimension(150, 282));

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jPanel59.add(jPanel62, java.awt.BorderLayout.LINE_START);

        jPanel27.setLayout(new java.awt.BorderLayout());

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setPreferredSize(new java.awt.Dimension(1072, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Your Result will be displayed at table above.");
        jPanel37.add(jLabel14);

        jPanel27.add(jPanel37, java.awt.BorderLayout.SOUTH);

        jPanel30.setLayout(new java.awt.BorderLayout());

        jTable4.setModel(tablemode);
        tablemode.addColumn("ID");
        tablemode.addColumn("FullName");
        tablemode.addColumn("Class");
        tablemode.addColumn("...");
        jTable4.getColumnModel().getColumn(3).setMaxWidth(30);
        jTable4.setFocusable(false);
        jTable4.setGridColor(new java.awt.Color(255, 255, 255));
        jTable4.setShowGrid(true);
        jScrollPane4.setViewportView(jTable4);
        jTable4.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (jTable4.getColumnModel().getColumnCount() > 0)
        {
            jTable4.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
            jTable4.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox()));

        }

        jPanel30.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel30, java.awt.BorderLayout.CENTER);

        jPanel59.add(jPanel27, java.awt.BorderLayout.CENTER);

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));
        jPanel63.setPreferredSize(new java.awt.Dimension(100, 282));

        jButton11.setBackground(new java.awt.Color(2, 62, 138));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Add student");
        jButton11.setBorder(null);
        jButton11.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addGap(0, 223, Short.MAX_VALUE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel59.add(jPanel63, java.awt.BorderLayout.EAST);

        jPanel60.add(jPanel59, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel60, java.awt.BorderLayout.CENTER);

        jPanel61.add(jPanel23, "card2");

        jPanel17.add(jPanel61, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel17, java.awt.BorderLayout.CENTER);

        student_card.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(844, 50));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        student_card.add(jPanel15, java.awt.BorderLayout.PAGE_END);

        JFrameCenter.add(student_card, "card2");

        TeacherCard.setLayout(new java.awt.BorderLayout());

        student_card1.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        student_card1.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel20.setLayout(new java.awt.BorderLayout());

        jPanel24.setBackground(new java.awt.Color(67, 97, 238));
        jPanel24.setPreferredSize(new java.awt.Dimension(400, 106));
        jPanel24.setLayout(new java.awt.BorderLayout());

        jPanel31.setBackground(new java.awt.Color(67, 97, 238));
        jPanel31.setPreferredSize(new java.awt.Dimension(400, 113));
        jPanel31.setLayout(new java.awt.BorderLayout());

        jPanel32.setBackground(new java.awt.Color(67, 97, 238));
        jPanel32.setPreferredSize(new java.awt.Dimension(256, 100));

        jLabel25.setBackground(new java.awt.Color(67, 97, 238));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Teacher");
        jLabel25.setPreferredSize(new java.awt.Dimension(256, 32));
        jPanel32.add(jLabel25);

        jLabel26.setBackground(new java.awt.Color(67, 97, 238));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("/home/teacher");
        jLabel26.setPreferredSize(new java.awt.Dimension(256, 16));
        jPanel32.add(jLabel26);

        jPanel31.add(jPanel32, java.awt.BorderLayout.WEST);

        jPanel24.add(jPanel31, java.awt.BorderLayout.CENTER);

        jPanel20.add(jPanel24, java.awt.BorderLayout.PAGE_START);

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setLayout(new java.awt.BorderLayout());

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setPreferredSize(new java.awt.Dimension(1054, 80));
        jPanel34.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel33.add(jPanel34, java.awt.BorderLayout.PAGE_START);

        jPanel64.setBackground(new java.awt.Color(255, 204, 255));
        jPanel64.setLayout(new java.awt.CardLayout());

        jPanel35.setLayout(new java.awt.BorderLayout());

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));
        jPanel65.setLayout(new java.awt.BorderLayout());

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel66.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        jTextField10.setText("ID*");
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField10.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel66.add(jTextField10);

        jTextField3.setText("FullName*");
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField3.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel66.add(jTextField3);

        jTextField4.setText("Subject*");
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField4.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel66.add(jTextField4);

        jButton3.setBackground(new java.awt.Color(2, 62, 138));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Search");
        jButton3.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel66.add(jButton3);

        jComboBox10.setBackground(new java.awt.Color(2, 62, 138));
        jComboBox10.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sorted following certificate", "Sorted following Subject", "Both", "Filter", " " }));
        jComboBox10.setSelectedIndex(3);
        jComboBox10.setBorder(null);
        jComboBox10.setPreferredSize(new java.awt.Dimension(160, 30));
        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10jComboBox1ActionPerformed(evt);
            }
        });
        jPanel66.add(jComboBox10);

        jPanel65.add(jPanel66, java.awt.BorderLayout.PAGE_START);

        jPanel67.setLayout(new java.awt.BorderLayout());

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));
        jPanel68.setPreferredSize(new java.awt.Dimension(150, 282));

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jPanel67.add(jPanel68, java.awt.BorderLayout.LINE_START);

        jPanel36.setLayout(new java.awt.BorderLayout());

        jPanel39.setLayout(new java.awt.BorderLayout());

        jTable3.setModel(teacher_model);
        teacher_model.addColumn("ID");
        teacher_model.addColumn("FullName");
        teacher_model.addColumn("Subject");
        teacher_model.addColumn("...");
        jTable3.getColumnModel().getColumn(3).setMaxWidth(30);
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable3.getColumnModel().getColumn(3).setMinWidth(20);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable3.getColumnModel().getColumn(3).setMaxWidth(50);
        }
        if (jTable3.getColumnModel().getColumnCount() > 0)
        {
            jTable3.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
            jTable3.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox()));
        }

        jPanel39.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setPreferredSize(new java.awt.Dimension(1072, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Your Result will be displayed at table above");
        jPanel38.add(jLabel27);

        jPanel39.add(jPanel38, java.awt.BorderLayout.PAGE_END);

        jPanel36.add(jPanel39, java.awt.BorderLayout.CENTER);

        jPanel67.add(jPanel36, java.awt.BorderLayout.CENTER);

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));
        jPanel69.setPreferredSize(new java.awt.Dimension(100, 282));

        jButton12.setBackground(new java.awt.Color(2, 62, 138));
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Add Teacher");
        jButton12.setBorder(null);
        jButton12.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel69Layout.createSequentialGroup()
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel69Layout.createSequentialGroup()
                .addGap(0, 223, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel67.add(jPanel69, java.awt.BorderLayout.EAST);

        jPanel65.add(jPanel67, java.awt.BorderLayout.CENTER);

        jPanel35.add(jPanel65, java.awt.BorderLayout.CENTER);

        jPanel64.add(jPanel35, "card2");

        jPanel33.add(jPanel64, java.awt.BorderLayout.CENTER);

        jPanel20.add(jPanel33, java.awt.BorderLayout.CENTER);

        student_card1.add(jPanel20, java.awt.BorderLayout.CENTER);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setPreferredSize(new java.awt.Dimension(844, 50));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        student_card1.add(jPanel40, java.awt.BorderLayout.PAGE_END);

        TeacherCard.add(student_card1, java.awt.BorderLayout.CENTER);

        JFrameCenter.add(TeacherCard, "card4");

        ClassCard.setLayout(new java.awt.BorderLayout());

        student_card2.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        student_card2.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel41.setLayout(new java.awt.BorderLayout());

        jPanel42.setBackground(new java.awt.Color(67, 97, 238));
        jPanel42.setPreferredSize(new java.awt.Dimension(400, 106));
        jPanel42.setLayout(new java.awt.BorderLayout());

        jPanel43.setBackground(new java.awt.Color(67, 97, 238));
        jPanel43.setPreferredSize(new java.awt.Dimension(400, 113));
        jPanel43.setLayout(new java.awt.BorderLayout());

        jPanel44.setBackground(new java.awt.Color(67, 97, 238));
        jPanel44.setPreferredSize(new java.awt.Dimension(256, 100));

        jLabel28.setBackground(new java.awt.Color(67, 97, 238));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Class");
        jLabel28.setPreferredSize(new java.awt.Dimension(256, 32));
        jPanel44.add(jLabel28);

        jLabel29.setBackground(new java.awt.Color(67, 97, 238));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("/home/Class");
        jLabel29.setPreferredSize(new java.awt.Dimension(256, 16));
        jPanel44.add(jLabel29);

        jPanel43.add(jPanel44, java.awt.BorderLayout.WEST);

        jPanel42.add(jPanel43, java.awt.BorderLayout.CENTER);

        jPanel41.add(jPanel42, java.awt.BorderLayout.PAGE_START);

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setLayout(new java.awt.BorderLayout());

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setPreferredSize(new java.awt.Dimension(1054, 80));
        jPanel46.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel45.add(jPanel46, java.awt.BorderLayout.PAGE_START);

        jPanel70.setBackground(new java.awt.Color(255, 204, 255));
        jPanel70.setLayout(new java.awt.CardLayout());

        jPanel47.setLayout(new java.awt.BorderLayout());

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));
        jPanel71.setLayout(new java.awt.BorderLayout());

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel72.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        jTextField11.setText("ID*");
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField11.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel72.add(jTextField11);

        jTextField5.setText("Name*");
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField5.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel72.add(jTextField5);

        jButton4.setBackground(new java.awt.Color(2, 62, 138));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Search");
        jButton4.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel72.add(jButton4);

        jComboBox11.setBackground(new java.awt.Color(2, 62, 138));
        jComboBox11.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sorted following name", "Sorted following number", "Filter", " ", " " }));
        jComboBox11.setSelectedIndex(2);
        jComboBox11.setBorder(null);
        jComboBox11.setPreferredSize(new java.awt.Dimension(160, 30));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11jComboBox1ActionPerformed(evt);
            }
        });
        jPanel72.add(jComboBox11);

        jPanel71.add(jPanel72, java.awt.BorderLayout.PAGE_START);

        jPanel73.setLayout(new java.awt.BorderLayout());

        jPanel74.setBackground(new java.awt.Color(255, 255, 255));
        jPanel74.setPreferredSize(new java.awt.Dimension(150, 282));

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jPanel73.add(jPanel74, java.awt.BorderLayout.LINE_START);

        jPanel48.setLayout(new java.awt.BorderLayout());

        jPanel49.setLayout(new java.awt.BorderLayout());

        jTable5.getTableHeader().setDefaultRenderer(new HeaderRenderer(67, 97, 238));
        jTable5.setModel(class_model);
        class_model.addColumn("ID");
        class_model.addColumn("FullName");
        class_model.addColumn("Number");
        class_model.addColumn("...");
        jTable5.getColumnModel().getColumn(3).setMaxWidth(30);
        jTable5.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable5.getColumnModel().getColumn(3).setMinWidth(20);
            jTable5.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable5.getColumnModel().getColumn(3).setMaxWidth(50);
        }
        if (jTable5.getColumnModel().getColumnCount() > 0)
        {
            jTable5.getTableHeader().getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
            jTable5.getTableHeader().getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox()));
        }

        jPanel49.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setPreferredSize(new java.awt.Dimension(1072, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Your Result will be displayed at table above");
        jPanel50.add(jLabel30);

        jPanel49.add(jPanel50, java.awt.BorderLayout.PAGE_END);

        jPanel48.add(jPanel49, java.awt.BorderLayout.CENTER);

        jPanel73.add(jPanel48, java.awt.BorderLayout.CENTER);

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));
        jPanel75.setPreferredSize(new java.awt.Dimension(100, 282));

        jButton13.setBackground(new java.awt.Color(2, 62, 138));
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Add Class");
        jButton13.setBorder(null);
        jButton13.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                .addGap(0, 223, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel73.add(jPanel75, java.awt.BorderLayout.EAST);

        jPanel71.add(jPanel73, java.awt.BorderLayout.CENTER);

        jPanel47.add(jPanel71, java.awt.BorderLayout.CENTER);

        jPanel70.add(jPanel47, "card2");

        jPanel45.add(jPanel70, java.awt.BorderLayout.CENTER);

        jPanel41.add(jPanel45, java.awt.BorderLayout.CENTER);

        student_card2.add(jPanel41, java.awt.BorderLayout.CENTER);

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setPreferredSize(new java.awt.Dimension(844, 50));

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        student_card2.add(jPanel51, java.awt.BorderLayout.PAGE_END);

        ClassCard.add(student_card2, java.awt.BorderLayout.CENTER);

        JFrameCenter.add(ClassCard, "card5");

        Subject_Card.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Subject_Card.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel52.setLayout(new java.awt.BorderLayout());

        jPanel53.setBackground(new java.awt.Color(67, 97, 238));
        jPanel53.setPreferredSize(new java.awt.Dimension(400, 106));
        jPanel53.setLayout(new java.awt.BorderLayout());

        jPanel54.setBackground(new java.awt.Color(67, 97, 238));
        jPanel54.setPreferredSize(new java.awt.Dimension(400, 113));
        jPanel54.setLayout(new java.awt.BorderLayout());

        jPanel55.setBackground(new java.awt.Color(67, 97, 238));
        jPanel55.setPreferredSize(new java.awt.Dimension(256, 100));

        jLabel31.setBackground(new java.awt.Color(67, 97, 238));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Subject");
        jLabel31.setPreferredSize(new java.awt.Dimension(256, 32));
        jPanel55.add(jLabel31);

        jLabel32.setBackground(new java.awt.Color(67, 97, 238));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("/home/subject");
        jLabel32.setPreferredSize(new java.awt.Dimension(256, 16));
        jPanel55.add(jLabel32);

        jPanel54.add(jPanel55, java.awt.BorderLayout.WEST);

        jPanel53.add(jPanel54, java.awt.BorderLayout.CENTER);

        jPanel52.add(jPanel53, java.awt.BorderLayout.PAGE_START);

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setLayout(new java.awt.BorderLayout());

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setPreferredSize(new java.awt.Dimension(1054, 80));
        jPanel57.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel56.add(jPanel57, java.awt.BorderLayout.PAGE_START);

        jPanel76.setBackground(new java.awt.Color(255, 204, 255));
        jPanel76.setLayout(new java.awt.CardLayout());

        jPanel77.setLayout(new java.awt.BorderLayout());

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));
        jPanel78.setLayout(new java.awt.BorderLayout());

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));
        jPanel79.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel79.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        jTextField12.setText("ID*");
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField12.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel79.add(jTextField12);

        jTextField6.setText("Name*");
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField6.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel79.add(jTextField6);

        jTextField7.setText("Type*");
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 62, 138)));
        jTextField7.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel79.add(jTextField7);

        jButton5.setBackground(new java.awt.Color(2, 62, 138));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel79.add(jButton5);

        jComboBox12.setBackground(new java.awt.Color(2, 62, 138));
        jComboBox12.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Social and science", "Math", "IT", "Filter", " " }));
        jComboBox12.setSelectedIndex(3);
        jComboBox12.setBorder(null);
        jComboBox12.setPreferredSize(new java.awt.Dimension(160, 30));
        jComboBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox12jComboBox1ActionPerformed(evt);
            }
        });
        jPanel79.add(jComboBox12);

        jPanel78.add(jPanel79, java.awt.BorderLayout.PAGE_START);

        jPanel80.setLayout(new java.awt.BorderLayout());

        jPanel81.setBackground(new java.awt.Color(255, 255, 255));
        jPanel81.setPreferredSize(new java.awt.Dimension(150, 282));

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jPanel80.add(jPanel81, java.awt.BorderLayout.LINE_START);

        jPanel82.setLayout(new java.awt.BorderLayout());

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setPreferredSize(new java.awt.Dimension(1072, 30));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Your Result will be displayed at table above.");
        jPanel83.add(jLabel33);

        jPanel82.add(jPanel83, java.awt.BorderLayout.SOUTH);

        jPanel84.setLayout(new java.awt.BorderLayout());

        jTable6.getTableHeader().setDefaultRenderer(new HeaderRenderer(67, 97, 238));
        jTable6.setModel(subject_model);
        subject_model.addColumn("ID");
        subject_model.addColumn("FullName");
        subject_model.addColumn("Faculty");
        jTable6.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane6.setViewportView(jTable6);

        jPanel84.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jPanel82.add(jPanel84, java.awt.BorderLayout.CENTER);

        jPanel80.add(jPanel82, java.awt.BorderLayout.CENTER);

        jPanel85.setBackground(new java.awt.Color(255, 255, 255));
        jPanel85.setPreferredSize(new java.awt.Dimension(100, 282));

        jButton14.setBackground(new java.awt.Color(2, 62, 138));
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Add Subject");
        jButton14.setBorder(null);
        jButton14.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel85Layout.createSequentialGroup()
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel85Layout.createSequentialGroup()
                .addGap(0, 223, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel80.add(jPanel85, java.awt.BorderLayout.EAST);

        jPanel78.add(jPanel80, java.awt.BorderLayout.CENTER);

        jPanel77.add(jPanel78, java.awt.BorderLayout.CENTER);

        jPanel76.add(jPanel77, "card2");

        jPanel56.add(jPanel76, java.awt.BorderLayout.CENTER);

        jPanel52.add(jPanel56, java.awt.BorderLayout.CENTER);

        Subject_Card.add(jPanel52, java.awt.BorderLayout.CENTER);

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setPreferredSize(new java.awt.Dimension(844, 50));

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4058, Short.MAX_VALUE)
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Subject_Card.add(jPanel86, java.awt.BorderLayout.PAGE_END);

        JFrameCenter.add(Subject_Card, "card3");

        jPanel25.add(JFrameCenter, java.awt.BorderLayout.CENTER);

        JFrame_Weast.setPreferredSize(new java.awt.Dimension(200, 495));
        JFrame_Weast.setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(29, 53, 87));

        jPanel1.setBackground(new java.awt.Color(29, 53, 87));
        jPanel1.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(180, 80));

        Label_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Pictures\\icon\\icons8-school-50.png")); // NOI18N
        jPanel1.add(Label_icon);

        jLabel1.setBackground(new java.awt.Color(29, 53, 87));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Great School");
        jLabel1.setToolTipText("");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);

        Top.add(jPanel1);

        JFrame_Weast.add(Top, java.awt.BorderLayout.PAGE_START);

        Center.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(58, 12, 163));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Center.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(58, 12, 163));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        jPanel4.setBackground(new java.awt.Color(58, 12, 163));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Pictures\\icon\\icons8-student-50.png")); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel4.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Student");
        jLabel8.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel4.add(jLabel8);

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(58, 12, 163));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Pictures\\icon\\icons8-teacher-64.png")); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel5.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Teacher");
        jLabel3.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel5.add(jLabel3);

        jPanel3.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(58, 12, 163));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Pictures\\icon\\icons8-dolar-64.png")); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel6.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Class");
        jLabel5.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel6.add(jLabel5);

        jPanel3.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(58, 12, 163));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Pictures\\icon\\icons8-user-64.png")); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel7.add(jLabel6);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Subject");
        jLabel9.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel7.add(jLabel9);

        jPanel3.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(58, 12, 163));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Pictures\\icon\\icons8-setting-50.png")); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel8.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Setting");
        jLabel11.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel8.add(jLabel11);

        jPanel3.add(jPanel8);

        Center.add(jPanel3, java.awt.BorderLayout.CENTER);

        JFrame_Weast.add(Center, java.awt.BorderLayout.CENTER);

        jPanel25.add(JFrame_Weast, java.awt.BorderLayout.WEST);
        this.setUndecorated(true);

        jPanel21.setBackground(new java.awt.Color(58, 12, 163));
        jPanel21.setPreferredSize(new java.awt.Dimension(1211, 30));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jLabel18.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel21.add(jLabel18, java.awt.BorderLayout.WEST);

        jPanel26.setBackground(new java.awt.Color(58, 12, 163));
        jPanel26.setPreferredSize(new java.awt.Dimension(1040, 30));
        jPanel26.setLayout(new java.awt.BorderLayout());

        jLabel24.setPreferredSize(new java.awt.Dimension(1040, 30));
        jPanel26.add(jLabel24, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel26, java.awt.BorderLayout.CENTER);

        jPanel29.setBackground(new java.awt.Color(58, 12, 163));
        jPanel29.setPreferredSize(new java.awt.Dimension(110, 40));
        jPanel29.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        jLabel21.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel29.add(jLabel21);

        jLabel22.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel29.add(jLabel22);

        jLabel23.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel29.add(jLabel23);

        jPanel21.add(jPanel29, java.awt.BorderLayout.EAST);

        jPanel25.add(jPanel21, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel25, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public JPanel getJPanel6()
    {
        return jPanel6;
    }
    private void jComboBox9jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox9jComboBox1ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jComboBox10jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox10jComboBox1ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jComboBox11jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11jComboBox1ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jComboBox12jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox12jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox12jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(School_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(School_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(School_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(School_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new School_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Center;
    private javax.swing.JPanel ClassCard;
    private javax.swing.JPanel JFrameCenter;
    private javax.swing.JPanel JFrame_Weast;
    private javax.swing.JLabel Label_icon;
    private javax.swing.JPanel Subject_Card;
    private javax.swing.JPanel TeacherCard;
    private javax.swing.JPanel Top;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private static javax.swing.JTable jTable3;
    private static javax.swing.JTable jTable4;
    private static javax.swing.JTable jTable5;
    private static javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel student_card;
    private javax.swing.JPanel student_card1;
    private javax.swing.JPanel student_card2;
    // End of variables declaration//GEN-END:variables

    
    public JTextField getjTextField1() {
        return jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public JTextField getjTextField9() {
        return jTextField9;
    }

    public JPanel getjPanel26() {
        return jPanel26;
    }

    public JLabel getjLabel24() {
        return jLabel24;
    }

    public JTextField getjTextField10() {
        return jTextField10;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }

}

