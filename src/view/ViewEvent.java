package view;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
=======
import javafx.scene.layout.VBox;
import model.Event;
import model.User;

public class ViewEvent {

	private BorderPane bp;
	private VBox vb;
	private Scene eventScene;
	private TableView<Event> eventListView;
	private ObservableList<Event> eventData;
	private TableColumn<Event, String> eventIdColumn, eventNameColumn, eventDateColumn, eventLocationColumn;
	
	public ViewEvent() {
		this.bp = new BorderPane();
        this.eventScene = new Scene(bp, 800, 600);
        
        vb = new VBox(10);
        Label title = new Label("Event Page");
        
        eventListView = new TableView<>();
        eventListView.setMaxHeight(300);
        eventListView.setMaxWidth(400);
        
        eventIdColumn = new TableColumn<>("Event ID");
        eventIdColumn.setMinWidth(100);
        eventNameColumn = new TableColumn<>("Event Name");
        eventNameColumn.setMinWidth(100);
        eventDateColumn = new TableColumn<>("Event Date");
        eventDateColumn.setMinWidth(100);
        eventLocationColumn = new TableColumn<>("Event Location");
        eventLocationColumn.setMinWidth(100);
        
        eventIdColumn.setCellValueFactory(new PropertyValueFactory<>("eventId"));
        eventNameColumn.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        eventDateColumn.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
        eventLocationColumn.setCellValueFactory(new PropertyValueFactory<>("eventLocation"));
        
        eventListView.getColumns().addAll(eventIdColumn, eventNameColumn, eventDateColumn, eventLocationColumn);
        
        vb.getChildren().addAll(title, eventListView);
        vb.setAlignment(Pos.CENTER);
        
        bp.setCenter(vb);
	}
	
	public Scene getScene() {
        main
        return eventScene;
    }
	
	public void addMenuBar(MenuBar menuBar) {
        bp.setTop(menuBar);
    }
}
