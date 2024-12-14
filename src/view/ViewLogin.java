package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ViewLogin {

	private VBox vb;
    private BorderPane borderPane;
    private Scene loginScene;
    private Label userEmailLabel, userPasswordLabel;
    private TextField userEmailField, userPasswordField;
    private Button loginButton;
    private Label messageLabel;

    public ViewLogin() {
        this.borderPane = new BorderPane();
        this.loginScene = new Scene(borderPane, 800, 600);

        vb = new VBox(10);
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        Label title = new Label("Login");

        userEmailLabel = new Label("Email: ");
        userEmailField = new TextField();
        userPasswordLabel = new Label("Password: ");
        userPasswordField = new TextField();
        
        loginButton = new Button("Login");

        gridPane.add(userEmailLabel, 0, 0);
        gridPane.add(userEmailField, 1, 0);
        gridPane.add(userPasswordLabel, 0, 1);
        gridPane.add(userPasswordField, 1, 1);
        
        messageLabel = new Label();
        
        vb.getChildren().addAll(title, gridPane, loginButton, messageLabel);
        vb.setAlignment(Pos.CENTER);

        borderPane.setCenter(vb);
        
    }

    public Scene getScene() {
        return loginScene;
    }
    
    public void addMenuBar(MenuBar menuBar) {
    	borderPane.setTop(menuBar);
    }
    
    public String getUserByEmail() {
    	return userEmailField.getText();
    }
    
	public String getUserByPassword() {
    	return userPasswordField.getText();
    }
    
    public void setLoginButtonAction(EventHandler<ActionEvent> handler) {
    	loginButton.setOnAction(handler);
    }

	public void addMessage(String message) {
		messageLabel.setText(message);
	}
}
