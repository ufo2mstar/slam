create table Events (
	id CHAR(36),
	correlation_id CHAR(36),
	event_type VARCHAR(36),
	estimated_time_of_arrival TIMESTAMP,
	status VARCHAR(20),
	parent_id CHAR(36),
	created_time TIMESTAMP,
	modified_time TIMESTAMP
);