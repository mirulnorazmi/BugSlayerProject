package controller.appointment;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AppointmentService;
import services.BillServices;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import bean.Appointment;
import bean.Bill;

/**
 * Servlet implementation class EditAppointment
 */
@WebServlet("/edit-appointment")
public class EditAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentService appointmentService;
	private BillServices billServices;
	
	public void init() {
		appointmentService = new AppointmentService();
		billServices = new BillServices();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Appointment appointment = new Appointment();
		Bill bill = new Bill();
		int id = Integer.parseInt(request.getParameter("id"));
		String success = request.getParameter("success");
		System.out.println("success : " + success);
		appointment = appointmentService.getOneAppointment(id);
		int appointment_id = appointment.getAppointment_id();
		bill = billServices.getBillInformation(appointment_id);
		
		request.setAttribute("appointment", appointment);
		request.setAttribute("bill", bill);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-appointment.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		int appointment_id = Integer.parseInt(request.getParameter("appointmentId"));
		Date date = Date.valueOf(request.getParameter("date"));
		Time time = Time.valueOf(request.getParameter("appointmentTime"));
		String duration = request.getParameter("duration");
		String status = request.getParameter("status");
		String description = request.getParameter("description");
		
		Appointment appointment = new Appointment(appointment_id, date, time, duration, status, description);
		
		System.out.println(appointment_id);
		System.out.println(date);
		System.out.println(time);
		System.out.println(duration);
		System.out.println(status);
		System.out.println(description);
		try {
			boolean statusUpdate = appointmentService.updateAppointment(appointment);
			if(statusUpdate) {
				response.sendRedirect(request.getContextPath() + "/edit-appointment?id=" + appointment.getAppointment_id() + "&success=true");
			}else {
				response.sendRedirect(request.getContextPath() + "/edit-appointment?id=" + appointment.getAppointment_id() + "&success=false");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
