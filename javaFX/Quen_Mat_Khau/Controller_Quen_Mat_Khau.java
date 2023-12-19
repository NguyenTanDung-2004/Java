package Quen_Mat_Khau;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Main.lay_du_lieu;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller_Quen_Mat_Khau implements Initializable{

	String code;
	String email;
	int flag = 0;// flag này dùng để kiểm tra xem liệu rằng gửi email có thành công hay không;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.lb_check.setVisible(false);
		this.lb_sentcode.setVisible(false);
		add_event_for_controls();
	}
	public void event_send_code_click()
	{
		flag = 0;
		this.lb_sentcode.setVisible(false);
		String to = get_email(tf_account.getText());
		email = to;
		if (to.equals(""))
		{
			this.lb_check.setText("Check your information again.");
            this.lb_check.setVisible(true);
            return;
		}
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
         props.put("mail.smtp.host", "smtp.gmail.com"); // Thay đổi nếu sử dụng email provider khác
         props.put("mail.smtp.port", "587"); // Thay đổi nếu sử dụng cổng khác

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
                 message.setSubject("Code to confirm new password.");
                 
                 // Đặt nội dung của email
                 message.setText(content_email);
                 Transport.send(message);

             System.out.println("Email sent successfully!");

         } catch (Exception e) {
            System.out.println("Loi o gui email" + e);
            this.lb_check.setText("Check your information again.");
            this.lb_check.setStyle("-fx-text-fill: red; -fx-alignment: center");
            this.lb_check.setVisible(true);
            flag = 1;
         }
	
	}
	public void update_password()
	{
		String query = "update tai_khoan set password = '" + tf_newpassword.getText() + "'" + "where tai_khoan = '" + tf_account.getText() + "'";
		try (PreparedStatement preparedStatement = lay_du_lieu.connect.prepareStatement(query)) {
            // Thiết lập giá trị cho các tham số
            

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
	        System.out.println("Loi o update trong Quen_Mat_Khau: " + e);
	    }

	}
	public void event_confirm_click()
	{
		int n = 3;
		if (flag == 1)
		{
			n = n - 1;
			System.out.println(flag);
		}
		if (check_newpassword_confirmpassword() == false)
		{
			n = n - 1;
			System.out.println("a");
		}
		if (check_code() == false)
		{
			n = n - 1;
			System.out.println("b");
		}
		if (n == 3)
		{
			this.lb_check.setText("Completetly!");
            this.lb_check.setStyle("-fx-text-fill:  #4d908e; -fx-alignment: center");
            this.lb_check.setVisible(true);
            update_password();
		}
		System.out.println(n);
	}
	public boolean check_newpassword_confirmpassword()
	{
		if (this.tf_confirmpassword.getText().equals(tf_newpassword.getText()) && this.tf_confirmpassword.getText() != "")
		{
			return true;
		}
		return false;
	}
	public boolean check_code()
	{
		if (this.tf_code.getText().equals(code))
		{
			return true;
		}
		return false;
	}
	public void check_signup()
	{
		
	}
	public String convert_account(String email)
	{
		String s = "";
		for (int i = 0; i < 3; i++)
		{
			s = s + email.charAt(i);
		}
		for (int i = 3; i < 14; i++)
		{
			s = s + "*";
		}
		for (int i = 14; i < email.length(); i++)
		{
			s = s + email.charAt(i);
		}
		return s;
	}
	public void add_event_for_controls()
	{
		this.btn_sendcode.setOnAction(event->{
			 Task<Void> task = new Task<Void>()
	            {
	                @Override
	                protected Void call() throws Exception {
	                	event_send_code_click();
	                    return null;
	                }
	            };
	            Thread thread = new Thread(task);
	            thread.start();
	            task.setOnSucceeded(e -> {
	                Platform.runLater(() -> {
	                	this.lb_sentcode.setText("We sent a code to " + convert_account(email));
	                    this.lb_sentcode.setVisible(true);
	                });
	            });
		});
		this.btn_confirm.setOnAction(event->event_confirm_click());
	}
	public String get_email(String tai_khoan)
	{
		String email = "";
		String query = "select email from tai_khoan where tai_khoan = '" + tai_khoan + "'";
	   ResultSet resultSet;
       try {
           Statement statement = lay_du_lieu.connect.createStatement();
           resultSet = statement.executeQuery(query);
           while (resultSet.next()) {
               email = resultSet.getString(1);
           }
       } catch (Exception ex) {
           System.out.println("Loi o truy xuat tai khoan trong Quen_Mat_Khau: " + ex);
       }
       System.out.println(email);
       return email;
	}
	@FXML
	TextField tf_newpassword;
	@FXML
	TextField tf_confirmpassword;
	@FXML
	TextField tf_code;
	@FXML
	Label lb_sentcode;
	@FXML
	Label lb_check;
	@FXML
	Button btn_confirm;
	@FXML
	Button btn_sendcode;
	@FXML
	TextField tf_account;
}
