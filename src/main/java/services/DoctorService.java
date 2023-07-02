package services;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Clinic;
import bean.Doctor;
import helper.EncryptDecryptPass;

public class DoctorService {

	private EncryptDecryptPass encryptDecryptPass;

	public DoctorService() {
		encryptDecryptPass = new EncryptDecryptPass();
	}

	private String jdbcURL = "jdbc:mysql://localhost/doctorange";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
//	private String SELECT_ALL_DOCTOR = "SELECT * FROM doctor;";
	private String SELECT_DOCTOR_EMAIL = "SELECT * FROM doctor WHERE email=?;";
	private String INSERT_DOCTOR_SQL = "insert into doctor (name, email, password, specialization, phone, clinic_id) VALUES (?, ?, ?, ?, ?, ?)";
	private String UPDATE_DOCTOR_ID = "UPDATE doctor SET name=?, email=?, specialization=?, phone=? WHERE doctor_id=?";
	
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

	public void insertDoctor(Doctor doctor) throws SQLException {
//      System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOCTOR_SQL)) {
			preparedStatement.setString(1, doctor.getName());
			preparedStatement.setString(2, doctor.getEmail());
			preparedStatement.setString(3, doctor.getPassword());
			preparedStatement.setString(4, doctor.getSpecialization());
			preparedStatement.setString(5, doctor.getPhone());
			preparedStatement.setInt(6, doctor.getClinic_id());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public boolean checkEmail(Doctor doctor) {
		boolean status = true; // default init

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCTOR_EMAIL)) {
			preparedStatement.setString(1, doctor.getEmail());
			System.out.println("email : " + doctor.getEmail());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				if (rs.getString("email").equals(doctor.getEmail())) {
					System.out.println("email db: " + rs.getString("email"));
					status = false;
					break;
				}
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return status;
	}

	public Doctor getInformation(Doctor doctor) {
		Doctor doc = null; // default init

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCTOR_EMAIL)) {
			preparedStatement.setString(1, doctor.getEmail());
			System.out.println("email : " + doctor.getEmail());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int doctor_id = rs.getInt("doctor_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int clinic_id = rs.getInt("clinic_id");
				if (name.contains(" ")) {
					name = name.substring(0, name.indexOf(" ")).toLowerCase();
					System.out.println("name short ; " + name);
				}

				doc = new Doctor(doctor_id, name, email, clinic_id);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return doc;
	}

	public Doctor getFullInformation(Doctor doctor) {
		Doctor doc = null; // default init

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCTOR_EMAIL)) {
			preparedStatement.setString(1, doctor.getEmail());
			System.out.println("email : " + doctor.getEmail());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int doctor_id = rs.getInt("doctor_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String specialization = rs.getString("specialization");
				String phone = rs.getString("phone");
				int clinic_id = rs.getInt("clinic_id");

				doc = new Doctor(doctor_id, name, email, specialization, phone, clinic_id);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return doc;
	}
	
	public boolean updateDoctor(Doctor doctor) throws SQLException{
		boolean status = false;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTOR_ID)) {
			preparedStatement.setString(1, doctor.getName());
			preparedStatement.setString(2, doctor.getEmail());
			preparedStatement.setString(3, doctor.getSpecialization());
			preparedStatement.setString(4, doctor.getPhone());
			preparedStatement.setInt(5, doctor.getId());
			preparedStatement.executeUpdate();
			status = true;
		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}
		
		return status;
	}

	public boolean loginDoctor(Doctor doctor) throws SQLException {
		boolean status = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCTOR_EMAIL)) {
			preparedStatement.setString(1, doctor.getEmail());

			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("password : " + doctor.getPassword());
			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				System.out.println("password db: " + password);
				System.out.println(encryptDecryptPass.CheckPassword(doctor.getPassword(), password));
				if (email.equals(doctor.getEmail())
						&& encryptDecryptPass.CheckPassword(doctor.getPassword(), password)) {
					status = true;
				} else {
					status = false;
				}
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return status;
	}
}
