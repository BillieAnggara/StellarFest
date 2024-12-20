package view;

import java.time.LocalDate;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ViewCreateEvent {
	
	private VBox vb;
	private BorderPane bp;
	private Scene createEventScene;
	private TextField eventNameField, eventLocationField;
	private TextArea eventDescArea;
	private DatePicker eventDateInput;
	private Button createEventButton;
	private Label messageLabel;

	public ViewCreateEvent() {
		this.bp = new BorderPane();
        this.createEventScene = new Scene(bp, 800, 600);
        
        vb = new VBox(10);
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(5);
        gp.setVgap(5);
        
        Label title = new Label("Create Event");
        
        Label eventNameLabel = new Label("Event Name: ");
        eventNameField = new TextField();  
        Label eventDateLabel = new Label("Event Date: ");
        eventDateInput = new DatePicker();
        Label eventLocationLabel = new Label("Event Location: ");
        eventLocationField = new TextField();
        Label eventDescLabel = new Label("Event Description: ");
        eventDescArea = new TextArea();
        
 
        createEventButton = new Button("Create Event");
        messageLabel = new Label();
        
        gp.add(eventNameLabel, 0, 0);
        gp.add(eventNameField, 1, 0);
        gp.add(eventDateLabel, 0, 1);
        gp.add(eventDateInput, 1, 1);
        gp.add(eventLocationLabel, 0, 2);
        gp.add(eventLocationField, 1, 2);
        gp.add(eventDescLabel, 0, 3);
        gp.add(eventDescArea, 1, 3);
       
        vb.getChildren().addAll(title, gp, createEventButton, messageLabel);
        vb.setAlignment(Pos.CENTER);
        
        bp.setCenter(vb);
	}
	
	public Scene getScene() {
        return createEventScene;
    }
	
	public void addMenuBar(MenuBar menuBar) {
        bp.setTop(menuBar);
    }
	
	public String getEventNameInput() {
    	return eventNameField.getText();
    }
    
	public LocalDate getEventDateInput() {
    	return eventDateInput.getValue();
    }
	
	public String getEventLocationInput() {
    	return eventLocationField.getText();
    }
	
	public String getEventDescInput() {
    	return eventDescArea.getText();
    }
	
	public void addMessage(String message) {
		messageLabel.setText(message);
	}
	
	public void setCreateEventButtonAction(EventHandler<ActionEvent> handler) {
    	createEventButton.setOnAction(handler);
    }
}
