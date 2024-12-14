package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ViewRegister {
	
	private VBox vb;
	private BorderPane bp;
	private Scene registerScene;
	private TextField userEmailField, userNameField, userPasswordField;
	private ComboBox<String> roleCombo;
	private Button registerButton;
	private Label messageLabel;
	
	
	public ViewRegister() {
		this.bp = new BorderPane();
        this.registerScene = new Scene(bp, 800, 600);
        
        vb = new VBox(10);
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(5);
        gp.setVgap(5);
        
        Label title = new Label("Register");
        
        Label userEmailLabel = new Label("Email: ");
        userEmailField = new TextField();  
        Label userNameLabel = new Label("Username: ");
        userNameField = new TextField();
        Label userPasswordLabel = new Label("Password: ");
        userPasswordField = new TextField();
        Label userRoleLabel = new Label("Role: ");
        roleCombo = new ComboBox<>();
        roleCombo.getItems().addAll("Event Organzier", "Vendor", "Guest");
 
        registerButton = new Button("Register");
        messageLabel = new Label();
        
        gp.add(userEmailLabel, 0, 0);
        gp.add(userEmailField, 1, 0);
        gp.add(userNameLabel, 0, 1);
        gp.add(userNameField, 1, 1);
        gp.add(userPasswordLabel, 0, 2);
        gp.add(userPasswordField, 1, 2);
        gp.add(userRoleLabel, 0, 3);
        gp.add(roleCombo, 1, 3);
       
        vb.getChildren().addAll(title, gp, registerButton, messageLabel);
        vb.setAlignment(Pos.CENTER);
        
        bp.setCenter(vb);
	}
	
	public Scene getScene() {
        return registerScene;
    }
	
	public void addMenuBar(MenuBar menuBar) {
        bp.setTop(menuBar);
    }
	
	public String getUserByEmail() {
    	return userEmailField.getText();
    }
    
	public String getUserByUsername() {
    	return userNameField.getText();
    }
	
	public String getUserByPassword() {
    	return userPasswordField.getText();
    }
	
	public String getUserByRole() {
    	return roleCombo.getValue();
    }
	
	public void addMessage(String message) {
		messageLabel.setText(message);
	}
	
	public void setRegisterButtonAction(EventHandler<ActionEvent> handler) {
    	registerButton.setOnAction(handler);
    }
}
