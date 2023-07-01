package controller.appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AppointmentService;
import services.BillServices;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteAppointment
 */
public class DeleteAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentService appointmentService;
	private BillServices billServices;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		appointmentService = new AppointmentService();
		billServices = new BillServices();
	}

	public DeleteAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("appointmentId"));
		int bill_id = Integer.parseInt(request.getParameter("billId"));

		try {
			boolean statusAppointment = appointmentService.deleteAppointment(id);
			if (statusAppointment) {
				boolean statusBill = billServices.deleteBill(bill_id);
				if (statusBill) {
					response.sendRedirect(request.getContextPath() + "/my-appointment?delete=true");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/edit-appointment?id=" + id + "&delete=false");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
