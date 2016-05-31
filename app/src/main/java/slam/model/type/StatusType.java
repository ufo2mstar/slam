package slam.model.type;

public enum StatusType {
	PENDING("PENDING"),
	COMPLETE("COMPLETE");

//	todo: i was just playing around.. some advice on enum usage from your experience please
	private final String statusText;

	StatusType(String status) {
		this.statusText = status;
	}

	public String getStatusType() {
		return this.statusText;
	}
}
