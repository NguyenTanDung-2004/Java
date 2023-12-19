/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import Dang_Nhap.Controller_Dang_Nhap;
import Gioi_Thieu_Game.Tao_du_lieu_fxml;
/**
 *
 * @author user
 */
public class lay_du_lieu {
    public static ArrayList<String> Name_Game_List = new ArrayList<>();
    public static ArrayList<String> Link_tham_khao_List = new ArrayList<>();
    public static ArrayList<String> Info_Game_List = new ArrayList<>();
    public static String[] Images_in_Image_Game_folder;
    String absolute_folder = System.getProperty("user.dir") + File.separator + "bin" + File.separator + "Image_Game" + File.separator;
    // thay doi o tren
    public static Connection connect;
    public void create_data()
    {
    	System.out.println(Name_Game_List.size());
        get_data_from_server();
        create_data_from_Image_Game_folder("Image_Game");
        check_and_update_Image_folder();
    }
    public void connect_to_database()
    {
        String server = "LAPTOP-DungDepTrai";
        String user = "sa";
        String password = "12345";
        String db = "quan_ly_thu_vien_game";
        int port = 1433;
        String cadena = "jdbc:sqlserver://" + server + ":" + port+";" + "databaseName=" + db + ";trustServerCertificate = true;";
        try
        {
            this.connect = DriverManager.getConnection(cadena, user, password);
            //System.out.println("connect thanh cong");
        }
        catch(Exception e)
        {
          System.out.println( e);
        }
    }
    public void get_data_from_server()
    {
        String query = "select ten_game, link_tham_khao, game_info from game";
        ResultSet resultSet;
        try {
            Statement statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String ten_game = resultSet.getString(1);
                String link_tham_khao = resultSet.getString(2);
                String game_info = resultSet.getString(3);
                this.Name_Game_List.add(ten_game);
                this.Link_tham_khao_List.add(link_tham_khao);
                this.Info_Game_List.add(game_info);
            }
        } catch (Exception ex) {
            System.out.println("Loi o get_data_from_server: " + ex);
        }
    }
    public void create_data_from_Image_Game_folder(String folder)
    {
        String workingproject = System.getProperty("user.dir");
        String absolute_folder = workingproject + File.separator + "bin" + File.separator + folder;
        // thay doi o tren
        //System.out.println(absolute_folder);
        File f = new File(absolute_folder);
        // chinh sua
        if (f.list() == null)
        {
        	System.out.println("null roi");
        	this.Images_in_Image_Game_folder = new String[0];
        	return;
        }
        // chinh sua
        this.Images_in_Image_Game_folder = new String[f.list().length];
        for (int i = 0; i < f.list().length; i++)
        {
              this.Images_in_Image_Game_folder[i] = remove_dot_in_String(f.list()[i]);
        }
    }
    private String remove_dot_in_String(String fileName)
    {
        int LastDotIndex = fileName.lastIndexOf('.');
        return fileName.substring(0, LastDotIndex);
    }
    public static void main(String args[])
    {
        lay_du_lieu obj = new lay_du_lieu();
        obj.connect_to_database();
        obj.get_data_from_server();
        obj.create_data_from_Image_Game_folder("Image_Game");
        obj.check_and_update_Image_folder();
    }
    public void check_and_update_Image_folder()
    {
        if (Images_in_Image_Game_folder.length < Name_Game_List.size())
        {
            for (int i = 0; i < Name_Game_List.size(); i++)
            {
                if (check_game_in_Image_Game_folder(Name_Game_List.get(i)) == false)
                {
                    download_image(Name_Game_List.get(i));
                }
            }
        }
    }
    private void download_image(String Game_Name)
    {
        String query = "select  data_anh from game where ten_game = " + "'" + Game_Name + "'";
        ResultSet resultSet;
        try {
            PreparedStatement prestatement = connect.prepareStatement(query);
            resultSet = (ResultSet)prestatement.executeQuery();
            while (resultSet.next()) {
                Blob blob = resultSet.getBlob("data_anh");
                byte[] imagae_data = blob.getBytes(1, (int)blob.length());
                try {
                    FileOutputStream f1 = new FileOutputStream(absolute_folder + Game_Name + ".jpg");
                    f1.write(imagae_data);
                    f1.close();
                } catch (Exception  ex) {
                    System.out.println(ex);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    private boolean check_game_in_Image_Game_folder(String s)
    {
        int Flag = 0;
        for (int i = 0; i < Images_in_Image_Game_folder.length; i++)
        {
            if (s == Images_in_Image_Game_folder[i])
            {
                Flag = 1;
                break;
            }
        }
        if (Flag == 1)
        {
            return true;
        }
        return false;
    }
}
