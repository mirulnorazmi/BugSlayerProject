package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import bean.Appointment;
import bean.Bill;

public class AppointmentService {

	private String jdbcURL = "jdbc:mysql://localhost/doctorange";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private String SELECT_ALL_APPOINTMENT_PATIENT = "SELECT appointment.appointment_id, appointment.doctor_id, appointment.patient_id, patient.name, appointment.date, appointment.time, appointment.duration, appointment.description, appointment.status, appointment.bill_id, bill.status "
			+ "FROM appointment LEFT OUTER JOIN bill ON appointment.bill_id = bill.bill_id JOIN patient ON appointment.patient_id = patient.patient_id WHERE appointment.doctor_id=?;";
	
	private String SELECT_APPOINTMENT_ID = "SELECT appointment_id, doctor_id, patient.name, appointment.date, time, "
			+ "duration, description, appointment.status, appointment.bill_id, bill.status  FROM appointment JOIN patient ON (appointment.patient_id = patient.patient_id)"
			+ "JOIN bill ON (appointment.bill_id = bill.bill_id) WHERE appointment_id=?;";
	private String INSERT_APPOINTMENT_SQL = "INSERT INTO appointment (doctor_id, patient_id, date, time, duration, bill_id) VALUES (?,?,?,?,?,?);";
	private String UPDATE_APPOINTMENT_ID = "UPDATE appointment set date=?, time=?, duration=?, status=?, description=? WHERE appointment_id=?;";
	private final String DELETE_APPOINTMENT_SQL = "DELETE from appointment where appointment_id = ?;";

	public AppointmentService() {
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

	public boolean insertAppointment(Appointment appointment) throws SQLException {
		boolean status = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT_SQL)) {
			preparedStatement.setInt(1, appointment.getDoctor_id());
			preparedStatement.setInt(2, appointment.getPatient_id());
			preparedStatement.setDate(3, appointment.getDate());
			preparedStatement.setTime(4, appointment.getTime());
			preparedStatement.setString(5, appointment.getDuration());
			preparedStatement.setInt(6, appointment.getBill_id());

			preparedStatement.executeUpdate();

			status = true;

		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}

		return status;
	}

	public List<Appointment> selectAllAppointment(int session_doc_id) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Appointment> appointment = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPOINTMENT_PATIENT);) {
//            System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.setInt(1, session_doc_id);
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int appointment_id = rs.getInt("appointment_id");
				int doctor_id = rs.getInt("doctor_id");
//				int patient_id = rs.getInt("patient_id");
				String patient_name = rs.getString("patient.name");
				Date date = rs.getDate("appointment.date");
				Time time = rs.getTime("time");
				String duration = rs.getString("duration");
				String description = rs.getString("description");
				String status = rs.getString("appointment.status");
				int bill_id = rs.getInt("bill_id");
				String bill_status = rs.getString("bill.status");
				
				System.out.println(doctor_id);
				
//				if(doctor_id == session_doc_id) {
				
				appointment.add(new Appointment(appointment_id, doctor_id, patient_name, date, time, duration,
							description, status, bill_id, bill_status));
//				}
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return appointment;
	}
	
	public Appointment getOneAppointment(int id) {
		Appointment appointment = null;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPOINTMENT_ID)) {
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
//				appointment = new Appointment(bill_id, date, status, amount);
				int appointment_id = rs.getInt("appointment_id");
				int doctor_id = rs.getInt("doctor_id");
//				int patient_id = rs.getInt("patient_id");
				String patient_name = rs.getString("patient.name");
				Date date = rs.getDate("appointment.date");
				Time time = rs.getTime("time");
				String duration = rs.getString("duration");
				String description = rs.getString("description");
				String status = rs.getString("appointment.status");
				int bill_id = rs.getInt("bill_id");
				String bill_status = rs.getString("bill.status");
				System.out.println("appointment_id : " + appointment_id);
				
				appointment = new Appointment(appointment_id, doctor_id, patient_name, date, time, duration,
							description, status, bill_id, bill_status);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return appointment;
	}
	
	public boolean updateAppointment(Appointment appointment) throws SQLException{
		boolean status = false;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_APPOINTMENT_ID)) {
			preparedStatement.setDate(1, appointment.getDate());
			preparedStatement.setTime(2, appointment.getTime());
			preparedStatement.setString(3, appointment.getDuration());
			preparedStatement.setString(4, appointment.getStatus());
			preparedStatement.setString(5, appointment.getDescription());
			preparedStatement.setInt(6, appointment.getAppointment_id());
			preparedStatement.executeUpdate();
			status = true;
		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}
		
		return status;
	}
	
	public boolean deleteAppointment(int appointment_id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();) {
        	PreparedStatement statement = connection.prepareStatement(DELETE_APPOINTMENT_SQL);
            statement.setInt(1, appointment_id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
	
}
