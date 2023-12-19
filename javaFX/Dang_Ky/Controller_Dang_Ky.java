/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dang_Ky;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;

import Main.lay_du_lieu;
/**
 * FXML Controller class
 *
 * @author user
 */
public class Controller_Dang_Ky implements Initializable {

    @FXML
    TextField tf_Account;
    @FXML
    TextField tf_Account_Password;
    @FXML
    TextField tf_Email;
    @FXML
    Button btn_sign_up;
    @FXML
    Label lb_account;
    @FXML
    Label lb_signup_completly;
    @FXML
    TextField tf_code;
    @FXML
    Button btn_sendcode;
    @FXML
    Label lb_wait;
    /**
     * Initializes the controller class.
     */
    String code;
    int Flag = -2; // flag này dùng để cho phép có được nhấn send code hay không.
    Timeline timline;
    int count = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lb_account.setVisible(false);
        this.lb_signup_completly.setVisible(false);
        this.lb_wait.setVisible(false);
        add_event_for_control();
    }   
    public boolean check_account()
    {
    	if (tf_Account.getText() != "" && tf_Account_Password.getText() != "")
    	{
    		String query = "select tai_khoan from tai_khoan where tai_khoan = '" + tf_Account.getText() + "'";
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
                	return true;
                }
            } catch (Exception ex) {
                System.out.println("Loi o truy xuat tai khoan trong dang ky: " + ex);
            }
    	}
        return false;
    }
    public boolean check_email_and_code()
    {
    	if (tf_code.getText().equals(code))
    	{
    		return true;
    	}
    	return false;
    }
    public void event_click_button_signup()
    {
    	int n = 2;
        if (check_account() == false)
        {
        	this.lb_account.setVisible(true);
        	n = n - 1;
        }
        if (check_email_and_code() == false)
        {
        	this.lb_signup_completly.setVisible(true);
        	this.lb_signup_completly.setText("Your email or your code is wrong.");
        	this.lb_signup_completly.setStyle("-fx-text-fill: red; -fx-alignment: center");
        	n = n - 1;
        }
        if (n == 2)
        {
        	insert_into_tai_khoan();
        	this.lb_signup_completly.setText("Now you can login to use this app.");
        	this.lb_signup_completly.setVisible(true);
        	this.lb_signup_completly.setStyle("-fx-text-fill:  #4d908e; -fx-alignment: center");
        }
    }
    // tạo ra hai tab
    // tab thứu nhất là hiển thị toàn bộ ảnh 
    // tab thứ hai là hiển thị ảnh được search 
    public void insert_into_tai_khoan()
    {
    	String query = "insert into tai_khoan(tai_khoan, password, email) values (?, ?, ?)";
        try (PreparedStatement preparedStatement = lay_du_lieu.connect.prepareStatement(query)) {
            // Thiết lập giá trị cho các tham số
            preparedStatement.setString(1, tf_Account.getText());
            preparedStatement.setString(2, tf_Account_Password.getText());
            preparedStatement.setString(3, tf_Email.getText());

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
			System.out.println("loi insert o dang ky: " + e);
		}

    }
    public void event_click_textfield_account()
    {
        this.lb_account.setVisible(false);
    }
    public void event_click_textfield_Email()
    {
    	this.lb_signup_completly.setVisible(false);
    }
    public void event_click_textfield_Code()
    {
    	this.lb_signup_completly.setVisible(false);
    }
    public void assgin_timeline_for_sendcode()
    {
    	this.timline = new Timeline(new KeyFrame(Duration.seconds(1), event->decrease_flag()));
    	this.timline.setCycleCount(60);
    	timline.play();
    }
    public void decrease_flag()
    {
    	count++;
    	this.Flag = this.Flag - 1;
    	this.lb_wait.setText("wait " + Flag + " to click send code again.");
    	if (count >= 60)
    	{
    		timline.stop();
    		this.Flag = -2;
    		this.count = 0;
    		this.lb_wait.setVisible(false);
    	}
    }
    public void event_click_sendcode(String to)
    {
    	if (to != "" && Flag == -2)
    	{
    		 Flag = 60;
    		 this.lb_wait.setVisible(true);
    		 assgin_timeline_for_sendcode();
    		 Random rd = new Random();
    		 int random1 = rd.nextInt(10 - 1 + 1) + 1;
    		 int random2 = rd.nextInt(10 - 0 + 0) + 0;
    		 int random3 = rd.nextInt(10 - 0 + 0) + 0;
    		 int random4 = rd.nextInt(10 - 0 + 0) + 0;
    		 code = random1 + "" + random2 + "" + random3 + "" + random4;
    		 String content_email = "Your code is " + code + ".";
	    	 final String username = "tandungnguyen918@gmail.com";
	         final String password = "oese kloq vtgv mxii";
	
	         // Thông tin tài khoản email đích (email B)
	         // Cấu hình properties cho session
	         Properties props = new Properties();
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.smtp.starttls.enable", "true");
	         props.put("mail.smtp.host", "smtp.gmail.com");//Thay đổi nếu sử dụng email provider khác
	         props.put("mail.smtp.port", "587");//Thay đổi nếu sử dụng cổng khác
	
	         // Tạo đối tượng Session với thông tin xác thực
	         Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	             protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	                 return new javax.mail.PasswordAuthentication(username, password);
	             }
	         });
	
	         try {
	             // Tạo đối tượng MimeMessage
	             Message message = new MimeMessage(session);
	             
	             // Đặt thông tin người gửi (email A)
	             message.setFrom(new InternetAddress(username));
	             
	             // Đặt thông tin người nhận (email B)
	             
	
	             // Gửi email
	             	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	                 
	                 // Đặt chủ đề của email
	                 message.setSubject("SIGN UP GAME STORE APP.");
	                 
	                 // Đặt nội dung của email
	                 message.setText(content_email);
	                 Transport.send(message);
	
	             System.out.println("Email sent successfully!");
	
	         } catch (MessagingException e) {
	            System.out.println("Loi o gui email");
	         }
	         this.btn_sendcode.setVisible(true);;
    	}
    }
    public void add_event_for_control()
    {
        this.btn_sign_up.setOnAction(event->event_click_button_signup());
        this.tf_Account.setOnMouseClicked(event->event_click_textfield_account());
        this.tf_Email.setOnMouseClicked(event->event_click_textfield_Email());
        this.tf_code.setOnMouseClicked(event->event_click_textfield_Code());
        this.btn_sendcode.setOnAction(event->event_click_sendcode(tf_Email.getText()));
    }
    
}
