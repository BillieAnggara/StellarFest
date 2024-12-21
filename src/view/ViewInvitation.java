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
import model.Invitation;

public class ViewInvitation {
	
	private BorderPane bp;
	private Scene viewInvitationScene;
	private TableView<Invitation> invitationListView;
	private ObservableList<Invitation> invitationDetails;
	
	@SuppressWarnings("unchecked")
	public ViewInvitation() {
		
		this.bp = new BorderPane();
		this.viewInvitationScene = new Scene(bp, 800, 600);
        
		invitationListView = new TableView<>();
		invitationListView.setMaxHeight(300);
		invitationListView.setMaxWidth(400);
        
        TableColumn<Invitation, String> invitationIdColumn = new TableColumn<>("ID");
        invitationIdColumn.setMinWidth(100);
        TableColumn<Invitation, String> eventIdColumn = new TableColumn<>("Event ID");
        eventIdColumn.setMinWidth(100);
        TableColumn<Invitation, String> invitationStatusColumn = new TableColumn<>("Status");
        invitationStatusColumn.setMinWidth(100);
        TableColumn<Invitation, String> invitationRoleColumn = new TableColumn<>("Role");
        invitationRoleColumn.setMinWidth(100);
        
        invitationIdColumn.setCellValueFactory(new PropertyValueFactory<>("invitationId"));
        eventIdColumn.setCellValueFactory(new PropertyValueFactory<>("eventId"));
        invitationStatusColumn.setCellValueFactory(new PropertyValueFactory<>("invitationStatus"));
        invitationRoleColumn.setCellValueFactory(new PropertyValueFactory<>("invitationRole"));

        invitationListView.getColumns().addAll(invitationIdColumn, eventIdColumn, invitationStatusColumn, invitationRoleColumn);

        
        bp.setCenter(invitationListView);
        
        invitationDetails = FXCollections.observableArrayList();
        invitationListView.setItems(invitationDetails);
	}
	
	public Scene getScene() {
        return viewInvitationScene;
    }

    public void setInvitationList(ObservableList<Invitation> invitations) {
    	invitationDetails.setAll(invitations); 
    }
    
}
