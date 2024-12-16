package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;
import utils.Connect;
import view.ViewUser;

public class AdminController {

	private ViewUser userView;
	private Connect connect;

    public AdminController(ViewUser userView) {
        this.userView = userView;
        this.connect = Connect.getInstance();
        loadUserList();
    }
    
    private void loadUserList() {
        ObservableList<User> userData = FXCollections.observableArrayList(getAllUsers());
        userView.setUserList(userData);
    }
    
    private ArrayList<User> getAllUsers(){
 	   ArrayList<User> userArray = new ArrayList<>();
 	   
 	   String query = "SELECT * FROM users";
 	   
 	   try(ResultSet resultSet = connect.execute(query)){
 		   while(resultSet.next()) {
 			   String userId = resultSet.getString("user_id");
 			   String userEmail = resultSet.getString("user_email");
 			   String userName = resultSet.getString("user_name");
 			   String userPassword = resultSet.getString("user_password");
 			   String userRole = resultSet.getString("user_role");
 			   
 			   User user = new User(userId, userEmail, userName, userPassword, userRole);
 			   
 			   userArray.add(user);
 		   }
 	   } catch (Exception e) {
 		// TODO: handle exception
 	   }
 	   
 	   return userArray;
    }
    
    private boolean deleteUser(String userID) {
    	String userId = userID;
 	   	String query = "SELECT * FROM users WHERE user_id = " + userId;
 	   
 	   	int rowsAffected = connect.executeUpdate(query);
 	   
 	   	return rowsAffected > 0;
    }	
}
