package controller;

import java.sql.ResultSet;
import utils.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.ViewInvitation;
import model.Invitation;
import java.util.ArrayList;

import javafx.collections.FXCollections;

public class VendorController {
	private ViewInvitation invitationView;
	private Connect connect;
	
	public VendorController(ViewInvitation invitationView) {
		this.invitationView = invitationView;
        this.connect = Connect.getInstance();
        loadInvitationList();
	}
	
	private void loadInvitationList() {
		String userId = "";
		ObservableList<Invitation> invitationsDetails = FXCollections.observableArrayList(getAllInvitation(userId));
		invitationView.setInvitationList(invitationsDetails);
	}
	
	private ArrayList<Invitation> getAllInvitation(String vendorId){
		ArrayList<Invitation> invitationArray = new ArrayList<Invitation>();
		String query = String.format("SELECT * FROM invitations where user_id LIKE '%s'", vendorId);
		
		try (ResultSet resultSet = connect.execute(query)){
			while(resultSet.next()) {
				String invitationId = resultSet.getString("invitation_id");
				String eventId = resultSet.getString("event_id");
				String userId = resultSet.getString("user_id");
				String invitationStatus = resultSet.getString("invitation_status");
				String invitationRole = resultSet.getString("invitation_role");
				
				Invitation invitation = new Invitation(
						invitationId, eventId, userId, invitationStatus, invitationRole
				);
				
				invitationArray.add(invitation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invitationArray;
	}
	
	public boolean acceptInvitation() {
		return false;
	}
	
	public void viewAcceptedEvents() {
		
	}
	
	public void manageVendor() {
		
	}
	
	public boolean checkManageVendorInput() {
		return false;
	}
	
}
