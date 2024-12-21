package model;

public class Invitation {
	private String invitationId;
	private String eventId;
	private String userId;
	private String invitationStatus;
	private String invitationRole;
	
	public Invitation(String invitationId, String eventId, String userId, String invitationStatus,
			String invitationRole) {
		super();
		this.invitationId = invitationId;
		this.eventId = eventId;
		this.userId = userId;
		this.invitationStatus = invitationStatus;
		this.invitationRole = invitationRole;
	}

	public String getInvitationId() {
		return invitationId;
	}

	public String getEventId() {
		return eventId;
	}

	public String getUserId() {
		return userId;
	}

	public String getInvitationStatus() {
		return invitationStatus;
	}

	public String getInvitationRole() {
		return invitationRole;
	}
	
	
}
