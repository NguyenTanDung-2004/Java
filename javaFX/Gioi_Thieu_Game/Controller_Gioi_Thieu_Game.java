/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gioi_Thieu_Game;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import Dang_Nhap.Controller_Dang_Nhap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import Vao_Game_Store.Controller_Vao_Game;
import Main.lay_du_lieu;
/**
 * FXML Controller class
 *
 * @author user
 */
public class Controller_Gioi_Thieu_Game implements Initializable {

    @FXML
    ImageView imgv;
    @FXML
    Label lb_Game_info;
    @FXML
    Hyperlink hp_refer_link;
    @FXML
    Button bt;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        create_Image();
        create_info();
        create_refer_link();
        this.hp_refer_link.setOnAction(event->xu_ly_su_kien_nhan_link());
        this.bt.setOnAction(event->event_click_add_inventory_in_gioi_thieu_game());
        setTextfor_bt();
        
    }   
    public void setTextfor_bt()
    {
    	if (kiem_tra_game_da_co_trong_inventory())
    	{
    		bt.setText("Added to Inventory");
    		bt.setDisable(true);
    	}
    }
    public boolean kiem_tra_game_da_co_trong_inventory()
    {
    	for (int i = 0; i < Controller_Dang_Nhap.Name_Game_List_Inventory.size(); i++)
    	{
    		if (Tao_du_lieu_fxml.game_name.equals(Controller_Dang_Nhap.Name_Game_List_Inventory.get(i)))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    public void create_Image()
    {
        Image img = new Image(getClass().getResource("/Image_Game/" + Tao_du_lieu_fxml.game_name + ".jpg").toExternalForm());
        this.imgv.setImage(img);
    }
    public void create_info()
    {
        this.lb_Game_info.setText(Tao_du_lieu_fxml.Game_info);
    }
    public void create_refer_link()
    {
        this.hp_refer_link.setText(Tao_du_lieu_fxml.Refe_link);
    }
    public void xu_ly_su_kien_nhan_link()
    {
        String s = this.hp_refer_link.getText();
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(s));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void event_click_add_inventory_in_gioi_thieu_game()
    {
    	System.out.println(1);
    	if (bt.getText().equals("Add to Inventory"))
    	{
    		
    		System.out.println(2);
	    	String game_name = Controller_Vao_Game.name_game;
	    	String info = "";
	    	String query = "select game_info from game where ten_game = '" + game_name + "'";
	    	ResultSet resultSet;
	        try {
	            Statement statement = lay_du_lieu.connect.createStatement();
	            resultSet = statement.executeQuery(query);
	            while (resultSet.next()) {
	                info = resultSet.getString(1);
	            }
	        } catch (Exception ex) {
	            System.out.println("Loi o get_data_from_server: " + ex);
	        }
	        Controller_Vao_Game obj = new Controller_Vao_Game();
	        BorderPane obj_bd = obj.create_one_game_in_inventory(info, "/Image_Game/" + game_name + ".jpg", game_name, "/Image/Image_Download.png", "/Image/Image_close.png", "0");
	        Controller_Vao_Game.flowpane.getChildren().add(obj_bd);
	        Controller_Vao_Game.Games_in_Inventory.add(obj_bd);
	        Controller_Dang_Nhap.Name_Game_List_Inventory.add(game_name);
	        Controller_Vao_Game.NumberGames_in_Inventory.setText("Number of game: " + Controller_Dang_Nhap.Name_Game_List_Inventory.size());
	//        if (Controller_Vao_Game.flowpane.getChildren().size() > 1)
	//        {
	//        	Controller_Vao_Game.flowpane.getChildren().remove(0);
	//        }
	        insert_data_to_Inventory(Controller_Dang_Nhap.account_name, game_name, "0");
	        
	        
	        setTextfor_bt();
    	}
    }
    public void insert_data_to_Inventory(String tai_khoan, String ten_game, String Trang_Thai)
    {
    	String query = "insert into inventory values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = lay_du_lieu.connect.prepareStatement(query)) {
            // Thiết lập giá trị cho các tham số
            preparedStatement.setString(2, tai_khoan);
            preparedStatement.setString(1, ten_game);
            preparedStatement.setString(3, Trang_Thai);
            preparedStatement.setString(4, null);
            // Thực hiện truy vấn INSERT
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert tai_khoan thanh cong");
            } else {
                System.out.println("Kh ông có dữ liệu nào được thêm.");
            }
        }
		catch(Exception e )
		{
			System.out.println("loi insert o gioithieugame: " + e);
		}
    }
}
