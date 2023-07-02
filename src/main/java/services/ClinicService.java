package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
import bean.Appointment;
>>>>>>> 4518a6bd67523d26a46b0786d8e6d655a8d3ade0
import bean.Clinic;
import bean.Doctor;

public class ClinicService {

	private String jdbcURL = "jdbc:mysql://localhost/doctorange";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private String SELECT_ALL_CLINIC = "SELECT * FROM clinic;";
	private String SELECT_ALL_CLINIC_NAME = "SELECT * FROM clinic WHERE name LIKE ?;";
	private String INSERT_CLINIC_NAME = "INSERT INTO clinic (name) VALUES (?);";
	private String SELECT_LAST_INSERT_ID = "SELECT last_insert_id() FROM clinic;";
	private String SELECT_CLINIC_ID = "SELECT * FROM clinic WHERE clinic_id=?";
	private String UPDATE_CLINIC_ID = "UPDATE clinic SET name=?, address=? WHERE clinic_id=?;";

	public ClinicService() {
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

	public List<Clinic> selectAllClinics() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Clinic> clinics = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLINIC);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("clinic_id");
				String name = rs.getString("name");
				String address = rs.getString("address");

				clinics.add(new Clinic(id, name, address));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return clinics;
	}

	public int insertClinicReturnId(String clinicName) throws SQLException {
//      System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		int id = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLINIC_NAME)) {
			preparedStatement.setString(1, clinicName);

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			PreparedStatement pStatement = connection.prepareStatement(SELECT_LAST_INSERT_ID);
			ResultSet rs = pStatement.executeQuery();
			rs.next();
			id = Integer.valueOf(rs.getString(1));

		} catch (SQLException e) {
			printSQLException(e);
		}
		return id;
	}

	public int getClinicId(String clinicName) throws SQLException {
		int clinicId = 0;
		boolean status;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLINIC_NAME)) {
			preparedStatement.setString(1, clinicName);

			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			int id = 0;
			System.out.println("status : " + status);
			if (status == true) {
				clinicId = rs.getInt("clinic_id");
				System.out.println("Clinic_id select id: " + clinicId);
			} else {
				clinicId = insertClinicReturnId(clinicName);
				System.out.println("Clinic_id insert id: " + clinicId);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return clinicId;
	}

	public Clinic getFullInformation(Clinic clinic) {
		Clinic clin = null; // default init

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLINIC_ID)) {
			preparedStatement.setInt(1, clinic.getId());
			System.out.println("clinic id : " + clinic.getId());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int clinic_id = rs.getInt("clinic_id");
				String name = rs.getString("name");
				String address = rs.getString("address");

				clin = new Clinic(clinic_id, name, address);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return clin;
	}
	
	public boolean updateClinic(Clinic clinic) throws SQLException{
		boolean status = false;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLINIC_ID)) {
			preparedStatement.setString(1, clinic.getName());
			preparedStatement.setString(2, clinic.getAddress());
			preparedStatement.setInt(3, clinic.getId());
			preparedStatement.executeUpdate();
			status = true;
		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}
		
		return status;
	}

}
