package controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import main.Main;
import model.User;
import utils.Connect;
import view.ViewEvent;
import view.ViewLogin;
import view.ViewRegister;

public class UserController {

	private ViewRegister view;
	private ViewLogin loginView;
	private ViewEvent eventView;
    private Connect connect;
    
	public UserController(ViewRegister view, ViewLogin loginView, ViewEvent eventView) {
		this.view = view;
		this.loginView = loginView;
		this.eventView = eventView;
		this.connect = connect.getInstance();
		initialize();
	}
	
	private void initialize() {
		view.setRegisterButtonAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent event) {
	            String userEmail = view.getUserByEmail();
	            String userName = view.getUserByUsername();
	            String userPassword = view.getUserByPassword();
	            String userRole = view.getUserByRole();
	            
	//            checkRegisterInput ditambah userRole untuk validasi role
	            String isChecked = checkRegisterInput(userEmail, userName, userPassword, userRole);
	            view.addMessage(isChecked);
	            if(isChecked.equals("Register Succeeded.")) {
	            	boolean isAdded = register(userEmail, userName, userPassword, userRole);
	                if (isAdded) {
	                	Main.redirect(loginView.getScene());
	                } else {
	                	
	                }
	            }
	
	        }
		});
		
		loginView.setLoginButtonAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String userEmail = loginView.getUserByEmail();
	            String userPassword = loginView.getUserByPassword();
	            
	            String isChecked = checkLoginInput(userEmail, userPassword);
	            loginView.addMessage(isChecked);
	            if(isChecked.equals("Login Succeeded.")) {
	            	Main.redirect(eventView.getScene());
	            }
			}
		});
	}
	
	private String checkRegisterInput(String email, String name, String password, String role) {
		if (email == null || email.isBlank()) {
	        return "Email cannot be empty.";
	    }
		if (!isUnique(email, password)) {
	        return "Email or Username already exists. Please use a different one.";
	    }
	    if (name == null || name.isBlank()) {
	        return "Username cannot be empty.";
	    }
	    if (!isUnique(name, password)) {
	        return "Email or Username already exists. Please use a different one.";
	    }
	    if (password == null || password.isBlank()) {
	        return "Password cannot be empty.";
	    }
	    if (password.length() < 5) {
	        return "Password must contain at least 5 characters.";
	    }if (role == null) {
	        return "Please select a role";
	    }
	    return "Register Succeeded.";
	}
	
	//menambahkan validasi input login
	private String checkLoginInput(String email, String password) {
		if (email == null || email.isBlank()) {
	        return "Email cannot be empty.";
	    }
	    if (password == null || password.isBlank()) {
	        return "Password cannot be empty.";
	    }
	    if (password.length() < 5) {
	        return "Password must contain at least 5 characters.";
	    }
	    boolean isValid = login(email, password);
	    if(isValid) {
	    	Main.redirect(eventView.getScene());
	    }else {
	    	loginView.addMessage("Invalid email or password. Please try again.");
	    }
	    return "Login Succeeded.";
	}
	
	private ArrayList<User> getUserList(){
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
	
	private boolean register(String email, String name, String password, String role) {
		String userId = "UID" + (getUserList().size() + 1);
		String query = String.format("INSERT INTO users (user_id, user_email, user_name, user_password, user_role) "
		   		+ "VALUES ('%s', '%s', '%s', '%s', '%s')", userId, email, name, password, role);
		
		try {
			if(query != null) {
				if(role.equals("Event Organizer")) {
					
					String queryEventOrganizer = String.format("INSERT INTO eventorganizer (organizer_id)"
					   		+ "VALUES ('%s')", userId);
					connect.executeUpdate(queryEventOrganizer);
					
				} else if(role.equals("Guest")) {
					
					String queryGuest = String.format("INSERT INTO guests (guest_id)"
					   		+ "VALUES ('%s')", userId);
					connect.executeUpdate(queryGuest);
					
				} else if(role.equals("Vendor")) {
					
					String queryVendor = String.format("INSERT INTO vendors (vendor_id)"
					   		+ "VALUES ('%s')", userId);
					connect.executeUpdate(queryVendor);
					
				}
				
				int rowsAffected = connect.executeUpdate(query);
				
				return rowsAffected > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	   
		return false;
   }
	
	private boolean isUnique(String email, String password) {
	    String query = String.format(
	        "SELECT COUNT(*) AS count FROM users WHERE user_email = '%s' OR user_name = '%s'",
	        email, password
	    );

	    try (ResultSet resultSet = connect.execute(query)) {
	        if (resultSet.next()) {
	            int count = resultSet.getInt("count");
	            return count == 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	private boolean login(String email, String password) {
	    // SQL query to validate email and password
	    String query = String.format(
	        "SELECT COUNT(*) AS count FROM users WHERE user_email = '%s' AND user_password = '%s'", 
	        email, password
	    );

	    try (ResultSet resultSet = connect.execute(query)) {
	        if (resultSet.next()) {
	            int count = resultSet.getInt("count");
	            return count > 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}


    
}
