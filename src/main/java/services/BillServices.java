package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import bean.Bill;
import bean.Doctor;

public class BillServices {
	private String jdbcURL = "jdbc:mysql://localhost/doctorange";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private String SELECT_BILL_ID = "SELECT * FROM bill WHERE bill_id=?;";
	private String UPDATE_BILL_SQL = "UPDATE bill set date = ?,status= ?, amount =? where bill_id = ?;";
	private String INSERT_BILL_SQL = "INSERT INTO bill (date,status) VALUES (?,?);";
	private String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID();";
	private String DELETE_BILL_SQL = "DELETE FROM bill WHERE bill_id=?;";
	
	public BillServices() {

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

	public Bill getBillInformation(int id) {
		Bill bill = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BILL_ID)) {
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int bill_id = rs.getInt("bill_id");
				Date date = rs.getDate("date");
				String status = rs.getString("status");
				float amount = rs.getFloat("amount");

				bill = new Bill(bill_id, date, status, amount);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return bill;
	}

	public int insertDefaultBill(Date date) throws SQLException {
		int id  = 0;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_BILL_SQL);) {

			statement.setDate(1, date);
			statement.setString(2, "pending");
			statement.executeUpdate();
			
			PreparedStatement statement2 = connection.prepareStatement(SELECT_LAST_INSERT_ID);
			ResultSet rs = statement2.executeQuery();
			rs.next();
			id = Integer.valueOf(rs.getString(1));
		}catch (SQLException e) {
			printSQLException(e);
		}
		
		
		return id;
	}

	public boolean updateBill(Bill bill) throws SQLException {
		boolean status = false;

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BILL_SQL);) {
			statement.setDate(1, bill.getDate());
			statement.setString(2, bill.getStatus());
			statement.setFloat(3, bill.getAmount());
			statement.setInt(4, bill.getBill_id());

			status = statement.executeUpdate() > 0;
		}catch (SQLException e) {
			printSQLException(e);
		}

		return status;
	}
	
	public boolean deleteBill(int bill_id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();) {
        	PreparedStatement statement = connection.prepareStatement(DELETE_BILL_SQL);
            statement.setInt(1, bill_id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
