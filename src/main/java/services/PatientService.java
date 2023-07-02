package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import bean.Appointment;
import bean.Doctor;
import bean.Patient;

public class PatientService {
	private String jdbcURL = "jdbc:mysql://localhost/doctorange";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private String SELECT_PATIENT_ID_by_EMAIL_IC = "SELECT * FROM patient WHERE email=? AND ic=?;";
//	private String SELECT_ALL_CLINIC_NAME = "SELECT * FROM clinic WHERE name LIKE ?;";
//	private String INSERT_CLINIC_NAME = "INSERT INTO clinic (name) VALUES (?);";
//	private String SELECT_LAST_INSERT_ID = "SELECT last_insert_id() FROM clinic;";
	private String SELECT_PATIENT_ID = "SELECT * FROM patient WHERE ic=?;";
	private String INSERT_PATIENT_SQL = "INSERT INTO patient(name, email, ic, phone, address) VALUE(?,?,?,?,?);";
	private String SELECT_ALL_PATIENT = "SELECT * FROM patient;";
	private String SELECT_PATIENTS_ID = "SELECT * FROM patient WHERE patient_id=?;";
	private String UPDATE_PATIENT_ID = "UPDATE patient set name=?, email=?, ic=?, phone=?, address=? WHERE patient_id=?;";
	private String DELETE_PATIENT_SQL = "DELETE from patient where patient_id = ?;";

	public PatientService() {
//		insertClinicReturnId("name");
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	public boolean insertPatient(Patient patient) throws SQLException {
		boolean status = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT_SQL)) {
			preparedStatement.setString(1, patient.getName());
			preparedStatement.setString(2, patient.getEmail());
			preparedStatement.setString(3, patient.getIc());
			preparedStatement.setString(4, patient.getPhone());
			preparedStatement.setString(5, patient.getAddress());

			preparedStatement.executeUpdate();

			status = true;

		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}

		return status;
	}
	
	public List<Patient> selectAllPatient() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Patient> patient = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENT);) {
//            System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int patient_id = rs.getInt("patient_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String ic = rs.getString("ic");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				
//				if(doctor_id == session_doc_id) {
				
				patient.add(new Patient(patient_id, name, email, ic, phone, address));
//				}
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return patient;
	}
	
	public Patient getOnePatient(int id) {
		Patient patient = null;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENTS_ID)) {
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				int patient_id = rs.getInt("patient_id");;
				String name = rs.getString("name");
				String email = rs.getString("email");
				String ic = rs.getString("ic");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				
				System.out.println("patient_id : " + patient_id);
				
				patient = new Patient(patient_id, name, email, ic, phone, address);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return patient;
	}
	
	public boolean updatePatient(Patient patient) throws SQLException{
		boolean status = false;
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PATIENT_ID)) {
			preparedStatement.setString(1, patient.getName());
			preparedStatement.setString(2, patient.getEmail());
			preparedStatement.setString(3, patient.getIc());
			preparedStatement.setString(4, patient.getPhone());
			preparedStatement.setString(5, patient.getAddress());
			preparedStatement.setInt(6, patient.getPatient_id());
			
			System.out.println(patient.getEmail());
			preparedStatement.executeUpdate();
			status = true;
		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}
		
		return status;
	}
	
	public boolean deletePatient(int patient_id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();) {
        	PreparedStatement statement = connection.prepareStatement(DELETE_PATIENT_SQL);
            statement.setInt(1, patient_id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
	
	
	
	public int getPatientIdbyEmailIc(String email, String ic) throws SQLException{
		int id = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_ID_by_EMAIL_IC)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, ic);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				id = rs.getInt("patient_id");
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return id;
	}
	
	public Patient getInformation(Patient patient) {
		Patient pat = null; // default init

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_ID)) {
			preparedStatement.setInt(1, patient.getPatient_id());
			System.out.println("patient id : " + patient.getPatient_id());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int patient_id = rs.getInt("patient_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String ic = rs.getString("ic");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				
				pat = new Patient(patient_id, name, email, ic, phone, address);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return pat;
	}
	
}
