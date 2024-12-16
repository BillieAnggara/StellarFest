package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.User;

public class ViewUser {
	
	private BorderPane bp;
	private Scene viewUserScene;
	private TableView<User> userListView;
	private ObservableList<User> userData;
	
	public ViewUser() {
		
		this.bp = new BorderPane();
		this.viewUserScene = new Scene(bp, 800, 600);
        
        userListView = new TableView<>();
        userListView.setMaxHeight(300);
        userListView.setMaxWidth(400);
        
        TableColumn<User, String> userIdColumn = new TableColumn<>("ID");
        userIdColumn.setMinWidth(100);
        TableColumn<User, String> userEmailColumn = new TableColumn<>("Email");
        userEmailColumn.setMinWidth(100);
        TableColumn<User, String> userNameColumn = new TableColumn<>("Username");
        userNameColumn.setMinWidth(100);
        TableColumn<User, String> userRoleColumn = new TableColumn<>("Role");
        userRoleColumn.setMinWidth(100);
        
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userEmailColumn.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userRoleColumn.setCellValueFactory(new PropertyValueFactory<>("userRole"));
        
        userListView.getColumns().addAll(userIdColumn, userEmailColumn, userNameColumn, userRoleColumn);
        
        bp.setCenter(userListView);
        
        userData = FXCollections.observableArrayList();
        userListView.setItems(userData);
	}
	
	public Scene getScene() {
        return viewUserScene;
    }

    public void setUserList(ObservableList<User> users) {
        userData.setAll(users); 
    }
    
    public void addUserList(User userList) {
    	userData.add(userList);
    }
    

}
