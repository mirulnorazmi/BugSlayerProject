package bean;

import java.sql.Date;

import java.sql.Time;

public class Appointment {
	
	private int appointment_id;
	private int doctor_id;
	private int patient_id;
	private String patient_name;
	private Date date;
	private Time time;
	private String duration;
	private String description;
	private String status;
	private int bill_id;
	private String bill_status;
	
	
	
	/**
	 * @param appointment_id
	 * @param doctor_id
	 * @param patient_id
	 * @param date
	 * @param time
	 * @param duration
	 * @param description
	 * @param status
	 * @param bill_id
	 */
	public Appointment(int appointment_id, int doctor_id, int patient_id, Date date, Time time, String duration,
			String description, String status, int bill_id) {
		
		this.appointment_id = appointment_id;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.description = description;
		this.status = status;
		this.bill_id = bill_id;
	}
	
	public Appointment(int appointment_id, int doctor_id, String patient_name, Date date, Time time, String duration,
			String description, String status, int bill_id, String bill_status) {
		
		this.appointment_id = appointment_id;
		this.doctor_id = doctor_id;
		this.patient_name = patient_name;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.description = description;
		this.status = status;
		this.bill_id = bill_id;
		this.bill_status = bill_status;
	}
	
	public Appointment(int doctor_id, int patient_id, Date date, Time time, String duration) {
		
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.date = date;
		this.time = time;
		this.duration = duration;
	}
	
	public Appointment() {
		
	}
	
	
	public Appointment(int appointment_id, Date date, Time time, String duration, String status,
			String description) {
		this.appointment_id = appointment_id;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.description = description;
		this.status = status;
	}

	public Appointment(int doctor_id, int patient_id, Date date, Time time, String duration, int bill_id) {
		// TODO Auto-generated constructor stub
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.bill_id = bill_id;
		
	}

	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}
	public String getBill_status() {
		return bill_status;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

}
