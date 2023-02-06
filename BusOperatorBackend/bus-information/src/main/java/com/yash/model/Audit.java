package com.yash.model;

import java.util.Date;

public class Audit {
	private int AuditId;
	private int ScheduleId;
	private Date date;
	private int OccupiedSeats;

	public Audit(int auditId, int scheduleId, Date date, int occupiedSeats) {
		super();
		AuditId = auditId;
		ScheduleId = scheduleId;
		this.date = date;
		OccupiedSeats = occupiedSeats;
	}

	public Audit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAuditId() {
		return AuditId;
	}

	public void setAuditId(int auditId) {
		AuditId = auditId;
	}

	public int getScheduleId() {
		return ScheduleId;
	}

	public void setScheduleId(int scheduleId) {
		ScheduleId = scheduleId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOccupiedSeats() {
		return OccupiedSeats;
	}

	public void setOccupiedSeats(int occupiedSeats) {
		OccupiedSeats = occupiedSeats;
	}

	@Override
	public String toString() {
		return "Audit [AuditId=" + AuditId + ", ScheduleId=" + ScheduleId + ", date=" + date + ", OccupiedSeats="
				+ OccupiedSeats + "]";
	}

}
