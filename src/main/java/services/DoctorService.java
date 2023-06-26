package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Doctor;



public class DoctorService {
	
	private String jdbcURL = "jdbc:mysql://localhost/doctorange";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
	
	private String SELECT_ALL_DOCTOR = "SELECT * FROM doctor;";
	private String INSERT_DOCTOR_SQL = "insert into doctor (name, email, password, specialization, phone, clinic_id) VALUES (?, ?, ?, ?, ?, ?)";
	
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
        for (Throwable e: ex) {
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
}
