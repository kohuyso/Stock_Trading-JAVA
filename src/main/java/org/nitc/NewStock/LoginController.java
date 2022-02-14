package org.nitc.NewStock;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.nitc.Controller.ConnectDataBase;
import org.nitc.Controller.DangNhap_TK;
import org.nitc.Model.TK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.nitc.NewStock.App;


	

//	    @FXML
//	    private TextField password;
//
//	    @FXML
//	    private TextField username;
//
//	    @FXML
//	    void AboutClick(ActionEvent event) throws IOException {
//	    	App.setRoot("secondary");
//	    }
//
//	    @FXML
//	    void LogClick(ActionEvent event) throws IOException {
//	    	App.setRoot("secondary");
//	    }

	    
//	    @FXML
//	    void WarningClick(ActionEvent event) throws IOException {
////	    	String mk = new String (password.getText());
////	    	String tk = username.getText();
////	    	DangNhap_TK dn = new DangNhap_TK();
////	    	try {
////				TK taikhoan = dn.checkLogin(mk, tk);
////				if (taikhoan == null) {
////					App.Show("Loi", "Dang nhap that bai");
////				}
////				else {
////					App.setRoot("secondary");
////				}
////			} catch (Exception e) {
////				// TODO: handle exception
////			}
//	    		App.setRoot("secondary");
//
//	    }
		


public class LoginController {
		
	    @FXML
	    public Button AboutButton;


	    @FXML
	    private Button LoginButton;
	    

	    @FXML
	    private Button WarningButton;

	    @FXML
	    private TextField password;

	    @FXML
	    private TextField username;

	    @FXML
	    public void AboutClick(ActionEvent event) {
	    	
	    }
	    @FXML
	    void LoginClick(ActionEvent event) throws Exception {
	    	
	    	String mk = new String (password.getText());
	    	String tk = new String(username.getText());
	  
	    	App.setRoot("secondary");
	    	
	    
	//    	WarningButton.setStyle("-fx-base: #b6e7c9;");
	    	
	    	
	    }

	    @FXML
	    void WarningClick(ActionEvent event) {

	    }

	}

		
		
		
		
	

