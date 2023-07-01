package bean;

import java.sql.*;

public class Bill {
	private int bill_id;
	private Date date;
	private String status;
	private float amount;
	
	
	
	/**
	 * @param bill_id
	 * @param date
	 * @param status
	 * @param amount
	 */
	public Bill(int bill_id, Date date, String status, float amount) {
		this.bill_id = bill_id;
		this.date = date;
		this.status = status;
		this.amount = amount;
	}
	
	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
