package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import utils.Logged;

public class ViewEvent {

    private BorderPane bp;
    private Scene eventScene;
    private Label title;

    public ViewEvent() {
        this.bp = new BorderPane();
        this.eventScene = new Scene(bp, 800, 600);

        this.title = new Label(); // Initialize the label but don't set text yet
        title.setAlignment(Pos.CENTER);
        bp.setCenter(title);

        updateTitle(); // Set the initial label text
    }

    public void updateTitle() {
        String name = Logged.getLoggedUser() == null ? "guest" : Logged.getLoggedUser().getUsername();
        title.setText("Event Page, Logged as " + name);
    }

    public Scene getScene() {
        return eventScene;
    }
}
