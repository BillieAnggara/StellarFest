package controller;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.Main;
import model.Event;
import model.User;
import utils.Connect;
import view.ViewCreateEvent;
import view.ViewEvent;
import view.ViewLogin;
import view.ViewRegister;

public class EventController {
	
	private ViewCreateEvent createEventView;
    private Connect connect;
    
	public EventController(ViewCreateEvent createEventView) {
		this.createEventView = createEventView;
		this.connect = connect.getInstance();
		initialize();
	}
	
	private void initialize() {
		createEventView.setCreateEventButtonAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent event) {
	            String eventName = createEventView.getEventNameInput();
	            LocalDate eventDate = createEventView.getEventDateInput();
	            String eventLocation = createEventView.getEventLocationInput();
	            String eventDesc = createEventView.getEventDescInput();
	            

	            String isChecked = checkCreateEventInput(eventName, eventDate, eventLocation, eventDesc);
	            createEventView.addMessage(isChecked);
//	            if(isChecked.equals("Event Created.")) {
//	            	boolean isAdded = register(userEmail, userName, userPassword, userRole);
//	                if (isAdded) {
//	                	Main.redirect(loginView.getScene());
//	                } else {
//	                	
//	                }
//	            }
	
	        }
		});
	}
	
//	private String getOrganizerId(){
//	   String query = "SELECT FROM USERS WHERE user_role";
//		   
//	   try(ResultSet resultSet = connect.execute(query)){
//		   while(resultSet.next()) {
//			   String userId = resultSet.getString("user_id");
//				   
//			 
//				   
//			   userArray.add(user);
//		  }
//	   } catch (Exception e) {
//		// TODO: handle exception
//	   }
//		   
//	   return userArray;
//   }
	
	private String checkCreateEventInput(String name, LocalDate date, String location, String desc) {
		LocalDate futureDate = LocalDate.now().plusDays(1);
		if (name == null || name.isBlank()) {
	        return "Event name cannot be empty";
	    }
	    if (date == null) {
	        return "Event date cannot be empty.";
	    }
	    if (date.isBefore(futureDate)) {
	        return "Invalid date! The selected date must be at least tomorrow.";
	    }
	    if (location == null || location.isBlank()) {
	        return "Event location cannot be empty.";
	    }
	    if (location.length() < 5) {
	        return "Event location must contain at least 5 characters.";
	    }
	    if (desc == null || desc.isBlank()) {
	        return "Event description cannot be empty.";
	    }
	    if (desc.length() > 200) {
	        return "Event description cannot be over 200 characters.";
	    }
	    return "Event Created.";
	}
	
//	private boolean createEvent(String name, LocalDate date, String location, String desc) {
//		String eventId = "UID" + (getEventList().size() + 1);
//		String eventDate = date.toString();
//		User organizer = new User();
//		String query = String.format("INSERT INTO users (event_id, event_name, event_date, event_location, "
//				+ "event_description, organizer_id) "
//		   		+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", eventId, name, eventDate, location, desc, eventDate);
//	}
}
