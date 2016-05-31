package slam.model;

import java.util.Date;
import java.util.UUID;

import slam.model.type.StatusType;

public class Event {

	private UUID id;

	private UUID correlationId;

	private String eventType;

	private Date estimatedTimeOfArrival;

	private StatusType status;

	private UUID parentId;

	private Date createdTime;

	private Date modifiedTime;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(UUID correlationId) {
		this.correlationId = correlationId;
	}

	public Date getEstimatedTimeOfArrival() {
		return estimatedTimeOfArrival;
	}

	public void setEstimatedTimeOfArrival(Date estimatedTimeOfArrival) {
		this.estimatedTimeOfArrival = estimatedTimeOfArrival;
	}

	public UUID getParentId() {
		return parentId;
	}

	public void setParentId(UUID parentId) {
		this.parentId = parentId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", correlationId=" + correlationId + ", eventType=" + eventType
				+ ", estimatedTimeOfArrival=" + estimatedTimeOfArrival + ", status=" + status + ", parentId=" + parentId
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
	}

}
