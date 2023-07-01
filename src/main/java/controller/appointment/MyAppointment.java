package controller.appointment;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.AppointmentService;

import java.io.IOException;
import java.util.List;

import bean.Appointment;
import bean.Patient;

/**
 * Servlet implementation class MyAppointment
 */
@WebServlet("/my-appointment")
public class MyAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentService appointmentService;

	/**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		appointmentService = new AppointmentService();
	}
	
    public MyAppointment() { 
    	
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
//		Patient patient = new Patient();
		HttpSession session = request.getSession();
		int doc_id = (int) session.getAttribute("doctor_id");
		List<Appointment> listAppointment = appointmentService.selectAllAppointment(doc_id);
		request.setAttribute("listAppointment", listAppointment);
//		System.out.println();
		RequestDispatcher dispatcher = request.getRequestDispatcher("my-appointments.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

	}

}
