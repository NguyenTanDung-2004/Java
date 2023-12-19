/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license 
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vao_Game_Store;

import Main.Quan_Ly_Thu_Vien_Game; 

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.ScrollBarSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import Main.lay_du_lieu;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import Gioi_Thieu_Game.Tao_du_lieu_fxml;
import Dang_Nhap.Controller_Dang_Nhap;
/**
 * FXML Controller class
 *
 * @author user
 */
public class Controller_Vao_Game implements Initializable {

    
    URL url;
    File file;
    MediaPlayer mediaPlayer;
    Media media;
    double Media_width;
    double Media_heigh;
    double ratio_media;
    ScrollPane scrollPane2;
    int Flag = 0; // cờ này dùng để kiểm tra có cho phép việc bật thêm một stage khác không.
    /**
     * Initializes the controller class.
     */
    ScrollPane scrollPane;
    ObservableList<Node> list_VBOX;
    public void create_autocomplete()
    {
    	ArrayList<String> obj = new ArrayList<>();
    	for (int i = 0; i < lay_du_lieu.Name_Game_List.size(); i++)
    	{
    		obj.add(lay_du_lieu.Name_Game_List.get(i));
    	}
    	obj.add("All Game");
    	AutoCompletionBinding<String> autoCompleteBinding = TextFields.bindAutoCompletion(this.tf_search, obj);
    	 autoCompleteBinding.setOnAutoCompleted(event -> {
             String selectedGame = event.getCompletion();
             if (selectedGame.equals("All Game"))
             {
            	 if (this.flowpane_search_game.getChildren().size() > 0)
        		 {
        			 this.Flow_chua_game_trong_GameStore.getChildren().add(this.flowpane_search_game.getChildren().get(0));
        		 }
            	 this.flowpane_search_game.setVisible(false);
            	 this.Flow_chua_game_trong_GameStore.setVisible(true);
             }
             for (int i = 0; i < list_VBOX.size(); i++)
             {
            	 VBox vb = (VBox)list_VBOX.get(i);
            	 if (get_name_from_Vbox(vb).equals(selectedGame))
            	 {
            		 if (this.flowpane_search_game.getChildren().size() > 0)
            		 {
            			 this.Flow_chua_game_trong_GameStore.getChildren().add(this.flowpane_search_game.getChildren().get(0));
            		 }
            		 this.flowpane_search_game.getChildren().add(vb);
            		 this.Flow_chua_game_trong_GameStore.setVisible(false);
            		 this.flowpane_search_game.setVisible(true);
            		 return;
            	 }
             }
             
             // Thực hiện các xử lý khác dựa trên game được chọn (ví dụ: hiển thị thông tin về game, v.v.).
         });
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	this.flowpane_search_game.setVisible(false);
    	this.NumberGames_in_Inventory = this.lb_Number_game;
    	this.Inventory_Name.setText(Controller_Dang_Nhap.account_name + "'s Inventory");
    	this.borderpane_inventory.setVisible(true);
    	   	
    	CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> Khoi_tao_mediaView("/Video/Video.mp4"));

    	CompletableFuture<Void> allTasks = task1
    	        .thenCompose(result1 -> CompletableFuture.runAsync(() -> them_scrollpane_vao_inventory()))
    	        .thenCompose(result2 -> CompletableFuture.runAsync(() -> them_su_kien_Stackpane_thay_doi_kich_thuoc()))
    	        .thenCompose(result3 -> CompletableFuture.runAsync(() -> them_scrollpane_vao_BorderPane_chua_game_video()))
    	        .thenCompose(result4 -> CompletableFuture.runAsync(() -> add_event_chuyendoi()))
    	        .thenCompose(result5 -> CompletableFuture.runAsync(() -> cai_dat_Flow_chua_game_trong_GameStore()))
    	        .thenCompose(result6 -> CompletableFuture.runAsync(() -> Them_Game_Vao_Flow_chua_game_trong_GameStore()))
    	        .thenCompose(result7 -> CompletableFuture.runAsync(() -> b()))
    	        .thenCompose(result7 -> CompletableFuture.runAsync(() -> create_autocomplete()));
    	try {
    	    allTasks.get();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
    public void b()
    {
    	this.AnchoPane_contain_list_Game_in_Inventory.getChildren().remove(0);
    	this.flowpane = new FlowPane();
    	this.AnchoPane_contain_list_Game_in_Inventory.getChildren().add(this.flowpane);
    	this.AnchoPane_contain_list_Game_in_Inventory.setTopAnchor(this.flowpane, 0.0);
    	this.AnchoPane_contain_list_Game_in_Inventory.setLeftAnchor(this.flowpane, 0.0);
    	this.AnchoPane_contain_list_Game_in_Inventory.setRightAnchor(this.flowpane, 20.0);
    	this.AnchoPane_contain_list_Game_in_Inventory.setBottomAnchor(this.flowpane, 10.0);
    	this.flowpane.setVgap(30);
    	this.lb_Number_game.setText("Number of game: " + Controller_Dang_Nhap.Name_Game_List_Inventory.size());
    	create_game_in_inventory();
    	this.list_VBOX = this.Flow_chua_game_trong_GameStore.getChildren();
    }
    public void create_game_in_inventory() 
    {
    	for (int i = 0; i < Controller_Dang_Nhap.Name_Game_List_Inventory.size(); i++)
    	{
    		String Name = Controller_Dang_Nhap.Name_Game_List_Inventory.get(i);
    		String Path = "/Image_Game/" + Name +".jpg";
    		String info = get_Infor(Name);
    		BorderPane bd = new BorderPane();
    		if (check_owned_game(Name) == 0)
    		{
    			bd = create_one_game_in_inventory(info, Path, Name, "/Image/Image_Download.png", "/Image/Image_close.png", "0");
    		}
    		else
    		{
        		bd = create_one_game_in_inventory(info, Path, Name, "/Image/Image_Play.png", "/Image/Image_close.png", "1");

    		}
    		this.flowpane.getChildren().add(bd);
    		Games_in_Inventory.add(bd);
    	}
    }
    public int check_owned_game(String name)
    {
    	String query = "select trang_thai from inventory where tai_khoan = '" +  Controller_Dang_Nhap.account_name + "' and ten_game = '" + name + "'";
    	ResultSet resultSet;
    	String trang_thai = "";
        try {
            Statement statement = lay_du_lieu.connect.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
               trang_thai = resultSet.getString(1);
            }
        } catch (Exception ex) {
            System.out.println("Loi o get_data_from_server: " + ex);
        }
    	if (trang_thai.equals("1"))
    	{
    		System.out.println("lenguyenhonghan");
    		return 1;
    	}
    	else
    	{
    		System.out.println("lenguyenhonghan1");
    		return 0;
    	}
    	
    }
    public String get_Infor(String Name)
    {
    	for (int i = 0; i < lay_du_lieu.Name_Game_List.size(); i++)
    	{
    		if (Name.equals(lay_du_lieu.Name_Game_List.get(i)))
    		{
    			return lay_du_lieu.Info_Game_List.get(i);
    		}
    	}
    	return "";
    }
    public static Label NumberGames_in_Inventory;
    public static ArrayList<BorderPane> Games_in_Inventory = new ArrayList<>();
    Label lb_copy_lb3;
    @FXML
    BorderPane BorderPane_chua_game_video;
    @FXML
    MediaView MediaView_chua_video;
    @FXML
    AnchorPane anchorpane_chua_tat_ca;
    @FXML
    StackPane stackPane_chua_BorderPane_chua_game_video;
    @FXML
    FlowPane Flow_chua_game_trong_GameStore;
    @FXML
    Label lb_thay_doi_welcome;
    @FXML
    Label lb_o_tren_thanh_cong_cu;
    @FXML
    TextField tf_search;
    @FXML
    Label lb_inventory;
    @FXML
    Label lb_GameStore;
    @FXML
    BorderPane borderpane_inventory;
    @FXML
    BorderPane Inventory_Empty;
    @FXML
    BorderPane Inventory_chua_game;
    @FXML
    Label Inventory_Name;
    @FXML
    BorderPane One_Game_in_Inventory;
    @FXML
    AnchorPane AnchoPane_contain_list_Game_in_Inventory;
    @FXML
    StackPane stackpane_contain_AnchoPane_contain_list_Game_in_Inventory;
    @FXML 
    FlowPane flow123;
    @FXML
    Label lb_Number_game;
    // @FXML trong border.
    
    @FXML
    VBox VBox_1;
    @FXML
    ImageView ImageView_2;
    @FXML
    Label lb_3;
    @FXML
    BorderPane Border4;
    @FXML
    Label label5;
    @FXML
    BorderPane border6;
    @FXML
    Label label7;
    @FXML
    ProgressBar progress8;
    @FXML
    BorderPane border9;
    @FXML
    BorderPane border10;
    @FXML
    BorderPane border11;
    @FXML
    ImageView ImageV12;
    @FXML
    BorderPane border13;
    @FXML
    ImageView imgv14;
    //@FXML trong border.
    BorderPane bd;
    public static FlowPane flowpane;
    public void update_number_of_games()
    {
    	this.NumberGames_in_Inventory.setText("Number of game: " + Controller_Dang_Nhap.Name_Game_List_Inventory.size());
    }
    public void change_image_play(ImageView imgv)
    {
    	Image img123 = new Image(getClass().getResource("/Image/Image_Play.png").toExternalForm());
    	imgv.setImage(img123);
    }
    String absolutePath = "";
    // Hàm khởi tạo cho controls ở trong border trên
    public void event_click_download(String name, ImageView imgv, ProgressBar pgb)
    {
    	String Image_Path = imgv.getImage().getUrl();
        String[] array = Image_Path.split("/");
        
        if (array[array.length - 1].equals("Image_Download.png"))
        {
        	DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Chọn thư mục");
            // Hiển thị hộp thoại chọn thư mục và nhận về đối tượng File đại diện cho thư mục đã chọn
            File selectedDirectory = directoryChooser.showDialog(Quan_Ly_Thu_Vien_Game.Stage);
            if (selectedDirectory != null) {
                // Lấy đường dẫn tuyệt đối từ đối tượng File
                absolutePath = selectedDirectory.getAbsolutePath();
                System.out.println("Đường dẫn thư mục đã chọn: " + absolutePath);
            } else {
                System.out.println("Không có thư mục nào được chọn.");
            }
            Task<Void> downloadTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    insert_path_into_inventory(selectedDirectory.getAbsolutePath(), Controller_Dang_Nhap.account_name, name);
                    updateProgress(1, 9);
                    download_game_from_server(name, absolutePath);
                    update_trang_thai(name, Controller_Dang_Nhap.account_name, "1");
                    for (int i = 2; i < 10; i++)
                    {
                    	updateProgress(i, 9);
                    	Thread.sleep(1000);
                    }
                    System.out.println("soluong file:  " + x);
                    return null;
                }
            };

            // Bind the ProgressBar to the progress of the download task
            pgb.progressProperty().bind(downloadTask.progressProperty());
            downloadTask.setOnSucceeded(e -> {
                change_image_play(imgv);
            });
            // Set up event handlers for task completion

            // Start the download task in a new thread
            Thread thread = new Thread(downloadTask);
            thread.start();
            pgb.progressProperty().bind(downloadTask.progressProperty());
//            insert_path_into_inventory(selectedDirectory.getAbsolutePath(), Controller_Dang_Nhap.account_name, name);
//            download_game_from_server(name, absolutePath);
//            update_trang_thai(name, Controller_Dang_Nhap.account_name);
//            change_image_play(imgv);
        }
        else
        {
        	String duong_dan_chay_game = "";
        	String query1 = "select duong_dan_chay_game from game where ten_game = '" + name + "'";
        	ResultSet resultSet1;
            try {
                Statement statement = lay_du_lieu.connect.createStatement();
                resultSet1 = statement.executeQuery(query1);
                while (resultSet1.next()) {
                   duong_dan_chay_game = resultSet1.getString(1);
                }
            } catch (Exception ex) {
                System.out.println("Loi o lay duong_dan_chay_game trong Controller_Vao_Game: " + ex);
            }
            String folder = "";
            String query2 = "select duong_dan from inventory where ten_game = '" + name + "' and tai_khoan = '" + Controller_Dang_Nhap.account_name + "'"; 
            ResultSet resultSet2;
            try {
                Statement statement = lay_du_lieu.connect.createStatement();
                resultSet2 = statement.executeQuery(query2);
                while (resultSet2.next()) {
                   folder = resultSet2.getString(1);
                }
            } catch (Exception ex) {
                System.out.println("Loi o lay duong_dan trong Controller_Vao_Game: " + ex);
            }
            String s1 = folder + "\\" + name + "\\" + "__Start game + create shortcut.bat";
            String s = folder + "\\" + duong_dan_chay_game;
            System.out.println(s);
            File f = new File (s);
            if (f.exists())
            {
            	try {
                String gameExePath = s;
                String batchFilePath = s1;
                File f123 = new File (batchFilePath);
                if (f123.exists() == false)
                {
                	System.out.println("no batch");
                	Desktop.getDesktop().open(f);
                	return;
                }
                System.out.println("batch");
                // Kiểm tra xem file .exe có tồn tại không
                File gameExeFile = new File(gameExePath);
                if (gameExeFile.exists()) {
                    // Mở file .exe
                    openExecutable(gameExePath);

                    // Chạy tệp batch
                    runBatchFile(batchFilePath);
                } else {
                    System.out.println("Không tìm thấy file .exe.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
            else
            {
            	Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Path error");
                alert.setHeaderText("Please check about this path: " + s);
                alert.setContentText("Something wrong or you changed this path. To resolve this problem, you can delete this game in Inventory and re-download it.");
                if(alert.showAndWait().get() == ButtonType.CLOSE)
                {
                }
                else
                {
                }
            }
           
        }
        
    }
    private static void openExecutable(String exePath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(exePath);
        processBuilder.start();
    }

    private static void runBatchFile(String batchFilePath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", batchFilePath);
        processBuilder.start();
    }
    private static boolean deleteFolder(File folder, String Folder_Parent) {
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Recursive call to delete subdirectories and files
                        deleteFolder(file, Folder_Parent);
                    } else {
                        // Delete files in the folder
                        file.delete();
                    }
                }
            }

            // Check if the folder is the root directory
            if (folder.equals(new File(Folder_Parent))) {
                return true; // Do not delete the root directory
            }

            // Delete the empty folder after deleting its contents
            return folder.delete();
        }
        return false;
    }
    private int x = 0;
    public void download_game_from_server(String ten_game, String Path)
    {
    	String query = "select ten_game, du_lieu, duong_dan_file from du_lieu_game where  ten_game = " + "'" + ten_game + "'";
        ResultSet resultSet;
        try {
            PreparedStatement prestatement = lay_du_lieu.connect.prepareStatement(query);
            resultSet = (ResultSet)prestatement.executeQuery();
            while (resultSet.next()) {
            	x++;
//            	if (resultSet.getBlob("du_lieu") == null)
//            	{
//            		String duong_dan = resultSet.getString("duong_dan_file");
//            		 String file_name = Path + "\\" + ten_game + "\\" + duong_dan;
//            		 File f = new File (file_name);
//            		 if (f.exists() == false)
//            		 {
//            			 boolean a = f.mkdir();
//            		 }
//            		continue;
//            	}
                Blob blob = resultSet.getBlob("du_lieu");
                
                String duong_dan = resultSet.getString("duong_dan_file");
                byte[] imagae_data = blob.getBytes(1, (int)blob.length());
                String file_name = Path + "\\" + ten_game + "\\" + duong_dan;
                create_file(file_name);
                System.out.println("nguyentandung");
                try {
                    FileOutputStream f1 = new FileOutputStream(file_name);
                    f1.write(imagae_data);
                    f1.close();
                } catch (Exception  ex) {
                    System.out.println("Loi o download_game try catch1: " + ex);
                }
            }
        } catch (Exception e) {
        	System.out.println("Loi o download_game try catch2: " + e);
        }
    }
    public void update_trang_thai(String ten_game, String account, String Trang_Thai)
    {
    	String query = "update inventory set trang_thai = '" + Trang_Thai + "' where ten_game = '" + ten_game + "' and tai_khoan = '" + account + "'";
    	 try (PreparedStatement preparedStatement = lay_du_lieu.connect.prepareStatement(query)) {
             // Thiết lập giá trị cho các tham số
             //preparedStatement.setString(1, Path);

             // Thực hiện truy vấn INSERT
             int rowsAffected = preparedStatement.executeUpdate();

             if (rowsAffected > 0) {
                 System.out.println("Dữ liệu đã được thêm thành công!");
             } else {
                 System.out.println("Kh ông có dữ liệu nào được thêm.");
             }
         }
 	    catch (Exception e)
 	    {
 	        System.out.println("loi o update trang_thai: " + e); 
 	    }
    }
    public void create_file(String s)
    {
        File f = new File (s);
        String parent = f.getParent();
        File f_parent = new File (parent);
        if (f_parent.exists() == false)
        {
            f_parent.mkdirs();
        }
        try {
            f.createNewFile();
        } catch (Exception ex) {
            System.out.println("Loi o createfile in controller_vao_game: " + ex);
        }
    }
    public void insert_path_into_inventory(String Path, String account, String name_game)
    {
    	String s = Path.replace("\\", "\\\\");
    	String query = "update inventory set duong_dan = '" + s + "' where tai_khoan = '" + account + "' and ten_game = '" + name_game + "'"; 
        try (PreparedStatement preparedStatement = lay_du_lieu.connect.prepareStatement(query)) {
            // Thiết lập giá trị cho các tham số
            //preparedStatement.setString(1, Path);

            // Thực hiện truy vấn INSERT
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Dữ liệu đã được thêm thành công!");
            } else {
                System.out.println("Kh ông có dữ liệu nào được thêm.");
            }
        }
	    catch (Exception e)
	    {
	        System.out.println("loi o update duong_dan: " + e); 
	    }

    }
    public void event_click_close(String Name) 
    {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setWidth(400);
        alert.setTitle("Remove Game out inventory.");
        alert.setHeaderText("Remove " + Name + " ?");
        alert.setContentText("Do you want to remove this game and delete this game on disk?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
        	for (int i = 0; i < Controller_Dang_Nhap.Name_Game_List_Inventory.size(); i++)
        	{
        		if (Name.equals(Controller_Dang_Nhap.Name_Game_List_Inventory.get(i)))
        		{
                	this.flowpane.getChildren().remove(i);
                	Controller_Dang_Nhap.Name_Game_List_Inventory.remove(i);
                	String duong_dan_chay_game = "";
                	String query1 = "select duong_dan_chay_game from game where ten_game = '" + Name + "'";
                	ResultSet resultSet1;
                    try {
                        Statement statement = lay_du_lieu.connect.createStatement();
                        resultSet1 = statement.executeQuery(query1);
                        while (resultSet1.next()) {
                           duong_dan_chay_game = resultSet1.getString(1);
                        }
                    } catch (Exception ex) {
                        System.out.println("Loi o lay duong_dan_chay_game trong Controller_Vao_Game: " + ex);
                    }
                    String folder = "";
                    String query2 = "select duong_dan from inventory where ten_game = '" + Name + "' and tai_khoan = '" + Controller_Dang_Nhap.account_name + "'"; 
                    ResultSet resultSet2;
                    try {
                        Statement statement = lay_du_lieu.connect.createStatement();
                        resultSet2 = statement.executeQuery(query2);
                        while (resultSet2.next()) {
                           folder = resultSet2.getString(1);
                        }
                    } catch (Exception ex) {
                        System.out.println("Loi o lay duong_dan trong Controller_Vao_Game: " + ex);
                    }
                    File f = new File (folder + "\\" + Name);
                    delete_game_out_inventory(Name, Controller_Dang_Nhap.account_name);
                    if (deleteFolder(f, folder))
                    {
                    	System.out.println("xoa thanh cong");
                    }
                    update_number_of_games();
        		}
        	}
        }
        
    }
    public void delete_game_out_inventory(String name, String account)
    {
    	String query = "delete from inventory where ten_game = '" + name + "' and tai_khoan = '" + account + "'";
    	try (PreparedStatement preparedStatement = lay_du_lieu.connect.prepareStatement(query)) {
            // Thiết lập giá trị cho các tham số
            //preparedStatement.setString(1, Path);

            // Thực hiện truy vấn INSERT
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Dữ liệu đã được thêm thành công!");
            } else {
                System.out.println("Kh ông có dữ liệu nào được thêm.");
            }
        }
	    catch (Exception e)
	    {
	        System.out.println("loi o update trang_thai: " + e); 
	    }
    }
    public BorderPane create_one_game_in_inventory(String info, String Path1, String Name, String Path2, String Path3, String trang_thai)
    {
    	BorderPane borderpane = new BorderPane();
    	borderpane.setMinHeight(143);
    	borderpane.setMaxHeight(143);
    	borderpane.setPrefWidth(this.flowpane.getWidth() - 20);
    	borderpane.setMinWidth(BorderPane.USE_COMPUTED_SIZE);
    	borderpane.setStyle("-fx-background-color:  #343a40; -fx-background-radius: 20");
    	VBox vb = create_VBox();
    	borderpane.setLeft(vb);
    	ImageView imgv = create_ImageView_2(Path1);
    	vb.getChildren().add(imgv);
    	Label lb = create_lb_3(Name);
    	vb.getChildren().add(lb);
    	BorderPane bordercenter = create_bordercenter(info);
    	borderpane.setCenter(bordercenter);
    	ProgressBar pgb = new ProgressBar();
    	ObservableList<Node> obj_list = bordercenter.getChildren();
    	for (int i = 0; i < obj_list.size(); i++)
    	{
    		if (obj_list.get(i) instanceof ProgressBar)
    		{
    			pgb = (ProgressBar) obj_list.get(i);
    		}
    	}
    	if (trang_thai.equals("1"))
    	{
    		pgb.setProgress(1.0);
    	}
    	BorderPane borderpaneleft = create_borderpaneleft(Name, Path2, Path3, pgb);
    	borderpane.setRight(borderpaneleft);
    	
    	return borderpane;
    }
    public BorderPane create_borderpaneleft(String Name, String Path1, String Path2, ProgressBar pgb)
    {
    	BorderPane borderpaneleft = new BorderPane();
    	BorderPane bd = new BorderPane();
    	bd.setPrefSize(60, 143);
    	Image img1 = new Image(getClass().getResource(Path1).toExternalForm());
    	ImageView imgv1 = new ImageView(img1);
    	imgv1.setOnMouseClicked(event->event_click_download(Name, imgv1, pgb));
    	imgv1.setCursor(Cursor.HAND);
    	Image img2 = new Image(getClass().getResource(Path2).toExternalForm());
    	ImageView imgv2 = new ImageView(img2);
    	imgv2.setOnMouseClicked(event->event_click_close(Name));
    	imgv2.setCursor(Cursor.HAND);
    	imgv1.setFitHeight(55);
    	imgv1.setFitWidth(54);
    	imgv2.setFitHeight(36);
    	imgv2.setFitWidth(36);
    	BorderPane bd1 = new BorderPane();
    	bd1.setPrefSize(60, 84);
    	bd1.setCenter(imgv1);
    	BorderPane bd2 = new BorderPane();
    	bd2.setPrefSize(60, 78);
    	bd2.setCenter(imgv2);
    	bd.setCenter(bd1);
    	bd.setBottom(bd2);
    	borderpaneleft.setCenter(bd);
    	borderpaneleft.setPrefSize(60, 143);
    	borderpaneleft.setMinSize(60, 143);
    	borderpaneleft.setMaxSize(60, 143);
    	return borderpaneleft;
    }
    public BorderPane create_bordercenter(String info)
    {
    	BorderPane bordercenter = new BorderPane();
    	HBox hb = new HBox();
    	Label lb = new Label("Game Info:");
    	lb.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-alignment: center; -fx-underline: true");
    	lb.setPrefWidth(150);
    	lb.setMaxWidth(150);
    	lb.setMinWidth(90);
    	lb.setPrefHeight(30);
    	hb.getChildren().add(lb);
    	hb.setAlignment(javafx.geometry.Pos.CENTER);
    	bordercenter.setTop(hb);
    	Label lb1 = new Label();
    	lb1.setStyle("-fx-font-size: 12; -fx-text-fill: white; -fx-alignment: center; -fx-underline: false");
    	lb1.setText(info);
    	lb1.setWrapText(true);
    	bordercenter.setCenter(lb1);
    	BorderPane bd = new BorderPane();
    	bd.setMaxWidth(13);
    	bd.setMinWidth(13);
    	bordercenter.setLeft(bd);
    	ProgressBar prg = new ProgressBar();
    	prg.setProgress(0);
    	prg.setMinHeight(20);
    	prg.setMaxHeight(20);
    	prg.setMaxWidth(1000);
    	bordercenter.setBottom(prg);
    	return bordercenter;
    }
    public VBox create_VBox()
    {
    	VBox vb = new VBox();
    	vb.setMinSize(200, 143);
    	vb.setMaxSize(200, 143);
    	return vb;
    }
    public ImageView create_ImageView_2(String Path)
    {
    	Image img = new Image(getClass().getResource(Path).toExternalForm());
    	ImageView imgv = new ImageView(img);
    	imgv.setFitHeight(116);
    	imgv.setFitWidth(200);
    	return imgv;
    }
    public Label create_lb_3(String s)
    {
    	Label lb = new Label();
    	lb.setStyle("-fx-alignment: center; -fx-background-color: #0077b6; -fx-background-radius: 30;");
    	lb.setPrefWidth(205);
    	lb.setPrefHeight(15);
    	lb.setMaxSize(205, 15);
    	lb.setStyle("-fx-alignment:center; -fx-background-color: #0077b6; -fx-background-radius:30; -fx-font-size:20; -fx-text-fill: white ");
    	lb.setText(s);
    	return lb;
    }
    // Hàm khởi tạo cho controls ở trong border trên
    public void Event_AnchorPane_thay_doi_kich_thuoc()
    {
        this.lb_thay_doi_welcome.setPrefSize(187 + this.anchorpane_chua_tat_ca.getWidth() - 780, this.lb_thay_doi_welcome.getHeight());
        this.lb_o_tren_thanh_cong_cu.setPrefWidth(this.anchorpane_chua_tat_ca.getWidth());
        this.One_Game_in_Inventory.setPrefWidth(364 + this.anchorpane_chua_tat_ca.getWidth() - 780);
        for (int i = 0; i < Games_in_Inventory.size(); i++)
        {
        	Games_in_Inventory.get(i).setPrefWidth(475 + this.anchorpane_chua_tat_ca.getWidth() - 900);
        }
    }
    public void them_su_kien_Stackpane_thay_doi_kich_thuoc()
    {
       this.anchorpane_chua_tat_ca.widthProperty().addListener(event->Event_AnchorPane_thay_doi_kich_thuoc());
    }
    public void them_scrollpane_vao_BorderPane_chua_game_video()
    {
        scrollPane = new ScrollPane(BorderPane_chua_game_video);
        scrollPane.setStyle("-fx-background-color:  #161a1d");
         scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        stackPane_chua_BorderPane_chua_game_video.getChildren().add(scrollPane);
       scrollPane.setVisible(false);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);// tắt hết toàn bộ thanh scrollpane nhưng vẫn kéo được bằng lăn chuột.
         scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // bật thanh scrollpane dọc lên.
         Platform.runLater(() -> {
            Set<Node> nodes = scrollPane.lookupAll(".scroll-bar");
            System.out.println(nodes.size());
            for (Node node : nodes) {
                if (node instanceof ScrollBar) {
                    ScrollBar scrollBar = (ScrollBar) node;
                    // Kiểm tra và set style cho từng thanh ScrollBar tùy ý
                    if (scrollBar.getOrientation() == Orientation.VERTICAL) {
                        scrollBar.setStyle("-fx-background-color:  #161a1d;");
                        ScrollBarSkin skin = (ScrollBarSkin) scrollBar.getSkin();
                        Node thumb = scrollBar.lookup(".thumb");
                        thumb.setStyle("-fx-background-radius: 10; -fx-background-color:  #3f4045");
                    }
                }
            }
    
            });
    }
    public void Khoi_tao_mediaView(String Path_video)
    {
            url = getClass().getResource(Path_video);
            file = new File(url.getFile());
            media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            MediaView_chua_video.setMediaPlayer(mediaPlayer);
            mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
            mediaPlayer.setOnReady(()->{
                Media_heigh = media.getHeight();
                Media_width = media.getWidth();
                ratio_media = Media_width / Media_heigh;
                cai_dat_kich_thuoc_cho_MediaView(800);
                
            });
            mediaPlayer.play();
        
    }
    public void cai_dat_kich_thuoc_cho_MediaView(double width)
    {
        MediaView_chua_video.setFitWidth(width);
        MediaView_chua_video.setFitHeight(width / ratio_media);
    }
    public void cai_dat_Flow_chua_game_trong_GameStore()
    {
        this.Flow_chua_game_trong_GameStore.setHgap(16);
        this.Flow_chua_game_trong_GameStore.setVgap(50);
    }
    public void Them_Game_Vao_Flow_chua_game_trong_GameStore()
    {
        for (int i = 0; i < 26; i ++)
        {
            VBox vb = Tao_Game("/Image_Game/" + lay_du_lieu.Name_Game_List.get(i) + ".jpg", lay_du_lieu.Name_Game_List.get(i));
            this.Flow_chua_game_trong_GameStore.getChildren().add(vb);
            vb.setOnMouseEntered(event->Event_Enter_cho_VBox_TaoGame(vb));
            vb.setOnMouseExited(event->Event_Exit_cho_VBox_TaoGame(vb));
             vb.setOnMouseClicked(event->event_VBox_TaoGame_click("/Gioi_Thieu_Game/FXML_Gioi_Thieu_Game.fxml", vb));   
        }
       
    }
    public VBox Tao_Game(String Path_image, String GameName)
    {
        VBox vb = new VBox();
        vb.setPrefSize(250, 200);
        Image img = new Image(getClass().getResourceAsStream(Path_image));
        ImageView imgv = new ImageView(img);
        imgv.setFitHeight(150);
        imgv.setFitWidth(250);
        imgv.setStyle("-fx-border-width: 30; -fx-border-color: red");
        Label lb = new Label(GameName);
        lb.setPrefSize(250, 50);
        vb.getChildren().add(imgv);
        vb.getChildren().add(lb);
        lb.setStyle("-fx-text-fill: white; -fx-alignment: center; -fx-font-size: 25; -fx-background-color: #0077b6; -fx-background-radius: 30");
        vb.setStyle("-fx-background-radius: 30");
        return vb;
    }
    public void Event_Enter_cho_VBox_TaoGame(VBox vb)
    {
        vb.setCursor(Cursor.HAND);
        vb.setStyle("-fx-background-radius: 30; -fx-border-width: 1; -fx-border-color: white");
    }
    public void Event_Exit_cho_VBox_TaoGame(VBox vb)
    {
        vb.setCursor(Cursor.DEFAULT);
        vb.setStyle("");
    }
    public void GameStorechange()
    {
        this.borderpane_inventory.setVisible(false);
        this.BorderPane_chua_game_video.setVisible(true);
        this.scrollPane.setVisible(true);
         this.scrollPane2.setVisible(false);
    }
    public void Inventorychange() 
    {
        this.borderpane_inventory.setVisible(true);
        this.scrollPane.setVisible(false);
        this.BorderPane_chua_game_video.setVisible(false);
        this.scrollPane2.setVisible(true);
    }
    public void add_event_chuyendoi()
    {
        this.lb_GameStore.setOnMouseClicked(event->GameStorechange());
        this.lb_inventory.setOnMouseClicked(event->Inventorychange());
    }
    public void them_scrollpane_vao_inventory()
    {
    	//this.stackpane_contain_AnchoPane_contain_list_Game_in_Inventory.setStyle("-fx-background-color:#161a1d");	
        scrollPane2 = new ScrollPane(AnchoPane_contain_list_Game_in_Inventory);
        scrollPane2.setStyle("-fx-background-color:#161a1d");
         scrollPane2.setFitToWidth(true);
        scrollPane2.setFitToHeight(true);
        stackpane_contain_AnchoPane_contain_list_Game_in_Inventory.getChildren().add(scrollPane2);
        this.scrollPane2.setVisible(true);
        scrollPane2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);// tắt hết toàn bộ thanh scrollpane nhưng vẫn kéo được bằng lăn chuột.
         scrollPane2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // bật thanh scrollpane dọc lên.
         Platform.runLater(() -> {
            Set<Node> nodes = scrollPane2.lookupAll(".scroll-bar");
            for (Node node : nodes) {
                if (node instanceof ScrollBar) {
                    ScrollBar scrollBar = (ScrollBar) node;
                    // Kiểm tra và set style cho từng thanh ScrollBar tùy ý
                    if (scrollBar.getOrientation() == Orientation.VERTICAL) {
                        scrollBar.setStyle("-fx-background-color:  #161a1d;");
                        ScrollBarSkin skin = (ScrollBarSkin) scrollBar.getSkin();
                        Node thumb = scrollBar.lookup(".thumb");
                        thumb.setStyle("-fx-background-radius: 10; -fx-background-color:  #3f4045");
                    }
                }
            }
    
            });
    
    }
    @FXML
    FlowPane flowpane_search_game;
    public String get_name_from_Vbox(VBox vb)
    {
         ObservableList<Node> vb_children = vb.getChildren();
         Label lb = (Label)vb_children.get(1);
         return lb.getText();
    }
    VBox vb = new VBox();
    public static String name_game; // biến này dùng để lấy ra game được chọn trong phần giới thiệu.
    public void event_VBox_TaoGame_click(String fxml_path, VBox vb)
    {
        if (Flag == 0)
        {
            name_game = get_name_from_Vbox(vb);
            System.out.println(name_game);
            Tao_du_lieu_fxml.game_name = name_game;
            int Index = index_of_game(name_game);
            Tao_du_lieu_fxml.Game_info = lay_du_lieu.Info_Game_List.get(Index);
            Tao_du_lieu_fxml.Refe_link = lay_du_lieu.Link_tham_khao_List.get(Index);
            Stage stage = new Stage();
            try {
                Parent root = FXMLLoader.load(getClass().getResource(fxml_path));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaxWidth(360);
                stage.setMaxHeight(595);
                stage.setMinWidth(360);
                stage.setMinHeight(595);
                Image imgage = new Image(getClass().getResource("/Image/Image_Logo.png").toExternalForm());
                stage.getIcons().add(imgage);
                Flag = 1;
                stage.showAndWait();
                Flag = 0;
            } catch (IOException ex) {
                Logger.getLogger(Quan_Ly_Thu_Vien_Game.class.getName()).log(Level.SEVERE, null, ex);
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
    public int index_of_game(String game_name)
    {
        for (int i = 0; i < lay_du_lieu.Name_Game_List.size(); i++)
        {
            if (game_name == lay_du_lieu.Name_Game_List.get(i))
            {
                return i;
            }
        }
        return 0;
    }
    public BorderPane create_One_Game_in_Inventory(int i, String Path_img, String name)
    {
    	
    	return null;
    }
}