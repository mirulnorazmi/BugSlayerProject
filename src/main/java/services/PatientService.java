package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
