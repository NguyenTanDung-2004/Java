/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package Main;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Quan_Ly_Thu_Vien_Game extends Application {
   public static Stage Stage;
   public static Scene scene;
    public lay_du_lieu obj_lay_du_lieu;
    @Override
    public void start(Stage stage1) throws Exception {
        Stage = stage1;
        //Parent root = setup_root("/Dang_Nhap/FXML_Dang_Nhap.fxml");
    	String Path_FXML = "/Dang_Nhap/FXML_Dang_Nhap.fxml";
        Parent root = setup_root(Path_FXML);
    	//Parent root = FXMLLoader.load(getClass().getResource("/Vao_Game_Store/FXML_Vao_Game.fxml"));
       scene = new Scene(root);
        stage1.setScene(scene);
       // stage.setResizable(false);
        Image img = null;
        try {
        	img = new Image(getClass().getResource("/Image/Image_Logo.png").toExternalForm());
        }catch(Exception e)
        {
        	System.out.println(e);
        }
        stage1.getIcons().add(img);
        setup_size_for_Vao_Game(stage1, Path_FXML);
        stage1.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public Parent setup_root( String s)
    {
        try {
           Parent root = FXMLLoader.load(getClass().getResource(s));
           return root;
        } catch (IOException ex) {
            Logger.getLogger(Quan_Ly_Thu_Vien_Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void setup_size_for_Vao_Game(Stage stage, String Path)
    {
        if (Path == "/Dang_Nhap/FXML_Dang_Nhap.fxml")
        {
            stage.setMinHeight(450);
            stage.setMinWidth(600);
            stage.setMaxHeight(450);
            stage.setMaxWidth(600);
        }
        else if (Path == "/Vao_Game_Store/FXML_Vao_Game.fxml")
        {
            stage.setMinHeight(476);
            stage.setMinWidth(900);
        }
    }

    @Override
    public void init() throws Exception {
        this.obj_lay_du_lieu = new lay_du_lieu();
        this.obj_lay_du_lieu.connect_to_database();
        this.obj_lay_du_lieu.create_data();
    }
    
    
    
}
//169 247