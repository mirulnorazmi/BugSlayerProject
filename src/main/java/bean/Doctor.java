package bean;

public class Doctor {
	private int id;
	private String name;
	private String email;
	private String password;
	private String specialization;
	private String phone;
	private int clinic_id;
	
//	Create doctor constructor
	public Doctor(String name, String email, String password, String specialization, String phone, int clinic_id) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.specialization = specialization;
		this.phone = phone;
		this.clinic_id = clinic_id;
	}
//	Get Info constr
	public Doctor(int id, String name, String email, int clinic_id) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.clinic_id = clinic_id;
	}
	
	public Doctor(int id, String name, String email, String password, String specialization, String phone,
			int clinic_id) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.specialization = specialization;
		this.phone = phone;
		this.clinic_id = clinic_id;
	}
//	default constructor
	public Doctor() {
//		Auto-generated
	}
	
	public Doctor(int id, String name, String email, String specialization, String phone, int clinic_id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.email = email;
		this.specialization = specialization;
		this.phone = phone;
		this.clinic_id = clinic_id;
	}
	public Doctor(int id, String name, String email, String specialization, String phone) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.email = email;
		this.specialization = specialization;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getClinic_id() {
		return clinic_id;
	}
	public void setClinic_id(int clinic_id) {
		this.clinic_id = clinic_id;
	}
	
	
	
}
