package bean;

public class Clinic {
	private int id;
	private String clinic_name;
	private String address;
	
	/**
	 * @param id
	 * @param name
	 * @param address
	 */
	public Clinic(String name, String address) {
		this.clinic_name = name;
		this.address = address;
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param address
	 */
	public Clinic(int id, String name, String address) {
		this.id = id;
		this.clinic_name = name;
		this.address = address;
	}
	
	/**
	 * @param no aparam
	 * default constructor
	 */
	public Clinic() {

	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return clinic_name;
	}
	public void setName(String name) {
		this.clinic_name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
