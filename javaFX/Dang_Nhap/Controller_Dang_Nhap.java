/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dang_Nhap;

import Gioi_Thieu_Game.Tao_du_lieu_fxml; 
import Main.Quan_Ly_Thu_Vien_Game;
import Main.lay_du_lieu;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author user
 */
public class Controller_Dang_Nhap implements Initializable {

	public static ArrayList<String> Name_Game_List_Inventory = new ArrayList<>();
    @FXML
    Label lb_account_password_wrong;
    @FXML
    Button btn_login;
    @FXML
    TextField account;
    @FXML
    TextField Password;
    @FXML
    Label lb_Create_account;
    @FXML
    Label lb_forgotpassword;
    public static String account_name; // được tạo ở bên trong login_click.
    public int Flag = 0;
    public int Flag1 = 0; // biến này dùng để quản lý việc bật tab quên mật khẩu.
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lb_account_password_wrong.setVisible(false);
        add_event_for_controlls();
    }    
//   @FXML
//   FlowPane flowPane_Account_Password = new FlowPane();
//    public void setup_gap_for_flowPane_Account_Password()
//    {
//        this.flowPane_Account_Password.setVgap(30);
//    }
   public boolean check_account_when_login()
   {
	   String query = "select tai_khoan from tai_khoan where tai_khoan = '" + account.getText() + "'";
	   ResultSet resultSet;
       try {
       	int n = 0;
           Statement statement = lay_du_lieu.connect.createStatement();
           resultSet = statement.executeQuery(query);
           while (resultSet.next()) {
               n++;
           }
           if (n == 0)
           {
           	return false;
           }
       } catch (Exception ex) {
           System.out.println("Loi o truy xuat tai khoan trong dang ky: " + ex);
       }
       return true;
   }
   public boolean check_password()
   {
	   String query = "select password from tai_khoan where tai_khoan = '" + account.getText() + "'";
	   ResultSet resultSet;
	   String pass = "";
       try {
       	int n = 0;
           Statement statement = lay_du_lieu.connect.createStatement();
           resultSet = statement.executeQuery(query);
           while (resultSet.next()) {
               n++;
               pass = resultSet.getString(1);
           }
           if (n == 0)
           {
           	return false;
           }
       } catch (Exception ex) {
           System.out.println("Loi o truy xuat tai khoan trong dang ky: " + ex);
       }
       if (pass.equals(Password.getText()))
       {
    	   return true;
       }
       return false;
   }
   public void event_click_login()
   {
       if (check_account_when_login() == false || check_password() == false)
       {
           this.lb_account_password_wrong.setVisible(true);
           this.lb_account_password_wrong.setText("Your account or password is wrong");
       }
       if (check_account_when_login() == true && check_password() == true)
       {
    	  this.account_name = account.getText();
    	  create_Name_Game_in_Inventory();
    	  create_Vao_Game_Store();
       }
   }
   public void event_click_account_or_password()
   {
       this.lb_account_password_wrong.setVisible(false);
   }
   public void add_event_for_controlls()
   {
       this.btn_login.setOnAction(event->event_click_login());
       this.account.setOnMouseClicked(event->event_click_account_or_password());
       this.Password.setOnMouseClicked(event->event_click_account_or_password());
       this.lb_Create_account.setOnMouseClicked(event->event_create_account_click());
       this.lb_forgotpassword.setOnMouseClicked(event->event_create_Quen_Mat_Khau());
   }
   public void event_create_account_click()
   {
       if (Flag == 0)
        {
            Stage stage = new Stage();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Dang_Ky/FXML_Dang_Ky.fxml"));
                System.out.println("nguyentandung2");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaxWidth(370);
                stage.setMaxHeight(660);
                stage.setMinWidth(370);
                stage.setMinHeight(660);
                Image imgage = new Image(getClass().getResource("/Image/Image_Logo.png").toExternalForm());
                stage.getIcons().add(imgage);
                Flag = 1;
                stage.showAndWait();
                Flag = 0;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alert");
            alert.setHeaderText("You don't allow do it");
            alert.setContentText("You must close the game introduce stage");
            if(alert.showAndWait().get() == ButtonType.CLOSE)
            {
            }
            else
            {
            }
        }
   }
   public void create_Vao_Game_Store()
   {
       try {
           Parent root = FXMLLoader.load(getClass().getResource("/Vao_Game_Store/FXML_Vao_Game.fxml"));
           Scene scene = new Scene(root);
           Quan_Ly_Thu_Vien_Game.Stage.setMinHeight(476);
           Quan_Ly_Thu_Vien_Game.Stage.setMinWidth(900);
           Quan_Ly_Thu_Vien_Game.Stage.setMaxHeight(Double.MAX_VALUE);
           Quan_Ly_Thu_Vien_Game.Stage.setMaxWidth(Double.MAX_VALUE);
           Quan_Ly_Thu_Vien_Game.Stage.setScene(scene);
       } catch (Exception ex) {
           ex.printStackTrace();
       }
   }
   public void event_create_Quen_Mat_Khau()
   {
	   if (Flag1 == 0)
	   {
		   Flag1 = 1;
		   Stage stage = new Stage();
	       try {
	           Parent root = FXMLLoader.load(getClass().getResource("/Quen_Mat_Khau/FXML_Quen_Mat_Khau.fxml"));
	           Scene scene = new Scene(root);
	           stage.setScene(scene);
	           stage.setMaxWidth(460);
	           stage.setMaxHeight(550);
	           stage.setMinWidth(460);
	           stage.setMinHeight(550);
	           Image imgage = new Image(getClass().getResource("/Image/Image_Logo.png").toExternalForm());
	           stage.getIcons().add(imgage);
	           stage.showAndWait();
	           Flag1 = 0;
	       } catch (Exception ex) {
	           System.out.println("Loi o create_Quen_Mat_Khau: " + ex);
	           ex.printStackTrace();
	       }
	   }
   }
   public void create_Name_Game_in_Inventory()
   {
   	System.out.println("abc");
   	String query = "select ten_game, tai_khoan from inventory where tai_khoan = '" + Controller_Dang_Nhap.account_name + "'";
       ResultSet resultSet;
       try {
           Statement statement = lay_du_lieu.connect.createStatement();
           resultSet = statement.executeQuery(query);
           while (resultSet.next()) {
           	Name_Game_List_Inventory.add(resultSet.getString(1));
           }
           
       } catch (Exception ex) {
           System.out.println("Loi o get_data_from_server: " + ex);
       }
       for (int i = 0; i < Name_Game_List_Inventory.size(); i++)
       {
       	System.out.println(Name_Game_List_Inventory.get(i));
       }
   }
}
