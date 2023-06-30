package bean;

public class Patient {
	private int patient_id;
	private String name;
	private String email;
	private String ic;
	private String phone;
	private String address;
	
	
	
	/**
	 * @param patient_id
	 * @param name
	 * @param email
	 * @param ic
	 * @param phone
	 * @param address
	 */
	public Patient(int patient_id, String name, String email, String ic, String phone, String address) {
		super();
		this.patient_id = patient_id;
		this.name = name;
		this.email = email;
		this.ic = ic;
		this.phone = phone;
		this.address = address;
	}
	
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}


	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIc() {
		return ic;
	}
	public void setIc(String ic) {
		this.ic = ic;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
