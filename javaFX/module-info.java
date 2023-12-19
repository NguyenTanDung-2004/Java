module copy {
	requires javafx.controls;
	requires java.logging;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.media;
	requires java.mail;
	requires java.activation;
	requires org.controlsfx.controls;
	exports Dang_Nhap;
	opens Dang_Nhap;
	exports Dang_Ky;
	opens Dang_Ky;
	exports Vao_Game_Store;
	opens Vao_Game_Store;
	exports Gioi_Thieu_Game;
	opens Gioi_Thieu_Game;
	exports Quen_Mat_Khau;
	opens Quen_Mat_Khau;
	opens Main to javafx.graphics, javafx.fxml;
}
