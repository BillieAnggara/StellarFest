package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ViewEvent {

	private BorderPane bp;
	private Scene eventScene;
	
	public ViewEvent() {
		this.bp = new BorderPane();
        this.eventScene = new Scene(bp, 800, 600);
        
        Label title = new Label("Event Page");
        
        bp.setCenter(title);
	}
	
	public Scene getScene() {
        return eventScene;
    }
}
